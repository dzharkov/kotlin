/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.utils

import java.util.*

/**
 * A set which is optimized for small sizes and maintains the order in which the elements were added.
 * This set is not synchronized and it does not support removal operations such as [MutableSet.remove],
 * [MutableSet.removeAll] and [MutableSet.retainAll].
 * Also, [iterator] returns an iterator which does not support [MutableIterator.remove].
 */
@Suppress("UNCHECKED_CAST")
class SmartSet<T> private constructor() : AbstractSet<T>() {
    companion object {
        private val ARRAY_THRESHOLD = 5

        @JvmStatic
        fun <T> create() = SmartSet<T>()

        @JvmStatic
        fun <T> create(set: Set<T>) = SmartSet<T>().apply { this.addAll(set) }
    }

    // null if size = 0, object if size = 1, array of objects if size < threshold, linked hash set otherwise
    private var data: Any? = null

    override var size: Int = 0

    override fun iterator(): MutableIterator<T> = when {
            size == 0 -> Collections.emptySet<T>().iterator()
            size == 1 -> SingletonIterator(data as T)
            size < ARRAY_THRESHOLD -> ArrayIterator(data as Array<T>)
            else -> (data as MutableSet<T>).iterator()
        }

    override fun add(e: T): Boolean {
        when {
            size == 0 -> {
                data = e
            }
            size == 1 -> {
                if (data == e) return false
                data = arrayOf(data, e)
            }
            size < ARRAY_THRESHOLD -> {
                val arr = data as Array<T>
                if (e in arr) return false
                data = if (size == ARRAY_THRESHOLD - 1) linkedSetOf(*arr).apply { add(e) }
                else Arrays.copyOf(arr, size + 1).apply { set(size() - 1, e) }
            }
            else -> {
                val set = data as MutableSet<T>
                if (!set.add(e)) return false
            }
        }

        size++
        return true
    }

    override fun clear() {
        data = null
        size = 0
    }

    override fun contains(o: T): Boolean = when {
        size == 0 -> false
        size == 1 -> data == o
        size < ARRAY_THRESHOLD -> o in data as Array<T>
        else -> o in data as Set<T>
    }

    private inner class SingletonIterator<T>(private val element: T) : MutableIterator<T> {
        private var hasNext = true

        override fun next(): T =
                if (hasNext) {
                    hasNext = false
                    element
                }
                else throw NoSuchElementException()

        override fun hasNext() = hasNext

        override fun remove() {
            assert(size == 1) { "Usage of SingletonIterator with non-singleton set: ${size}" }
            clear()
        }
    }

    private inner class ArrayIterator<T>(private val array: Array<T>) : MutableIterator<T> {
        private var index = 0

        override fun hasNext(): Boolean = index < array.size
        override fun next(): T = array[index++]
        override fun remove() {
            size--

            if (size == 1) {
                data = array[index]
            }
            else {
                System.arraycopy(array, index, array, index - 1, array.size - index)
                index--
            }
        }
    }
}
