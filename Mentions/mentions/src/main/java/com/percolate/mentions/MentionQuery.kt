package com.percolate.mentions


sealed class MentionQuery {
    open fun filter(string: String): Boolean = false
}

/** @ + valid string ==> Example: "@hello" */
data class ValidQuery(val query: String) : MentionQuery() {
    override fun filter(string: String): Boolean = string.contains(query, true)
}

/** @ + empty string ==> Example: "@" */
object EmptyQuery : MentionQuery() {
    override fun filter(string: String): Boolean = true
}

/** @ + invalid (non-alphanumeric) string ==> Example: "@@", "hello@", "@-" */
object InvalidQuery : MentionQuery()

/** No @ ==> Example: "", "hello" */
object NoQuery : MentionQuery()