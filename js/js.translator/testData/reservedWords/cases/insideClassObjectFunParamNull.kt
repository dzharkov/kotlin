package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

class TestClass {
    default object {
        fun foo(`null`: String) {
    assertEquals("123", `null`)
    testRenamed("null", { `null` })
}

        fun test() {
            foo("123")
        }
    }
}

fun box(): String {
    TestClass.test()

    return "OK"
}