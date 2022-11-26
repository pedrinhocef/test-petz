package com.challange.homecards.view.diff

import androidx.recyclerview.widget.DiffUtil
import com.challange.network.model.HeartStoneRareResponseItem

class HeartStoneListDiffCallback constructor(
    private val oldList: List<HeartStoneRareResponseItem>,
    private val newList: List<HeartStoneRareResponseItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        true
}