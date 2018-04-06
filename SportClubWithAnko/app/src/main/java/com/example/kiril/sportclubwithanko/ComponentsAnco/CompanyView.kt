package com.example.kiril.sportclubwithanko.ComponentsAnco

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.example.kiril.sportclubwithanko.Data.CompanyInfo
import com.example.kiril.sportclubwithanko.R
import org.jetbrains.anko.*

/**
 * Created by Kiril on 06.04.2018.
 */

class CompanyView(context: Context) : _LinearLayout(context){

    @SuppressLint("ResourceType")
    fun bind(companyInfo : CompanyInfo){
        relativeLayout{

            textView {
                id = 1
                text = companyInfo.name_company
                textSize = 40f

            }.lparams{
                topMargin = 30
                centerHorizontally()
            }

            imageView {
                id = 2
                scaleType = ImageView.ScaleType.CENTER
                backgroundResource = R.mipmap.ic_launcher_foreground_medal_of_honor
            }.lparams{
                below(1)
                centerHorizontally()
                topMargin = 30
                leftMargin = 30
            }

            textView {
                id = 3
                text = companyInfo.discription_company
                textSize = 20f
            }.lparams{
                below(2)
                topMargin = 30
                leftPadding = 70
            }

            textView {
                id = 4
                text = "Счастливого дня!!!"
                textSize = 40f
            }.lparams{
                below(3)
                topMargin = 40
                leftMargin = 30
            }
        }
    }
}