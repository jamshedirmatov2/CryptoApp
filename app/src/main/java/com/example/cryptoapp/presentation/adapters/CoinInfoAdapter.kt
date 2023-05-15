package com.example.cryptoapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter : ListAdapter<CoinInfo, CoinInfoViewHolder>(CoinInfoDiffCallback) {

    private var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                tvSymbols.text = "$fromSymbol / $toSymbol"
                tvPrice.text = price
                tvLastUpdate.text = "Время последнего обновления $lastUpdate"
                Picasso.get().load(imageUrl).into(ivLogoCoin)
            }
            root.setOnClickListener { onCoinClickListener?.onCoinClick(coin) }
        }
    }

    fun setOnCoinClickListener(onCoinClickListener: OnCoinClickListener) {
        this.onCoinClickListener = onCoinClickListener
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinInfo)
    }
}