package com.challange.homecards.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.challange.homecards.databinding.ItemMainHeartStoneBinding
import com.challange.homecards.view.diff.HeartStoneListDiffCallback
import com.challange.homecards.view.viewholder.HeartStoneViewHolder
import com.challange.network.model.HeartStoneRareResponseItem

class HeartStoneAdapter(private val clickListener: (HeartStoneRareResponseItem) -> Unit) : RecyclerView.Adapter<HeartStoneViewHolder>() {

    var stoneRareResponseItems = emptyList<HeartStoneRareResponseItem>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                HeartStoneListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeartStoneViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainHeartStoneBinding.inflate(inflater, parent, false)
        return HeartStoneViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: HeartStoneViewHolder, position: Int) {
        holder.bind(stoneRareResponseItems[position])
    }

    override fun getItemCount(): Int =
        stoneRareResponseItems.size
}