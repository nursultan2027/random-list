package kz.nurs.randomlist

interface Element {
    fun showDetails()
    fun getDetails(): String
    fun generateRandom():Element
}