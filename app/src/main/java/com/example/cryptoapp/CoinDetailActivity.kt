package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: ""
        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(CoinViewModel::class.java)
        viewModel.getDetailInfo(fromSymbol).observe(this) {
            findViewById<TextView>(R.id.tvPrice).text = it.price
            findViewById<TextView>(R.id.tvMinPrice).text = it.lowDay
            findViewById<TextView>(R.id.tvMaxPrice).text = it.nightDay
            findViewById<TextView>(R.id.tvLastMarket).text = it.lastMarket
            findViewById<TextView>(R.id.tvLastUpdate).text = it.getFormattedTime()
            findViewById<TextView>(R.id.tvFromSymbol).text = it.fromSymbol
            findViewById<TextView>(R.id.tvToSymbol).text = it.toSymbol
            val ivLogoCoin = findViewById<ImageView>(R.id.ivLogoCoin)
            Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cleared()
    }
}