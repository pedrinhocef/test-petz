package com.challange.homecards.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.challange.homecards.R
import com.challange.network.model.BasicItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class HeartStoneViewHolder constructor(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.findViewById<ImageView>(R.id.imgMainItemProduct)
    private val progress = itemView.findViewById<ProgressBar>(R.id.progressImageProduct)

    fun bind(basicItem: BasicItem) {

        imageView.contentDescription = basicItem.name
        progress.visibility = View.VISIBLE

        Picasso.get()
            .load(basicItem.img)
            .error(R.drawable.ic_alert_circle)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    progress.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    progress.visibility = View.GONE
                }
            })
    }
}