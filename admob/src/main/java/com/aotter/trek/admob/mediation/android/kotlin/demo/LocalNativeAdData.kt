package com.aotter.trek.admob.mediation.android.kotlin.demo

import com.admob.mediation.kotlin.AdData

data class LocalNativeAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val adData: AdData? = null
)