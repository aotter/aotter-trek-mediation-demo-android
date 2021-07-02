package com.aotter.trek.mopub.mediation.android.kotlin.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aotter.trek.mopub.mediation.android.kotlin.demo.banner_ad.MoPubBannerAdRecyclerViewActivity
import com.aotter.trek.mopub.mediation.android.kotlin.demo.native_ad.MoPubNativeAdManualActivity
import com.aotter.trek.mopub.mediation.android.kotlin.demo.native_ad.MoPubNativeAdRecyclerViewActivity
import com.aotter.trek.mopub.mediation.android.kotlin.demo.supr_ad.MoPubSuprAdManualActivity
import com.aotter.trek.mopub.mediation.android.kotlin.demo.supr_ad.MoPubSuprAdRecyclerViewActivity
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initView()

    }

    private fun initView() {

        viewBinding.mopubNativeAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MoPubNativeAdRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        viewBinding.mopubSuprAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MoPubSuprAdRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        viewBinding.mopubBannerAdScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MoPubBannerAdRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        viewBinding.mopubNativeAdManualScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MoPubNativeAdManualActivity::class.java)
            startActivity(intent)
        }

        viewBinding.mopubSuprAdManualScrollPageBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MoPubSuprAdManualActivity::class.java)
            startActivity(intent)
        }

    }


}