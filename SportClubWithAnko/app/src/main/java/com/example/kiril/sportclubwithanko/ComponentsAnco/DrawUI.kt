package com.example.kiril.sportclubwithanko.ComponentsAnco

import android.content.Context
import android.graphics.Color
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import com.example.kiril.sportclubwithanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4._DrawerLayout

class DrawUI(context: Context) : _DrawerLayout(context) {

    private lateinit var textBlock: TextView

    init {
        fitsSystemWindows = true
        coordinatorLayout{
            themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {

                toolbar{
                    fitsSystemWindows = true
                    id = R.id.toolbar
                    backgroundColor = Color.rgb(140,34,32) // #8C2220
                    popupTheme = R.style.AppTheme_PopupOverlay
                    title = resources.getString(R.string.app_name)
                    relativeLayout {
                        id = R.id.conteiner_toolbar
                    }

                }.lparams(matchParent, dip(55)){
                    scrollFlags = SCROLL_FLAG_ENTER_ALWAYS
                }
            }.lparams(matchParent, wrapContent)


            linearLayout {
                topPadding = dip(55)
                id = R.id.linear_layout
            }.lparams(matchParent, matchParent)

        }.lparams(matchParent, matchParent)

        navigationView {
            id = R.id.nav_bar
            fitsSystemWindows = true
            backgroundColor = Color.rgb(181,44,42) // B52C2A

            val header = context.themedLinearLayout(R.style.Base_ThemeOverlay_AppCompat_Dark) {
                orientation = VERTICAL
                horizontalPadding = dip(16)
                verticalPadding = dip(16)
                gravity = Gravity.BOTTOM
                backgroundColor = R.drawable.side_nav_bar

                imageView {
                    setImageResource(R.mipmap.ic_launcher_foreground)
                }.lparams(wrapContent, wrapContent){
                    topPadding = dip(8)
                }

                textView("MyName") {
                    topPadding = dip(16)
                }.lparams(wrapContent, wrapContent)

                textView("MyName") {
                }.lparams(wrapContent, wrapContent)

            }.lparams(matchParent, dip(176))
            addHeaderView(header)

            inflateMenu(R.menu.activity_main_drawer)


        }.lparams(wrapContent, matchParent) {
            fitsSystemWindows = true
            gravity = Gravity.START
        }
    }
}