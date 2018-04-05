package com.example.kiril.sportclubwithanko.ComponentsAnco

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.example.kiril.sportclubwithanko.DiscountInfo
import com.example.kiril.sportclubwithanko.R
import org.jetbrains.anko.*

/**
 * Created by Kiril on 05.04.2018.
 */
class DiscountListView(context: Context) : _LinearLayout(context) {


    @SuppressLint("ResourceType")
    fun bind(discountInfo: DiscountInfo) {

        relativeLayout{
            imageView {
                id = 1
                scaleType = ImageView.ScaleType.CENTER
                backgroundResource = R.mipmap.ic_launcher_foreground_discount
            }.lparams{
                alignParentLeft()
                topMargin = 30
                leftMargin = 30
            }

            textView {
                id = 2
                text = discountInfo.name_discount
                textSize = 25f

            }.lparams{
                rightOf(1)
                topMargin = 30
                leftMargin = 20
            }

            textView {
                id = 3
                text = discountInfo.description_discount
                textSize = 20f
            }.lparams{
                below(1)
                topMargin = 30
                leftMargin = 20
            }

            textView {
                id = 4
                text = discountInfo.price_discount
                textSize = 40f
            }.lparams{
                below(3)
                topMargin = 40
                leftMargin = 30
            }
        }

    }
}