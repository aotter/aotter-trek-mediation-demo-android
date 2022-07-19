package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.banner_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventBanner
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityAdmobBannerAdScrollViewBinding
import com.google.android.gms.ads.*

class AdmobBannerAdScrollViewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAdmobBannerAdScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAdmobBannerAdScrollViewBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        loadBannerAd()

    }

    private fun loadBannerAd() {

        val bannerAdView = AdView(this)

        bannerAdView.adSize = AdSize.BANNER

        bannerAdView.adUnitId = "ca-app-pub-8836593984677243/2093351036"

        bannerAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()

                Log.i("Banner Ad", "onAdLoaded")

                viewBinding.linearLayout.addView(bannerAdView)

            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.e("Banner Ad", p0.message)
            }
        }

        val bundle = Bundle()

        bundle.putString(TrekAdmobDataKey.CATEGORY, "news")
        bundle.putString(TrekAdmobDataKey.CONTENT_URL, "https://agirls.aotter.net/")
        bundle.putString(TrekAdmobDataKey.CONTENT_TITLE, "電獺少女")

        val adRequest = AdRequest
            .Builder()
            .addNetworkExtrasBundle(TrekAdmobCustomEventBanner::class.java, bundle)
            .build()

        bannerAdView.loadAd(adRequest)

    }

}