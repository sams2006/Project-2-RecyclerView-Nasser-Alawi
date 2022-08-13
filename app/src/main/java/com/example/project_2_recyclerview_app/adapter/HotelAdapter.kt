package com.example.project_2_recyclerview_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.project_2_recyclerview_app.R
import com.example.project_2_recyclerview_app.model.Hotel

class HotelAdapter(
    private val dataSet: List<Hotel>,
    private val context: Context
) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    inner class HotelViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val textHotelName: TextView = itemView.findViewById(R.id.hotel_name)
        val textHotelMap: TextView = itemView.findViewById(R.id.text_view_map)
        val textHotelDetails: TextView = itemView.findViewById(R.id.details_hotel)
        val textHotelPrice: TextView = itemView.findViewById(R.id.price)
        val imageHotel: ImageView = itemView.findViewById(R.id.hotel_image)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return HotelViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textHotelName.text = context.resources.getString(item.name)
        holder.textHotelMap.text = context.resources.getString(item.textViewMap)
        holder.textHotelDetails.text = context.resources.getString(item.details)
        holder.textHotelPrice.text = context.resources.getString(item.price)
        holder.imageHotel.setImageResource(item.imageHotel)
    }

    override fun getItemCount(): Int = dataSet.size


}