package kz.nurs.randomlist.model


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

data class Card(val date: Date?=null, val name: String?=null) : Element {

    override fun showDetails(context: Context): View {
        val view  = LayoutInflater.from(context).inflate(R.layout.card, null)
        val dateTv = view.findViewById<TextView>(R.id.card_date)
        val nameTv = view.findViewById<TextView>(R.id.name)
        val titleTv = view.findViewById<TextView>(R.id.title)
        titleTv.text = this.javaClass.simpleName
        date?.let {
            dateTv.text=it.toString()
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
        return Card(generateDate(), generateName())
    }

    private fun generateName(): String {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..10)
            .map { kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

    private fun generateDate(): Date {
        val localDate = LocalDate.now().minus(Period.ofDays((Random().nextInt(365 * 70))))
        return convertToDateViaInstant(localDate)
    }

    private fun convertToDateViaInstant(dateToConvert: LocalDate): Date {
        return Date.from(
            dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant()
        )
    }
}