package com.example.kiril.sportclubwithanko.Adapter

import android.support.v7.widget.ListPopupWindow
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kiril.sportclubwithanko.ComponentsAnco.DiscountListView
import com.example.kiril.sportclubwithanko.Data.DiscountInfo

/**
 * Created by Kiril on 06.04.2018.
 */

class DiscountListAdapter(
        private val discounts: DiscountInfo.List) : RecyclerView.Adapter<DiscountListAdapter.DiscountListViewHolder>() {

    class DiscountListViewHolder(val view: DiscountListView) : RecyclerView.ViewHolder(view){

    }
    override fun getItemCount() = discounts.size

    override fun onBindViewHolder(holder: DiscountListViewHolder, position: Int) {
        val discountV = holder.view
        val discount = discounts[position]
        discountV.bind(discount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountListAdapter.DiscountListViewHolder {

        val view = DiscountListView(parent.context)
        view.layoutParams = RecyclerView.LayoutParams(ListPopupWindow.MATCH_PARENT, ListPopupWindow.WRAP_CONTENT)

        return DiscountListViewHolder(view)
    }
}