package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.banner_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventBanner
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityAdmobBannerAdScrollViewBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError

class AdmobBannerAdScrollViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAdmobBannerAdScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAdmobBannerAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        loadBannerAd()

    }

    private fun loadBannerAd() {

        viewBinding.bannerAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()

                Log.e("Banner Ad", "onAdLoaded")

            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.e("Banner Ad", p0.message)
            }
        }

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")

        val adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventBanner::class.java, bundle)
            .build()

        viewBinding.bannerAdView.loadAd(adRequest)

    }

}