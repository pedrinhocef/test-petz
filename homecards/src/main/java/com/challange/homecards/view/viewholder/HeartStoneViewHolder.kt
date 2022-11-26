package com.challange.homecards.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.challange.homecards.R
import com.challange.homecards.databinding.ItemMainHeartStoneBinding
import com.challange.network.model.HeartStoneRareResponseItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class HeartStoneViewHolder(
    private val binding: ItemMainHeartStoneBinding,
    private val clickListener: (HeartStoneRareResponseItem) -> Unit
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var basicItem: HeartStoneRareResponseItem

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(rareResponseItem: HeartStoneRareResponseItem) {
        this.basicItem = rareResponseItem

        binding.tvNameItemHearStone.text = rareResponseItem.name
        binding.tvRarityItemHearStone.text = rareResponseItem.rarity
        binding.tvCostItemHearStone.text = rareResponseItem.cost.toString()
        binding.tvFactionItemHearStone.text = rareResponseItem.faction
        binding.progressImageHeartStone.visibility = View.VISIBLE

        Picasso.get()
            .load(rareResponseItem.img)
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