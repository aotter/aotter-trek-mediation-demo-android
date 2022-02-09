package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventNative
import com.aotter.net.dto.trek.response.TrekNativeAd
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.AdmobApplication
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityAdmobNativeAdScrollViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest


class AdmobNativeAdScrollViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAdmobNativeAdScrollViewBinding

    private lateinit var adLoader: AdLoader

    private lateinit var adRequest: AdRequest

    private lateinit var adLoader2: AdLoader

    private lateinit var adRequest2: AdRequest

    private lateinit var adLoader3: AdLoader

    private lateinit var adRequest3: AdRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAdmobNativeAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        loadAdmobNativeAd()

        loadAdmobNativeAd2()

        loadAdmobNativeAd3()

    }

    private fun loadAdmobNativeAd() {

        val adUnit = "ca-app-pub-8836593984677243/4613662079"

        adLoader = AdLoader.Builder(AdmobApplication.context, adUnit)
            .forNativeAd { nativeAd ->

                val trekNativeAd =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.TREK_NATIVE_AD) as? TrekNativeAd

                trekNativeAd?.let {

                    viewBinding.advertiser4.text = it.advertiserName

                    viewBinding.adTitle4.text = it.title

                    viewBinding.trekNativeAdView3.setTrekMediaView(viewBinding.trekMediaView)

                    viewBinding.trekNativeAdView3.setNativeAd(it)

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

        adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader.loadAd(adRequest)

    }

    private fun loadAdmobNativeAd2() {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        adLoader2 = AdLoader.Builder(AdmobApplication.context, adUnit)
            .forNativeAd { nativeAd ->

                val trekNativeAd =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.TREK_NATIVE_AD) as? TrekNativeAd

                trekNativeAd?.let {

                    viewBinding.advertiser2.text = it.advertiserName

                    viewBinding.adTitle2.text = it.title

                    Glide.with(this)
                        .load(it.imgMain)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(viewBinding.adImg2)

                    viewBinding.trekNativeAdView.setNativeAd(it)

                }

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

        adRequest2 = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader2.loadAd(adRequest2)

    }

    private fun loadAdmobNativeAd3() {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        adLoader3 = AdLoader.Builder(AdmobApplication.context, adUnit)
            .forNativeAd { nativeAd ->

                val trekNativeAd =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.TREK_NATIVE_AD) as? TrekNativeAd

                trekNativeAd?.let {

                    viewBinding.advertiser3.text = it.advertiserName

                    viewBinding.adTitle3.text = it.title

                    Glide.with(this)
                        .load(it.imgMain)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(viewBinding.adImg3)

                    viewBinding.trekNativeAdView2.setNativeAd(it)

                }

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

        adRequest3 = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader3.loadAd(adRequest3)

    }

}