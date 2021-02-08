package kz.nurs.randomlist.model


import kz.nurs.randomlist.Element
import kz.nurs.randomlist.RandomHelper
import java.util.*

class Event(
    var startTime: Date?=null,
    val endTime: Date?=null,
    val name: String?=null) : Element {

    override fun showDetails() {

    }

    override fun getDetails(): String {
        name?.let {
            return it
        }
        return "detail"
    }

    override fun generateRandom(): Element {
        return RandomHelper().generateEvent()
    }
}