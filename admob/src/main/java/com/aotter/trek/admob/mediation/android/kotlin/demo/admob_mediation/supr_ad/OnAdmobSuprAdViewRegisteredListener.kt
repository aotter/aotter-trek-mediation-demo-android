package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation.supr_ad

import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAdView

interface OnAdmobSuprAdViewRegisteredListener {

    fun onAdViewRegistered(nativeAdView: NativeAdView, mediaView: MediaView)

}