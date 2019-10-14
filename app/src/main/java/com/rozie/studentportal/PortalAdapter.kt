package com.rozie.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_for_portal.view.*

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_for_portal,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    private fun onItemClick(portal: Portal) {
        println("you clicked on $portal")
    }
//        Snackbar.make(
//            rvPortals,"you clicked on $portal", Snackbar.LENGTH_SHORT
//            ).show()
//  }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(portal: Portal) {
            itemView.tvTitle.text = portal.title
            itemView.tvUrl.text = portal.url
        }

        init {
            itemView.setOnClickListener { onItemClick(portals[adapterPosition]) }
        }
    }
}