package com.example.kiril.sportclubwithanko.ComponentsAnco

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.example.kiril.sportclubwithanko.TrainerInfo
import com.example.kiril.sportclubwithanko.R
import org.jetbrains.anko.*

/**
 * Created by Kiril on 03.04.2018.
 */

class TrainerListView(context: Context) : _LinearLayout(context) {


    @SuppressLint("ResourceType")
    fun bind(trainerInfo: TrainerInfo) {

        relativeLayout{
            imageView {
                id = 1
                scaleType = ImageView.ScaleType.CENTER
                backgroundResource = R.mipmap.ic_launcher_foreground
            }.lparams{
                alignParentLeft()
            }

            textView {
                id = 2
                text = trainerInfo.full_name
            }.lparams{
                rightOf(1)
            }

            textView {
                id = 3
                text = trainerInfo.telephone
            }.lparams{
                below(2)
                rightOf(1)
            }
        }

    }
}