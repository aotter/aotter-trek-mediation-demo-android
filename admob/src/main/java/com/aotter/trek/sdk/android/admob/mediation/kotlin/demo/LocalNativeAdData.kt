package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo

import com.aotter.net.dto.trek.response.TrekNativeAd


data class LocalNativeAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val trekNativeAd: TrekNativeAd? = null
)