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
        binding.tvDetailName.text = getString(R.string.card_detail_name, heartStoneRareResponseItem.name)
        binding.tvDetailFaction.text = getString(R.string.card_detail_faction, heartStoneRareResponseItem.faction)
        binding.tvDetailFlavor.text = getString(R.string.card_detail_flavor, heartStoneRareResponseItem.flavor)
        binding.tvDetailHealth.text = getString(R.string.card_detail_health, heartStoneRareResponseItem.health.toString())
        binding.tvDetailType.text = getString(R.string.card_detail_type, heartStoneRareResponseItem.type)
        binding.tvDetailAttack.text = getString(R.string.card_detail_attack, heartStoneRareResponseItem.health.toString())
        binding.tvDetailCost.text = getString(R.string.card_detail_cost, heartStoneRareResponseItem.cost.toString())
        binding.tvDetailRarity.text = getString(R.string.card_detail_rarity, heartStoneRareResponseItem.rarity)
        binding.tvDetailSet.text = getString(R.string.card_detail_set, heartStoneRareResponseItem.cardSet)
        binding.tvDetailShortDescription.text = getString(R.string.card_detail_short_description, Html.fromHtml(heartStoneRareResponseItem.text ?: "", Html.FROM_HTML_MODE_LEGACY))
    }
}