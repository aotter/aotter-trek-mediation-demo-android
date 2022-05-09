package com.aotter.max.mediation.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aotter.max.mediation.demo.banner_ad.BannerAdActivity
import com.aotter.max.mediation.demo.databinding.ActivityMainBinding
import com.aotter.max.mediation.demo.native_ad.NativeAdRecyclerViewPageActivity
import com.aotter.max.mediation.demo.native_ad.NativeAdScrollViewActivity
import com.applovin.sdk.AppLovinSdk

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        // Make sure to set the mediation provider value to "max" to ensure proper functionality
        AppLovinSdk.getInstance(this).mediationProvider = "max"

        AppLovinSdk.getInstance(this).initializeSdk {}

    }

    private fun initView() {

        viewBinding.nativeAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, NativeAdScrollViewActivity::class.java)
            startActivity(intent)
        }

        viewBinding.nativeAdRecyclerViewBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, NativeAdRecyclerViewPageActivity::class.java)
            startActivity(intent)
        }

        viewBinding.bannerAdBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, BannerAdActivity::class.java)
            startActivity(intent)
        }

    }


}