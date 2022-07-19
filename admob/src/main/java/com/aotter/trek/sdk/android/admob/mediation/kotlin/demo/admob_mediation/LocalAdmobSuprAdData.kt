package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation

import com.google.android.gms.ads.nativead.NativeAd

data class LocalAdmobSuprAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val nativeAd: NativeAd? = null
)