package com.example.kiril.sportclubwithanko.ComponentsAnco

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Toast
import com.example.kiril.sportclubwithanko.R
import com.example.kiril.sportclubwithanko.TrainerInfo
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

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
                textSize = 18f
            }.lparams(wrapContent, wrapContent){
                topMargin = 30
                leftMargin = 40
                rightOf(1)
            }

            textView {
                id = 3
                text = trainerInfo.telephone
                textSize = 16f
            }.lparams(wrapContent, wrapContent){
                topMargin = 40
                leftMargin = 30
                below(2)
                rightOf(1)
            }

            button{
                id = 4
                text = "Заказать занятие"
                textColor = Color.rgb(255,255,255)
                backgroundColor = Color.rgb(181,44,42)
                textSize = 16f
//                onClick {
//                    var popupMenu: PopupMenu? = null
//                    popupMenu = PopupMenu(it!!.context, it)
//                    popupMenu.inflate(R.layout.popup_window)
//                    popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
//                        when (item!!.itemId) {
//                            R.id.image -> {
//                                Toast.makeText(it.context, "Эта штука добавилась", Toast.LENGTH_LONG).show()
//                            }
//                        }
//                        true
//                    })
//                    popupMenu.show()
//                }
            }.lparams{
                topMargin = 30
                leftMargin = 50
                below(3)
                rightOf(1)
            }
        }

    }
}