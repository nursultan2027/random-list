package kz.nurs.randomlist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R
import kz.nurs.randomlist.RandomElements
import kz.nurs.randomlist.model.Card

class ElementsActivity : AppCompatActivity(), ElementAdapter.OnClickElement {
    private lateinit var adapter: ElementAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var random: RandomElements

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elements)
        random = RandomElements()

        //----adding new type----------
        random.addNewType(Card())
        //-----------------------------

        adapter = ElementAdapter(this)
        recyclerView = findViewById(R.id.rv_elements_recycler)
        recyclerView.adapter = adapter
        val dataList = random.generateData()
        adapter.setData(dataList)
        Toast.makeText(this, "generated list size:${dataList.size}", Toast.LENGTH_LONG).show()
    }

    override fun onClick(element: Element) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("element", element)
        startActivity(intent)
    }
}