package com.aotter.max.mediation.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aotter.max.mediation.demo.databinding.ItemNativeAdBinding
import com.aotter.max.mediation.demo.databinding.ViewNativeAdContainerBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class NativeAdAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<LocalNativeAdData>()

    fun update(list: MutableList<LocalNativeAdData>) {

        this.list = list

        notifyDataSetChanged()

    }

    fun insert(position: Int, localNativeAdData: LocalNativeAdData) {

        this.list.add(position, localNativeAdData)

        notifyItemInserted(position)

    }

    override fun getItemViewType(position: Int): Int {
        return list[position].maxNativeAdView?.let {
            0
        } ?: kotlin.run {
            1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            0 -> AdViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_native_ad_container, parent, false)
            )
            1 -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_native_ad, parent, false)
            )
            else -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_native_ad, parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(list[position])
        }

        if (holder is AdViewHolder) {
            holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = ItemNativeAdBinding.bind(itemView)

        fun bind(item: LocalNativeAdData) {

            viewBinding.advertiser.text = item.advertiser

            viewBinding.adTitle.text = item.title

            Glide.with(viewBinding.root.context)
                .load(item.img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(viewBinding.adImg)

        }

    }

    inner class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = ViewNativeAdContainerBinding.bind(itemView)

        fun bind(item: LocalNativeAdData) {

            (item.maxNativeAdView?.parent as? ViewGroup)?.removeAllViews()

            viewBinding.container.removeAllViews()

            viewBinding.container.addView(item.maxNativeAdView)

        }

    }


}