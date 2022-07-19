package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.supr_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

                viewBinding.admobNativeView.mediaView = viewBinding.admobMediaView

                viewBinding.admobNativeView.setNativeAd(nativeAd)

            }
            .withAdListener(object : AdListener() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    Log.i("adLoader", "onAdClicked")
                }

                override fun onAdImpression() {
                    super.onAdImpression()

                    Log.i("adLoader", "onAdImpression")

                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Log.i("adLoader", "onAdLoaded")
                }
            })
            .build()

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")
        bundle.putString(TrekAdmobDataKey.CONTENT_URL, "https://agirls.aotter.net/")
        bundle.putString(TrekAdmobDataKey.CONTENT_TITLE, "電獺少女")

        val adRequest = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
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
                    Log.i("adLoader", "onAdClicked2")
                }

                override fun onAdImpression() {
                    super.onAdImpression()

                    Log.i("adLoader", "onAdImpression2")

                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Log.i("adLoader", "onAdLoaded2")
                }
            })
            .build()

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")
        bundle.putString(TrekAdmobDataKey.CONTENT_URL, "https://agirls.aotter.net/")
        bundle.putString(TrekAdmobDataKey.CONTENT_TITLE, "電獺少女")

        val adRequest = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()


        adLoader.loadAd(adRequest)
    }

    override fun onDestroy() {
        super.onDestroy()

        viewBinding.admobNativeView.destroy()

        viewBinding.admobNativeView2.destroy()

    }

}