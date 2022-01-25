package com.exsample.armtravel.ui.place

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exsample.armtravel.R
import com.exsample.armtravel.databinding.ItemPlaceBinding
import com.exsample.armtravel.proxy.place.PlaceItemDto

class PlaceAdapter(private var onClick: (PlaceItemDto) -> Unit = {}) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    private val items = mutableListOf<PlaceItemDto>()

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder =
        PlaceViewHolder(ItemPlaceBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<PlaceItemDto>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: PlaceItemDto)
    }

    inner class PlaceViewHolder(val binding: ItemPlaceBinding) : BaseViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { adapterPosition.takeIf { it != RecyclerView.NO_POSITION }?.let { onClick(items[it]) } }
        }

        override fun bind(item: PlaceItemDto) {
            with(binding) {
                placeItem = item
                Glide.with(srcImageView.getContext()).load("https://www.tutorialspoint.com/images/tp-logo-diamond.png").placeholder(R.drawable.ic_cruelty_24).dontAnimate().into(srcImageView);
            }
        }
    }
}