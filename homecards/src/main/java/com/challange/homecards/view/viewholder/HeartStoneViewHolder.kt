package com.challange.homecards.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.challange.homecards.R
import com.challange.homecards.databinding.ItemMainHeartStoneBinding
import com.challange.network.model.BasicItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class HeartStoneViewHolder(
    private val binding: ItemMainHeartStoneBinding,
    private val clickListener: (BasicItem) -> Unit
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var basicItem: BasicItem

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(basicItem: BasicItem) {
        this.basicItem = basicItem
        binding.imgItemHearStone.contentDescription = basicItem.name
        binding.progressImageHeartStone.visibility = View.VISIBLE

        Picasso.get()
            .load(basicItem.img)
            .error(R.drawable.ic_alert_circle)
            .into(binding.imgItemHearStone, object : Callback {
                override fun onSuccess() {
                    binding.progressImageHeartStone.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    binding.progressImageHeartStone.visibility = View.GONE
                }
            })
    }

    override fun onClick(v: View?) {
        v?.let { clickListener.invoke(basicItem) }
    }
}