package com.aotter.trek.admob.mediation.android.kotlin.demo

import com.google.android.gms.ads.nativead.NativeAd


data class LocalNativeAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val nativeAd: NativeAd? = null
)