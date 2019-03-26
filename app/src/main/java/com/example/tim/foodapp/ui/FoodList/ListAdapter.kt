package com.example.tim.foodapp.ui.FoodList

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tim.foodapp.data.models.FoodList
import com.example.tim.foodapp.databinding.ListItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val mList = ArrayList<FoodList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    fun setList(list: ArrayList<FoodList>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodlist = mList[position]
        holder.bind(foodlist)
    }


    class ViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodList: FoodList) {
            binding.foodList = foodList
        }
    }
}