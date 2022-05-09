package com.aotter.max.mediation.demo.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aotter.max.mediation.demo.AdViewCreator
import com.aotter.max.mediation.demo.databinding.ActivityNativeAdScrollViewBinding
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxError
import com.applovin.mediation.nativeAds.MaxNativeAdListener
import com.applovin.mediation.nativeAds.MaxNativeAdLoader
import com.applovin.mediation.nativeAds.MaxNativeAdView
import com.max.mediation.TrekMaxDataKey

class NativeAdScrollViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityNativeAdScrollViewBinding

    private var nativeAdMap = hashMapOf<MaxNativeAdLoader, MaxAd?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityNativeAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.refreshBtn.setOnClickListener {

            viewBinding.adContainer.removeAllViews()

            destroyAd()

            getAd(6)

        }

        getAd(6)

    }

    private fun getAd(count: Int) {

        val adUnitId: String

        val maxNativeAdView: MaxNativeAdView

        if (count % 2 == 0) {
            adUnitId = "7d2567538a1583dd"
            maxNativeAdView = AdViewCreator.createNativeAdView(this)
        } else {
            adUnitId = "b5d5b987941bf502"
            maxNativeAdView = AdViewCreator.createNativeAdView2(this)
        }

        val nativeAdLoader = MaxNativeAdLoader(adUnitId, this)

        nativeAdLoader.setNativeAdListener(object : MaxNativeAdListener() {

            override fun onNativeAdLoaded(maxNativeAdView: MaxNativeAdView?, maxAd: MaxAd?) {

                nativeAdMap[nativeAdLoader] = maxAd

                viewBinding.adContainer.addView(maxNativeAdView)

                val times = count - 1

                if (times > 0) {

                    getAd(times)

                }

            }

            override fun onNativeAdLoadFailed(p0: String?, p1: MaxError?) {

                Log.e("nativeAdLoader", p1.toString())

            }

            override fun onNativeAdClicked(p0: MaxAd?) {

                Log.e("nativeAdLoader", "onNativeAdClicked")

            }
        })

        nativeAdLoader.setLocalExtraParameter(TrekMaxDataKey.CATEGORY, "news")
        nativeAdLoader.setLocalExtraParameter(
            TrekMaxDataKey.CONTENT_URL,
            "https://agirls.aotter.net/"
        )
        nativeAdLoader.setLocalExtraParameter(TrekMaxDataKey.CONTENT_TITLE, "電獺少女")

        nativeAdLoader.loadAd(maxNativeAdView)

    }


    private fun destroyAd() {

        nativeAdMap.forEach {

            val nativeAdLoader = it.key

            val nativeAd = it.value

            nativeAdLoader.destroy(nativeAd)

        }

    }

    override fun onDestroy() {
        super.onDestroy()

        destroyAd()

    }


}