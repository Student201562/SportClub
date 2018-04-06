package com.example.kiril.sportclubwithanko.Adapter

import android.support.v7.widget.ListPopupWindow
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.kiril.sportclubwithanko.ComponentsAnco.CompanyView
import com.example.kiril.sportclubwithanko.ComponentsAnco.DiscountListView
import com.example.kiril.sportclubwithanko.Data.CompanyInfo
import com.example.kiril.sportclubwithanko.Data.DiscountInfo

/**
 * Created by Kiril on 06.04.2018.
 */

class CompanyAdapter(
        private val companys: CompanyInfo.List) : RecyclerView.Adapter<CompanyAdapter.CompanyListViewHolder>() {

    class CompanyListViewHolder(val view: CompanyView) : RecyclerView.ViewHolder(view){

    }

    override fun getItemCount() = companys.size

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        val companyV = holder.view
        val company = companys[position]
        companyV.bind(company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyAdapter.CompanyListViewHolder {

        val view = CompanyView(parent.context)
        view.layoutParams = RecyclerView.LayoutParams(ListPopupWindow.MATCH_PARENT, ListPopupWindow.WRAP_CONTENT)

        return CompanyListViewHolder(view)
    }
}