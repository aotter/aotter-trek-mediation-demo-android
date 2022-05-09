package com.aotter.max.mediation.demo.native_ad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aotter.max.mediation.demo.AdViewCreator
import com.aotter.max.mediation.demo.LocalNativeAdData
import com.aotter.max.mediation.demo.NativeAdAdapter
import com.aotter.max.mediation.demo.databinding.ActivityNativeAdRecyclerViewPageBinding
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxError
import com.applovin.mediation.nativeAds.MaxNativeAdListener
import com.applovin.mediation.nativeAds.MaxNativeAdLoader
import com.applovin.mediation.nativeAds.MaxNativeAdView
import com.max.mediation.TrekMaxDataKey

class NativeAdRecyclerViewPageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityNativeAdRecyclerViewPageBinding

    private val nativeAdAdapter = NativeAdAdapter()

    private var list = mutableListOf<LocalNativeAdData>()

    private var nativeAdMap = hashMapOf<MaxNativeAdLoader, MaxAd?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityNativeAdRecyclerViewPageBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        viewBinding.refreshBtn.setOnClickListener {

            destroy()

            initView()

        }

    }

    private fun initView() {

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.nativeAdRecyclerView.layoutManager = linearLayoutManager

        viewBinding.nativeAdRecyclerView.adapter = nativeAdAdapter

        list = mutableListOf<LocalNativeAdData>()

        repeat(15) {

            list.add(
                LocalNativeAdData(
                    "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                    "電獺少女",
                    "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg"
                )
            )

        }

        nativeAdAdapter.update(list)

        getAd(list.count())

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

                val position = count - 1

                if (position > 0) {

                    nativeAdAdapter.insert(
                        position, LocalNativeAdData(
                            "幸運調色盤：12星座明天穿什麼？（6/6-6/12）",
                            "電獺少女",
                            "http://pnn.aotter.net/Media/show/d8404d54-aab7-4729-8e85-64fb6b92a84e.jpg",
                            maxNativeAdView
                        )
                    )

                    getAd(position)

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

    private fun destroy() {

        nativeAdMap.forEach {

            val nativeAdLoader = it.key

            val nativeAd = it.value

            nativeAdLoader.destroy(nativeAd)

        }

        list.clear()

    }

    override fun onDestroy() {
        super.onDestroy()

        destroy()

    }

}