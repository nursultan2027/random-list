package kz.nurs.randomlist.model


import kz.nurs.randomlist.Element
import kz.nurs.randomlist.RandomHelper

class Move(
    var fromPlace: String?=null,
    val toPlace: String?=null,
    val estimateTime: Double?=null) : Element {

    override fun showDetails() {}

    override fun getDetails(): String {
        fromPlace?.let{
            return it
        }
        return "detail"
    }

    override fun generateRandom(): Element {
        return RandomHelper().generateMove()
    }
}