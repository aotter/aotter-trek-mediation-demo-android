package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

                viewBinding.admobAdTitle.text = nativeAd.body
//
                Glide.with(this)
                    .load(nativeAd.icon?.uri ?: "")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewBinding.admobAdImg)

                viewBinding.admobNativeAdView.imageView = viewBinding.admobAdImg

                viewBinding.admobNativeAdView.headlineView = viewBinding.admobAdTitle

                viewBinding.admobNativeAdView.advertiserView = viewBinding.Sponsored

                viewBinding.admobNativeAdView.setNativeAd(nativeAd)

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

        adRequest = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
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

        adRequest2 = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader2.loadAd(adRequest2)

    }

    override fun onDestroy() {
        super.onDestroy()

        viewBinding.admobNativeAdView.destroy()

        viewBinding.admobNativeAdView2.destroy()

    }

}