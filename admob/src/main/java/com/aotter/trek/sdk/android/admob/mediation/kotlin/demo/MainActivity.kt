package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.banner_ad.AdmobBannerAdScrollViewActivity
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad.AdmobNativeAdRecyclerViewPageActivity
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation.native_ad.AdmobNativeAdScrollViewActivity
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.databinding.ActivityMainBinding
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {


    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        MobileAds.initialize(this) {


        }


    }

    private fun initView() {

        viewBinding.admobNativeAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AdmobNativeAdScrollViewActivity::class.java)
            startActivity(intent)
        }

        viewBinding.admobNativeAdRecyclerViewBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AdmobNativeAdRecyclerViewPageActivity::class.java)
            startActivity(intent)
        }

        viewBinding.admobBannerAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AdmobBannerAdScrollViewActivity::class.java)
            startActivity(intent)
        }

    }


}