package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation

import com.google.android.gms.ads.nativead.NativeAd

data class LocalAdmobSuprAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val nativeAd: NativeAd? = null
)