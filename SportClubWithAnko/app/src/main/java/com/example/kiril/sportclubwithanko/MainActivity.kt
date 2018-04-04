package com.example.kiril.sportclubwithanko

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import com.example.kiril.sportclubwithanko.Adapter.TrainerListAdapter
import com.example.kiril.sportclubwithanko.ComponentsAnco.DrawUI
import com.example.kiril.sportclubwithanko.Data.loadingData
import com.example.kiril.sportclubwithanko.Data.loadingTrainerInfo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var draw : DrawUI

    private var trainersList = TrainerInfo.List()
    private val reposAdapter = TrainerListAdapter(trainersList)

    private lateinit var trainerV : RecyclerView
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        draw = customView{}
        setContentView(draw)
        val toolbar = findOptional<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, draw, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        draw.addDrawerListener(toggle)
        toggle.syncState()

        findOptional<NavigationView>(R.id.nav_bar)!!.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        find<LinearLayout>(R.id.linear_layout).removeAllViews()
        trainersList.clear()

        when (item.itemId) {
            R.id.nav_camera -> {
                linearLayoutManager = LinearLayoutManager(this)
                find<LinearLayout>(R.id.linear_layout).apply {
                    linearLayout {
                        orientation = VERTICAL

                        trainerV = recyclerView {
                            id = R.id.recycler_news
                            lparams(matchParent, matchParent)
                            adapter = reposAdapter
                            layoutManager = linearLayoutManager
                        }
                    }
                }

                launch(UI) {

                    val cachedPhotos = loadingTrainerInfo(application as App).await()
                    if (cachedPhotos.isNotEmpty()) {
                        trainersList.addAll(cachedPhotos)
                        trainerV.adapter.notifyDataSetChanged()
                    } else {
                        val cloudPhotosJob = loadingData()
                        cloudPhotosJob.start()
                        val cloudPhotos = cloudPhotosJob.await()
                        savePhotos(application as App, cloudPhotos)
                        trainersList.addAll(cloudPhotos)
                        trainerV.adapter.notifyDataSetChanged()
                    }
                }
            }
            R.id.nav_gallery -> {
                find<LinearLayout>(R.id.linear_layout).apply {
                    textView("text")
                }
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        draw.closeDrawer(GravityCompat.START)
        return true
    }
}
