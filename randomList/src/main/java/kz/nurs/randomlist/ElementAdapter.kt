package kz.nurs.randomlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementAdapter(private val context: Context) : RecyclerView.Adapter<ElementAdapter.ViewHolder>() {
    private var elements : List<Element> = ArrayList()

    fun setData(list: List<Element>) {
        this.elements = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_element, parent, false))
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentElement= elements[position]
        holder.type.text = currentElement.javaClass.simpleName
        holder.details.text = currentElement.getDetails()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val type: TextView = view.findViewById(R.id.tv_type)
        val details: TextView = view.findViewById(R.id.tv_details)
    }
}