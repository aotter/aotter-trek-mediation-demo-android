package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventNative
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

        adLoader = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                viewBinding.advertiser3.text = nativeAd.advertiser

                viewBinding.adTitle3.text = nativeAd.headline

                viewBinding.nativeAdView3.mediaView = viewBinding.mediaView3

                viewBinding.nativeAdView3.setNativeAd(nativeAd)

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

                viewBinding.advertiser2.text = nativeAd.advertiser

                viewBinding.adTitle2.text = nativeAd.headline

                Glide.with(this)
                    .load(nativeAd.icon?.uri ?: "")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewBinding.adImg2)

                viewBinding.nativeAdView2.setNativeAd(nativeAd)


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

        adRequest2 = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader2.loadAd(adRequest2)

    }

    private fun loadAdmobNativeAd3() {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        adLoader3 = AdLoader.Builder(this, adUnit)
            .forNativeAd { nativeAd ->

                viewBinding.advertiser.text = nativeAd.advertiser

                viewBinding.adTitle.text = nativeAd.headline

                val mainImg = nativeAd.extras.getString(TrekAdmobDataKey.MAIN_IMAGE)
                    ?: nativeAd.mediaContent?.mainImage

                Glide.with(this)
                    .load(mainImg)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewBinding.adImg)

                viewBinding.nativeAdView.imageView = viewBinding.adImg

                viewBinding.nativeAdView.setNativeAd(nativeAd)

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

        adRequest3 = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader3.loadAd(adRequest3)

    }

    override fun onDestroy() {
        super.onDestroy()

        viewBinding.nativeAdView.destroy()

        viewBinding.nativeAdView2.destroy()

        viewBinding.nativeAdView3.destroy()

    }

}