package kz.nurs.randomlist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.nurs.randomlist.Element
import kz.nurs.randomlist.R

class ElementAdapter(private val listener: OnClickElement) : RecyclerView.Adapter<ElementAdapter.ViewHolder>() {
    private var elements : List<Element> = ArrayList()

    fun setData(list: List<Element>) {
        this.elements = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_element, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentElement= elements[position]
        holder.type.text = currentElement.javaClass.simpleName
        holder.details.text = currentElement.getDetails()
        holder.itemView.setOnClickListener {
            listener.onClick(currentElement)
        }
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val type: TextView = view.findViewById(R.id.tv_type)
        val details: TextView = view.findViewById(R.id.tv_details)
    }

    interface OnClickElement{
        fun onClick(element: Element)
    }
}