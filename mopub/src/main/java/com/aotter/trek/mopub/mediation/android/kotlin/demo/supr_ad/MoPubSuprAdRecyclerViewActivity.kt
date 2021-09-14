package com.aotter.trek.mopub.mediation.android.kotlin.demo.supr_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aotter.trek.mopub.mediation.android.kotlin.demo.LocalNativeAdData
import com.aotter.trek.mopub.mediation.android.kotlin.demo.NativeAdAdapter
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.R
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.databinding.ActivityMoPubSuprAdRecyclerViewBinding
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.mediation.kotlin.ads.TrekMoPubAdRenderer
import com.mopub.mediation.kotlin.ads.TrekMoPubViewBinder
import com.mopub.nativeads.MoPubNativeAdPositioning
import com.mopub.nativeads.MoPubRecyclerAdapter

class MoPubSuprAdRecyclerViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMoPubSuprAdRecyclerViewBinding

    private lateinit var nativeAdAdapter: NativeAdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMoPubSuprAdRecyclerViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        iniView()

        getAd()

    }


    private fun iniView() {

        nativeAdAdapter = NativeAdAdapter()

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.moPubSuprAdRecyclerView.layoutManager = linearLayoutManager

        val list = mutableListOf<LocalNativeAdData>()

        repeat(12) {
            list.add(
                LocalNativeAdData(
                    "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                    "電獺少女",
                    "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg"
                )
            )
        }

        nativeAdAdapter.update(list)

    }

    private fun getAd() {

        val adPositioning = MoPubNativeAdPositioning.serverPositioning()

        val moPubAdapter = MoPubRecyclerAdapter(this, nativeAdAdapter, adPositioning)

        viewBinding.moPubSuprAdRecyclerView.adapter = moPubAdapter

        val sdkConfiguration = SdkConfiguration.Builder("e28dcd364c014dfdab714dd93db85067")
            .withLogLevel(MoPubLog.LogLevel.DEBUG)
            .withLegitimateInterestAllowed(false)
            .build()

        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener())

        val trekMoPubViewBinder = TrekMoPubViewBinder().Builder(R.layout.item_trek_media_view)
            .adContainerViewId(R.id.adContainer)
            .trekMoPubMediaViewId(R.id.trekMoPubMediaView)
            .build()

        val trekMoPubAdRenderer = TrekMoPubAdRenderer(trekMoPubViewBinder)

        moPubAdapter.registerAdRenderer(trekMoPubAdRenderer)

        moPubAdapter.loadAds("e28dcd364c014dfdab714dd93db85067")


    }

    private fun initSdkListener(): SdkInitializationListener {
        return SdkInitializationListener { Log.d("initSdkListener", "initSdkListener: ") }
    }


}