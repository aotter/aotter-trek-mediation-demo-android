package com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.admob.mediation.kotlin.TrekAdmobAdViewBinder
import com.aotter.trek.admob.mediation.android.kotlin.demo.admob_mediation.supr_ad.OnAdmobSuprAdViewRegisteredListener
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAdView

class AdmobSuprAdAdapter() : RecyclerView.Adapter<AdmobSuprAdAdapter.ViewHolder>() {

    private var list = mutableListOf<LocalAdmobSuprAdData>()

    private var onAdmobSuprAdViewRegisteredListener: OnAdmobSuprAdViewRegisteredListener? = null

    fun update(list: MutableList<LocalAdmobSuprAdData>) {

        this.list = list

        notifyDataSetChanged()

    }

    fun update(index: Int, localAdmobSuprAdData: LocalAdmobSuprAdData) {

        list.add(index, localAdmobSuprAdData)

        notifyItemChanged(index)

    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].nativeAd != null && list[position].adData != null) {
            0
        } else {
            1
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewType) {
            0 -> {

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_admob_supr_ad, parent, false)

                ViewHolder(view)

            }
            1 -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_local_ad, parent, false)
            )
            else -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_local_ad, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.count()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val adTitle = itemView.findViewById<TextView>(R.id.adTitle)

        private val advertiser = itemView.findViewById<TextView>(R.id.advertiser)

        private val adImg = itemView.findViewById<ImageView>(R.id.adImg)

        private val admobNativeAdView = itemView.findViewById<NativeAdView>(R.id.admobNativeAdView)

        private val admobMediaview = itemView.findViewById<MediaView>(R.id.admobMediaview)

        fun bind(item: LocalAdmobSuprAdData) {

            item.nativeAd?.let {
                item.adData?.let { adData ->
                    TrekAdmobAdViewBinder.bindingAdView(adData, admobNativeAdView)
                    admobNativeAdView.mediaView = admobMediaview
                    admobNativeAdView.setNativeAd(it)
                }
            } ?: kotlin.run {

                advertiser.text = item.advertiser

                adTitle.text = item.title

                Glide.with(itemView.context)
                    .load(item.img)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(adImg)

            }

        }

    }

}