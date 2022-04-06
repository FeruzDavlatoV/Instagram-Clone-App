package com.example.instagramcloneapp.activity

import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.instagramcloneapp.R

/*
    * Base Activity is parent for all Activities
 */
open class BaseActivity: AppCompatActivity() {
    fun statusBarBackground(){
        /*
            status bar customize first version
         */

//        if (Build.VERSION.SDK_INT >= 21) {
//            val window = this.window
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.statusBarColor = this.resources.getColor(R.color.status_bar)
//        }


        /*
            status bar customize second version
         */
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
    }
}