package com.example.mykotlinapp.data

import com.example.mykotlinapp.R


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class FarmerAdapter :
    ListAdapter<Farmer, FarmerAdapter.FarmerViewHolder>(FarmerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.farmer_row, parent, false)
        return FarmerViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmerViewHolder, position: Int) {
        val farmer = getItem(position)
        holder.bind(farmer)
    }

    class FarmerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val etName: TextView = itemView.findViewById(R.id.et_name)
        private val etId: TextView = itemView.findViewById(R.id.et_id_number)
        private val etCrop: TextView = itemView.findViewById(R.id.et_crop_type)

        fun bind(farmer: Farmer) {
            etName.text = farmer.name
            etId.text = farmer.nationalId
            etCrop.text = farmer.cropType
        }
    }

    class FarmerDiffCallback : DiffUtil.ItemCallback<Farmer>() {
        override fun areItemsTheSame(oldItem: Farmer, newItem: Farmer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Farmer, newItem: Farmer): Boolean {
            return oldItem == newItem
        }
    }
}
