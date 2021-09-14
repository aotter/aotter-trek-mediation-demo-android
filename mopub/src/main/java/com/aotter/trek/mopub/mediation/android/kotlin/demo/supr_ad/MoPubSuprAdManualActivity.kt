package com.aotter.trek.mopub.mediation.android.kotlin.demo.supr_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.R
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.databinding.ActivityMoPubSuprAdManualBinding
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.mediation.kotlin.TrekMoPubDataKey
import com.mopub.mediation.kotlin.ads.TrekMoPubAdRenderer
import com.mopub.mediation.kotlin.ads.TrekMoPubViewBinder
import com.mopub.nativeads.*

class MoPubSuprAdManualActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMoPubSuprAdManualBinding

    private lateinit var adapterHelper: AdapterHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMoPubSuprAdManualBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        adapterHelper = AdapterHelper(this, 0, 3) // When standalone, any range will be fine.

        getAd()

    }

    private fun getAd() {

        val sdkConfiguration = SdkConfiguration.Builder("e28dcd364c014dfdab714dd93db85067")
            .withLogLevel(MoPubLog.LogLevel.DEBUG)
            .withLegitimateInterestAllowed(false)
            .build()

        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener())

        val moPubNative =
            MoPubNative(this, "e28dcd364c014dfdab714dd93db85067", moPubNativeNetworkListener)

        val hasMap = hashMapOf<String, Any>(TrekMoPubDataKey.CATEGORY to "news")

        moPubNative.setLocalExtras(hasMap)

        val trekMoPubViewBinder = TrekMoPubViewBinder().Builder(R.layout.item_trek_media_view)
            .adContainerViewId(R.id.adContainer)
            .trekMoPubMediaViewId(R.id.trekMoPubMediaView)
            .build()

        val trekMoPubAdRenderer = TrekMoPubAdRenderer(trekMoPubViewBinder)

        moPubNative.registerAdRenderer(trekMoPubAdRenderer)

        moPubNative.makeRequest()

    }

    private val moPubNativeNetworkListener = object : MoPubNative.MoPubNativeNetworkListener {
        override fun onNativeLoad(nativeAd: NativeAd) {
            Log.e("moPubNativeListener", "onNativeLoad")

            val view =
                adapterHelper.getAdView(
                    null,
                    null,
                    nativeAd,
                    ViewBinder.Builder(0).build()
                )

            viewBinding.linearLayout.addView(view)

        }

        override fun onNativeFail(nativeErrorCode: NativeErrorCode) {
            Log.e("moPubNativeListener", nativeErrorCode.name)
        }

    }

    private fun initSdkListener(): SdkInitializationListener {
        return SdkInitializationListener { Log.d("initSdkListener", "initSdkListener: ") }
    }

}