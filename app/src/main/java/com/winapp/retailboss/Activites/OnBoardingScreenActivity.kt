package com.winapp.retailboss.Activites

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.winapp.retailboss.R
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment

class OnBoardingScreenActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        showStatusBar(true)
        setIndicatorColor(
            selectedIndicatorColor = getColor(R.color.app_color),
            unselectedIndicatorColor = getColor(R.color.back_ground_color)
        )
        addSlide(
            AppIntroFragment.newInstance(
                backgroundDrawable = R.drawable.ic_purchase,
                backgroundColor = Color.BLUE,
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                backgroundDrawable = R.drawable.ic_items,
                backgroundColor = Color.RED,
            )
        )
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivity(Intent(this@OnBoardingScreenActivity, LoginActivity::class.java))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this@OnBoardingScreenActivity, LoginActivity::class.java))
    }
}