package com.example.instagramcloneapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.instagramcloneapp.R
import com.example.instagramcloneapp.adapter.ViewPagerAdapter
import com.example.instagramcloneapp.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

/*
   it contains view pager with 5 fragments in MainActivity
    and pages can be controlled by BottomNavigationView
 */

class MainActivity : BaseActivity() {

    val TAG = MainActivity::class.java.simpleName
    var index = 0
    lateinit var homeFragment: HomeFragment
    lateinit var uploadFragment: UploadFragment
    lateinit var viewPager: ViewPager
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home ->{
                    viewPager.setCurrentItem(0)
                }
                R.id.navigation_search ->{
                    viewPager.setCurrentItem(1)
                }
                R.id.navigation_upload ->{
                    viewPager.setCurrentItem(2)
                }
                R.id.navigation_favorite ->{
                    viewPager.setCurrentItem(3)
                }
                R.id.navigation_profile ->{
                    viewPager.setCurrentItem(4)
                }
            }
            true
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onPageSelected(position: Int) {
                index = position
                bottomNavigationView.menu.getItem(index).setChecked(true)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        //Home and Upload Fragments are global for communication purpose

        homeFragment = HomeFragment()
        uploadFragment = UploadFragment()
        setupViewPager(viewPager)

    }
    private fun setupViewPager(viewPager:ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(homeFragment)
        adapter.addFragment(SearchFragment())
        adapter.addFragment(uploadFragment)
        adapter.addFragment(FavoriteFragment())
        adapter.addFragment(ProfileFragment())
        viewPager.adapter = adapter
    }
}