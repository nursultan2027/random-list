package kz.nurs.randomlist

import android.content.Context
import android.view.View
import java.io.Serializable

interface Element : Serializable{
    fun showDetails(context: Context): View
    fun getDetails(): String
    fun generateRandom():Element
}