package com.example.cryptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.adapters.CoinInfoAdapter
import com.example.cryptoapp.pojo.CoinPriceInfo

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CoinInfoAdapter()
        adapter.setOnCoinClickListener(object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent =
                    CoinDetailActivity.newIntent(this@MainActivity, coinPriceInfo.fromSymbol)
                startActivity(intent)
            }
        })
        val rv = findViewById<RecyclerView>(R.id.rvCoinPriceList)
        rv.adapter = adapter

        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(CoinViewModel::class.java)
        viewModel.priceList.observe(this) {
            adapter.coinInfoList = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cleared()
    }
}