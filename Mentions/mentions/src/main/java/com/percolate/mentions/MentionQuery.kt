package com.percolate.mentions


sealed class MentionQuery {
    open fun filter(string: String): Boolean = false
}
data class ValidQuery(val query: String) : MentionQuery() {
    override fun filter(string: String): Boolean = string.contains(query, true)
}
object EmptyQuery : MentionQuery() {
    override fun filter(string: String): Boolean = true
}
object InvalidQuery : MentionQuery()
object NoQuery : MentionQuery()