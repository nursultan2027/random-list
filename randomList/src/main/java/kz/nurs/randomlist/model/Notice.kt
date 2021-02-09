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

data class Notice(val flightData: Date?=null, val gate: String?=null) : Element{

    override fun showDetails(context: Context): View {
        val view  = LayoutInflater.from(context).inflate(R.layout.notice, null)
        val dateTv = view.findViewById<TextView>(R.id.date)
        val gateTv = view.findViewById<TextView>(R.id.gate)
        val titleTv = view.findViewById<TextView>(R.id.title)
        titleTv.text = this.javaClass.simpleName
        flightData?.let {
            dateTv.text=it.toString()
        }
        gate?.let {
            gateTv.text=it
        }
        return view
    }

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