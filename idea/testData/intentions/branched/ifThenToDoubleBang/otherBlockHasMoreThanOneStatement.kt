// IS_APPLICABLE: false
fun main(args: Array<String>) {
    val foo: String? = null

    if (foo != null<caret>) {
        foo
    }
    else {
        print ("Hello")
        throw NullPointerException("'foo' must not be null")
    }
}
