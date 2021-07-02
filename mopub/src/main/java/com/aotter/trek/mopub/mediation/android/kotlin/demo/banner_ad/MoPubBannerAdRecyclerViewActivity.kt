package com.aotter.trek.mopub.mediation.android.kotlin.demo.banner_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.databinding.ActivityMoPubBannerAdRecyclerViewBinding
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.mediation.kotlin.TrekMoPubDataKey

class MoPubBannerAdRecyclerViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMoPubBannerAdRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMoPubBannerAdRecyclerViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        getAd()

    }

    private fun getAd() {

        val sdkConfiguration = SdkConfiguration.Builder("e439101a985f447a929c9799bc67ec0c")
            .withLogLevel(MoPubLog.LogLevel.DEBUG)
            .withLegitimateInterestAllowed(false)
            .build()

        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener())

        viewBinding.mopubBannerView.setAdUnitId("e439101a985f447a929c9799bc67ec0c")

        val hasMap = hashMapOf(TrekMoPubDataKey.CATEGORY to "news")

        viewBinding.mopubBannerView.setLocalExtras(hasMap)

        viewBinding.mopubBannerView.loadAd()


    }

    private fun initSdkListener(): SdkInitializationListener {
        return SdkInitializationListener { Log.d("initSdkListener", "initSdkListener: ") }
    }

    override fun onDestroy() {
        super.onDestroy()

        viewBinding.mopubBannerView.destroy()

    }

}