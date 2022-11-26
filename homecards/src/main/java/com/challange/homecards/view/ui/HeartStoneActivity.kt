package com.challange.homecards.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.challange.homecards.R
import com.challange.homecards.databinding.HeartStoneActivityBinding
import com.challange.homecards.di.HeartStoneComponent
import com.challange.homecards.helper.observeResource
import com.challange.homecards.view.adapter.HeartStoneAdapter
import com.challange.homecards.view.viewmodel.HeartStoneViewModel
import com.challange.navigation.details.DetailFeatureNavigation
import com.challange.network.model.HeartStoneRareResponseItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeartStoneActivity : AppCompatActivity() {

    private val heartStoneAdapter: HeartStoneAdapter by lazy {
        HeartStoneAdapter {
            DetailFeatureNavigation.openDetailsFeatureNavigation(this, it)
        }
    }
    private val viewModel by viewModel<HeartStoneViewModel>()
    private lateinit var binding: HeartStoneActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HeartStoneActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        HeartStoneComponent.inject()

        setupRecyclers()
        viewModel.getHeartStoneResponse()
        observerVMEvents()

    }

    private fun observerVMEvents() {
        viewModel.heartStone.observeResource(this,
            onSuccess = { heartStoneRareResponseItem ->
                populateHeartStone(heartStoneRareResponseItem)
                heartStoneRareResponseItem?.let { it -> viewModel.addCache(it) }
            },
            onLoading = {
                showLoading()
            },
            onError = {
                viewModel.getHeartStoneCacheCache()?.let { heartStoneRareResponseItem ->
                    populateHeartStone(heartStoneRareResponseItem)
                    showSuccess()
                }?.run {
                    showErrorMessage()
                }
            }
        )

        viewModel.errorDataNull.observe(this){
            if (it) {
                showErrorMessage()
            }
        }
    }

    private fun populateHeartStone(it: List<HeartStoneRareResponseItem>) {
        showSuccess()
        it.let { heartStoneRareItem ->
            heartStoneAdapter.stoneRareResponseItems = heartStoneRareItem
        }
    }

    private fun showSuccess() {
        binding.progressHeartStone.hide()
        binding.recyHeartStone.visibility = View.VISIBLE
    }

    private fun showLoading() {
        binding.progressHeartStone.show()
        binding.recyHeartStone.visibility = View.GONE
    }

    private fun showErrorMessage() {
        val message = getString(R.string.error)
        binding.recyHeartStone.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setupRecyclers() {
        binding.recyHeartStone.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyHeartStone.adapter = heartStoneAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.deleteCache()
    }
}