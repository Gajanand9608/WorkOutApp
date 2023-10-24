package com.example.workoutapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemsRowHistoryBinding

class ItemAdapter(private val items: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ItemsRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val clHistory = binding.clHistoryItem
        val tvOrder = binding.tvOrderNo
        val tvDate = binding.tvDate

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsRowHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date : String = items[position]
        holder.tvOrder.text = (position+1).toString()
        holder.tvDate.text = date
        if(position%2==0){
            holder.clHistory.setBackgroundColor(Color.parseColor("#EBEBEB"))

        }else{
            holder.clHistory.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
    }
}