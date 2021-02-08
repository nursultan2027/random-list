package kz.nurs.randomlist

import kz.nurs.randomlist.model.Event
import kz.nurs.randomlist.model.Move
import kz.nurs.randomlist.model.Notice
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

class RandomHelper {

    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun generateElementsCount(): Int {
        return kotlin.random.Random.nextInt(10, 100)
    }

    fun generateEvent(): Event {
        return Event(generateDate(), generateDate(), generateName())
    }

    fun generateNotice(): Notice {
        return Notice(generateDate(), generateName())
    }

    fun generateMove(): Move {
        return Move(generateName(), generateName(), generateDouble())
    }

    private fun generateDouble(): Double {
        return kotlin.random.Random.nextDouble(0.0, 10.0)
    }

    private fun generateName(): String {
        return (1..10)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
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