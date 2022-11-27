package com.challange.homecards.view.ui

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.challange.homecards.R
import com.challange.homecards.databinding.DetailCardActivityBinding
import com.challange.navigation.details.DetailFeatureNavigation.EXTRA_RARE_ITEM
import com.challange.network.model.HeartStoneRareResponseItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailCardActivityBinding
    private lateinit var heartStoneRareResponseItem: HeartStoneRareResponseItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailCardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.getParcelable(EXTRA_RARE_ITEM, HeartStoneRareResponseItem::class.java)
            ?.let {
                heartStoneRareResponseItem = it
            }
        populateDetailActivity(heartStoneRareResponseItem)

    }

    private fun populateDetailActivity(heartStoneRareResponseItem: HeartStoneRareResponseItem) {

        Picasso.get()
            .load(heartStoneRareResponseItem.img)
            .error(R.drawable.ic_alert_circle)
            .into(binding.ivDetailCard, object : Callback {
                override fun onSuccess() {
                    binding.progressBarDetail.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    binding.progressBarDetail.visibility = View.GONE
                }
            })

        bindingOfItems(heartStoneRareResponseItem)
    }

    private fun bindingOfItems(heartStoneRareResponseItem: HeartStoneRareResponseItem) {
        binding.tvDetailName.text = heartStoneRareResponseItem.name
        binding.tvDetailFaction.text = heartStoneRareResponseItem.faction
        binding.tvDetailFlavor.text = heartStoneRareResponseItem.flavor
        binding.tvDetailHealth.text = heartStoneRareResponseItem.health.toString()
        binding.tvDetailType.text = heartStoneRareResponseItem.type
        binding.tvDetailAttack.text = heartStoneRareResponseItem.health.toString()
        binding.tvDetailCost.text = heartStoneRareResponseItem.cost.toString()
        binding.tvDetailRarity.text = heartStoneRareResponseItem.rarity
        binding.tvDetailSet.text = heartStoneRareResponseItem.cardSet
        binding.tvDetailShortDescription.text =
            (Html.fromHtml(heartStoneRareResponseItem.text ?: "", Html.FROM_HTML_MODE_LEGACY))
    }
}