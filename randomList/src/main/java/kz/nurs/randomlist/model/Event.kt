package kz.nurs.randomlist.model


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R
import kz.nurs.randomlist.RandomHelper
import java.io.Serializable
import java.util.*

class Event(
    var startTime: Date?=null,
    val endTime: Date?=null,
    val name: String?=null) : Element {

    override fun showDetails(context: Context): View {
        val view  = LayoutInflater.from(context).inflate(R.layout.event, null)
        val startTimeTv = view.findViewById<TextView>(R.id.start_time)
        val endTimeTv = view.findViewById<TextView>(R.id.end_time)
        val nameTv = view.findViewById<TextView>(R.id.name)
        val titleTv = view.findViewById<TextView>(R.id.title)
        titleTv.text = this.javaClass.simpleName
        startTime?.let {
            startTimeTv.text=it.toString()
        }
        endTime?.let {
            endTimeTv.text=it.toString()
        }
        name?.let {
            nameTv.text=it
        }
        return view
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