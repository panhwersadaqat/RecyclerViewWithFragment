package com.example.sadaqatpanhwer.demonavigationmenu.Menu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.sadaqatpanhwer.demonavigationmenu.Menu.HomePage.RecyclerFragment
import com.example.sadaqatpanhwer.demonavigationmenu.Menu.Menu.*
import com.example.sadaqatpanhwer.demonavigationmenu.R

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        val mTitle = toolbar.findViewById(R.id.toolbar_title) as TextView
        setSupportActionBar(toolbar)
        mTitle.text = toolbar.title
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout

        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_menu1)
    }//end of oncreate

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }//end of backpressed

    // Inflate the menu; this adds items to the action bar if it is present.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return super.onOptionsItemSelected(item)
    }

    private fun displaySelectedScreen(itemId: Int) {
        var fragment: Fragment? = null
        when (itemId) {
            R.id.nav_menu1 -> fragment = RecyclerFragment()
            R.id.nav_menu2 -> fragment = Menu2()
            R.id.nav_menu3 -> fragment = Menu3()
            R.id.nav_menu4 -> fragment = Menu4()
            R.id.nav_menu5 -> fragment = Menu5()
            R.id.nav_menu6 -> fragment = Menu6()
            R.id.nav_menu7 -> fragment = Menu7()
        }//end of switch

        //replacing the fragment
        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
    }//end of seleccted method


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.itemId)
        //make this method blank
        return true
    }


}