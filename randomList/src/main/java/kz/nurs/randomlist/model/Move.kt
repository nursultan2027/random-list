package kz.nurs.randomlist.model


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R
import kz.nurs.randomlist.RandomHelper
import java.io.Serializable

class Move(
    var fromPlace: String?=null,
    val toPlace: String?=null,
    val estimateTime: Double?=null) : Element {

    override fun showDetails(context: Context): View {
        val view  = LayoutInflater.from(context).inflate(R.layout.move, null)
        val fromPlaceTv = view.findViewById<TextView>(R.id.from_place)
        val toPlacetv = view.findViewById<TextView>(R.id.to_place)
        val estimateTimeTv = view.findViewById<TextView>(R.id.estimateTime)
        val titleTv = view.findViewById<TextView>(R.id.title)
        titleTv.text = this.javaClass.simpleName
        fromPlace?.let {
            fromPlaceTv.text=it
        }
        toPlace?.let {
            toPlacetv.text=it
        }
        estimateTime?.let {
            estimateTimeTv.text=it.toString()
        }
        return view
    }

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