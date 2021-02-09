package kz.nurs.randomlist.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R
import kz.nurs.randomlist.RandomElements
//import kz.nurs.randomlist.model.Card

class DetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val element = intent.getSerializableExtra("element") as Element
        setContentView(element.showDetails(this))
    }
}