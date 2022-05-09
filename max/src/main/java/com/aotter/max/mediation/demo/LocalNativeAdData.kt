package com.aotter.max.mediation.demo

import com.applovin.mediation.nativeAds.MaxNativeAdView

data class LocalNativeAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val maxNativeAdView: MaxNativeAdView? = null
)