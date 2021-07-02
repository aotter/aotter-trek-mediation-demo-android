package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.AdData
import com.admob.mediation.kotlin.TrekAdmobAdViewBinder
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventNative
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAdmobNativeAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        loadAdmobNativeAd()

        loadAdmobNativeAd2()

    }

    private fun initView() {

        viewBinding.refreshBtn.setOnClickListener {
            adLoader.loadAd(adRequest)
            adLoader2.loadAd(adRequest2)
        }

    }


    private fun loadAdmobNativeAd() {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        adLoader = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                viewBinding.Sponsored.text = nativeAd.advertiser
                viewBinding.Sponsored.setOnClickListener {
                    Log.e("dsdas", "dsadsa")
                }
                viewBinding.admobAdTitle.text = nativeAd.body
//
                Glide.with(this)
                    .load(nativeAd.icon?.uri ?: "")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewBinding.admobAdImg)

                viewBinding.admobNativeAdView.setNativeAd(nativeAd)

                nativeAd.extras.getSerializable(TrekAdmobDataKey.AD_DATA)?.let {
                    val adData = it as AdData
                    TrekAdmobAdViewBinder.bindingAdView(adData, viewBinding.admobNativeAdView)
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

        adLoader2 = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                viewBinding.Sponsored2.text = nativeAd.advertiser

                viewBinding.admobAdTitle2.text = nativeAd.body

                Glide.with(this)
                    .load(nativeAd.icon?.uri ?: "")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewBinding.admobAdImg2)

                viewBinding.admobNativeAdView2.setNativeAd(nativeAd)

                val adData =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.AD_DATA) as? AdData

                adData?.let {
                    TrekAdmobAdViewBinder.bindingAdView(it, viewBinding.admobNativeAdView2)
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

}