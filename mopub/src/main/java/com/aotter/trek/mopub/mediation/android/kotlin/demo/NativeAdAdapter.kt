package com.aotter.trek.mopub.mediation.android.kotlin.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aotter.trek.sdk.android.mopub.mediation.kotlin.demo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class NativeAdAdapter : RecyclerView.Adapter<NativeAdAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val adTitle = itemView.findViewById<TextView>(R.id.adTitle)

        private val advertiser = itemView.findViewById<TextView>(R.id.adText)

        private val adImg = itemView.findViewById<ImageView>(R.id.adImg)

        fun bind(item: LocalNativeAdData) {

            advertiser?.text = item.advertiser

            adTitle.text = item.title

            Glide.with(itemView.context)
                .load(item.img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(adImg)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_local_ad, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    private var list = mutableListOf<LocalNativeAdData>()


    fun update(list: MutableList<LocalNativeAdData>) {

        this.list = list

        notifyDataSetChanged()

    }

}