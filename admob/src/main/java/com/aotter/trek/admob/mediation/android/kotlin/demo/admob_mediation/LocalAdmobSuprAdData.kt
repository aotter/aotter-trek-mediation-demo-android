package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation

import com.admob.mediation.kotlin.AdData
import com.google.android.gms.ads.nativead.NativeAd

data class LocalAdmobSuprAdData(
    val title: String,
    val advertiser: String,
    val img: String,
    val adData: AdData? = null,
    val nativeAd: NativeAd? = null
)