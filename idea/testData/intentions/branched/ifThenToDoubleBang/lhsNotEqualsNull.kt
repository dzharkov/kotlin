fun maybeFoo(): String? {
    return "foo"
}

fun main(args: Array<String>) {
    val foo = maybeFoo()
    if (foo != null<caret>)
        foo
    else
        throw NullPointerException("'foo' must not be null")
}
