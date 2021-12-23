package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.admob.mediation.kotlin.AdData
import com.admob.mediation.kotlin.TrekAdmobDataKey
import com.admob.mediation.kotlin.ads.TrekAdmobCustomEventNative
import com.aotter.trek.admob.mediation.android.kotlin.demo.AdmobApplication
import com.aotter.trek.admob.mediation.android.kotlin.demo.LocalNativeAdData
import com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation.AdmobNativeAdAdapter
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityNativeAdRecyclerviewPageBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest

class AdmobNativeAdRecyclerViewPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityNativeAdRecyclerviewPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityNativeAdRecyclerviewPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)


        initView()

    }


    private fun initView() {

        val admobNativeAdAdapter = AdmobNativeAdAdapter()

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.nativeAdRecyclerView.layoutManager = linearLayoutManager

        viewBinding.nativeAdRecyclerView.adapter = admobNativeAdAdapter

        val list = mutableListOf(
            LocalNativeAdData(
                "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg"
            ),
            LocalNativeAdData(
                "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/3b9bec45-33ab-4548-b192-01959f4e9571.jpg"
            ),
            LocalNativeAdData(
                "遇到心上人就變色！？超夢幻「鮮花果凍唇膏」美到用了會心疼",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/9a9589fe-353d-4148-aa3b-40100572575b.jpg"
            ),
            LocalNativeAdData(
                "春夏流浪風情，讓你的波希米亞風格再晉級",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/b87f68b6-8add-428f-b119-52e49c4e68b4.jpg"
            ),
            LocalNativeAdData(
                "美女主持人安妮出門前快速整理秀髮小心機",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/5855291e-343d-4478-a760-f5c4699107d8.jpg"
            ),
            LocalNativeAdData(
                "在海灘也能引人注目☆有點與眾不同的海灘小物特集♪",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "在海灘也能引人注目☆有點與眾不同的海灘小物特集♪",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "在海灘也能引人注目☆有點與眾不同的海灘小物特集♪",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "在海灘也能引人注目☆有點與眾不同的海灘小物特集♪",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "在海灘也能引人注目☆有點與眾不同的海灘小物特集♪",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            ),
            LocalNativeAdData(
                "H&M夏季裙裝盡顯浪漫嫵媚氣息 展現夏日隨意風～",
                "電獺少女",
                "http://pnn.aotter.net/Media/show/2b588866-47b3-4344-bb38-c9e7194af576.jpg"
            )
        )

        admobNativeAdAdapter.update(list)

        loadAdmobNativeAd(admobNativeAdAdapter)

        loadAdmobNativeAd2(admobNativeAdAdapter)

    }

    private fun loadAdmobNativeAd(
        admobNativeAdAdapter: AdmobNativeAdAdapter
    ) {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        val adLoader = AdLoader.Builder(AdmobApplication.context, adUnit)
            .forNativeAd { nativeAd ->

                val adData =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.AD_DATA) as? AdData

                admobNativeAdAdapter.update(
                    1, LocalNativeAdData(
                        nativeAd.body,
                        nativeAd.advertiser,
                        nativeAd.icon?.uri.toString(),
                        adData,
                        true
                    )
                )

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

        val adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader.loadAd(adRequest)

    }

    private fun loadAdmobNativeAd2(
        admobNativeAdAdapter: AdmobNativeAdAdapter
    ) {

        val adUnit = "ca-app-pub-8836593984677243/1855351388"

        val adLoader = AdLoader.Builder(AdmobApplication.context, adUnit)
            .forNativeAd { nativeAd ->

                val adData =
                    nativeAd.extras.getSerializable(TrekAdmobDataKey.AD_DATA) as? AdData

                admobNativeAdAdapter.update(
                    5, LocalNativeAdData(
                        nativeAd.body,
                        nativeAd.advertiser,
                        nativeAd.icon?.uri.toString(),
                        adData,
                        true
                    )
                )
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

        val adRequest = AdRequest
            .Builder()
            .addCustomEventExtrasBundle(TrekAdmobCustomEventNative::class.java, bundle)
            .build()

        adLoader.loadAd(adRequest)

    }


}