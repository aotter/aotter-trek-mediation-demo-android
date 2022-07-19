package com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.admob_mediation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.LocalNativeAdData
import com.aotter.trek.sdk.android.admob.mediation.kotlin.demo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.gms.ads.nativead.NativeAdView

class AdmobNativeAdAdapter() : RecyclerView.Adapter<AdmobNativeAdAdapter.ViewHolder>() {

    private var list = mutableListOf<LocalNativeAdData>()

    fun update(list: MutableList<LocalNativeAdData>) {

        this.list = list

        notifyDataSetChanged()

    }

    fun update(index: Int, localNativeAdData: LocalNativeAdData) {

        list.add(index, localNativeAdData)

        notifyItemChanged(index)

    }

    override fun getItemViewType(position: Int): Int {

        return list[position].nativeAd?.let {
            0
        } ?: kotlin.run {
            1
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewType) {
            0 -> {

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_admob_native_ad, parent, false)

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

        private val admobNativeAdView5 =
            itemView.findViewById<NativeAdView>(R.id.admobNativeAdView5)

        fun bind(item: LocalNativeAdData) {

            item.nativeAd?.let {

                advertiser?.text = it.advertiser

                adTitle.text = it.headline

                Glide.with(itemView.context)
                    .load(it.icon?.uri ?: "")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(adImg)

                admobNativeAdView5.setNativeAd(it)

                return

            }

            advertiser?.text = item.advertiser

            adTitle.text = item.title

            Glide.with(itemView.context)
                .load(item.img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(adImg)


        }

    }

}