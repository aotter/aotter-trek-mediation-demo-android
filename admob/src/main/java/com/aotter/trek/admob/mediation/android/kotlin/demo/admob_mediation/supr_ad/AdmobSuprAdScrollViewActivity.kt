package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation.supr_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.AdData
import com.admob.mediation.kotlin.TrekAdmobAdViewBinder
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventNative
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityAdmobSuprAdScrollViewBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest


class AdmobSuprAdScrollViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAdmobSuprAdScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAdmobSuprAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        loadAdmobSuprAd()

//        loadAdmobSuprAd2()

    }

    private fun loadAdmobSuprAd() {

        val adUnit = "ca-app-pub-8836593984677243/4613662079"

        val adLoader = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                val adData =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.AD_DATA) as? AdData

                adData?.let {

                    TrekAdmobAdViewBinder.bindingAdView(adData, viewBinding.admobNativeView)

                    viewBinding.admobNativeView.mediaView = viewBinding.admobMediaView

                    viewBinding.admobNativeView.setNativeAd(nativeAd)

                }


            }
            .withAdListener(object : AdListener() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    Log.e("adLoader", "onAdClicked")
                }

                override fun onAdImpression() {
                    super.onAdImpression()

                    Log.e("adLoader", "onAdImpression")

                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Log.e("adLoader", "onAdLoaded")
                }
            })
            .build()

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")
        bundle.putString(TrekAdmobDataKey.CONTENT_URL, "https://agirls.aotter.net/")
        bundle.putString(TrekAdmobDataKey.CONTENT_TITLE, "電獺少女")

        val adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader.loadAd(adRequest)
    }

    private fun loadAdmobSuprAd2() {

        val adUnit = "ca-app-pub-8836593984677243/4613662079"

        val adLoader = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                viewBinding.admobNativeView2.mediaView = viewBinding.admobMediaView2

                viewBinding.admobNativeView2.setNativeAd(nativeAd)

            }
            .withAdListener(object : AdListener() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    Log.e("adLoader", "onAdClicked2")
                }

                override fun onAdImpression() {
                    super.onAdImpression()

                    Log.e("adLoader", "onAdImpression2")

                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Log.e("adLoader", "onAdLoaded2")
                }
            })
            .build()

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")
        bundle.putString(TrekAdmobDataKey.CONTENT_URL, "https://agirls.aotter.net/")
        bundle.putString(TrekAdmobDataKey.CONTENT_TITLE, "電獺少女")

        val adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()


        adLoader.loadAd(adRequest)
    }

}