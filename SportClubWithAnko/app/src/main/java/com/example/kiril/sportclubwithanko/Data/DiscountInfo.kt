package com.example.kiril.sportclubwithanko.Data


/**
 * Created by Kiril on 05.04.2018.
 */

data class DiscountInfo(
        val id_discount: String,
        val name_discount: String,
        val description_discount: String,
        val price_discount: String) { class List : ArrayList<DiscountInfo>() }