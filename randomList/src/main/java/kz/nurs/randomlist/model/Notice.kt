package kz.nurs.randomlist.model


import kz.nurs.randomlist.Element
import kz.nurs.randomlist.RandomHelper
import java.util.*

data class Notice(val flightData: Date?=null, val gate: String?=null) : Element {

    override fun showDetails() {}

    override fun getDetails(): String {
        gate?.let {
            return it
        }
        return "detail"
    }

    override fun generateRandom(): Element {
        return RandomHelper().generateNotice()
    }
}