package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.utils.convertTimestampToTime
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,
    @SerializedName("MARKET")
    @Expose
    val market: String? = null,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String = "",
    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,
    @SerializedName("FLAGS")
    @Expose
    val flags: String? = null,
    @SerializedName("PRICE")
    @Expose
    val price: String? = null,
    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,
    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: String? = null,
    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: String? = null,
    @SerializedName("LASTTRADEID")
    @Expose
    val lastTradeId: String? = null,
    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: String? = null,
    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: String? = null,
    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24Hour: String? = null,
    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: String? = null,
    @SerializedName("OPENDAY")
    @Expose
    val openDay: String? = null,
    @SerializedName("NIGHTDAY")
    @Expose
    val nightDay: String? = null,
    @SerializedName("LOWDAY")
    @Expose
    val lowDay: String? = null,
    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: String? = null,
    @SerializedName("NIGHT24HOUR")
    @Expose
    val night24Hour: String? = null,
    @SerializedName("LOW24HOUR")
    @Expose
    val low24Hour: String? = null,
    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,
    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: String? = null,
    @SerializedName("VOLUMEHOURTO")
    @Expose
    val volumeHourTo: String? = null,
    @SerializedName("OPENHOUR")
    @Expose
    val openHour: String? = null,
    @SerializedName("NIGHTHOUR")
    @Expose
    val nightHour: String? = null,
    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: String? = null,
    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24Hour: String? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: String? = null,
    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24Hour: String? = null,
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changePCT24Hour: String? = null,
    @SerializedName("CHANGEDAY")
    @Expose
    val changeDay: String? = null,
    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changePCTDay: String? = null,
    @SerializedName("SUPPLY")
    @Expose
    val supply: String? = null,
    @SerializedName("MKTCAP")
    @Expose
    val mktCap: String? = null,
    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolume24Hour: String? = null,
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolume24HourTo: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totalTopTierVolume24Hour: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totalTopTierVolume24HourTo: String? = null,
    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String? = null,
) {
    fun getFormattedTime(): String = convertTimestampToTime(lastUpdate)

    fun getFullImageUrl() = BASE_IMAGE_URL + imageUrl
}