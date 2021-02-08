package kz.nurs.randomlist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kz.nurs.randomlist.ElementAdapter
import kz.nurs.randomlist.R
import kz.nurs.randomlist.RandomElements

class ElementsActivity : AppCompatActivity() {
    private lateinit var adapter: ElementAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elements)
        adapter = ElementAdapter(this)
        recyclerView = findViewById(R.id.rv_elements_recycler)
        recyclerView.adapter = adapter
        adapter.setData(RandomElements().generateData())
    }


}