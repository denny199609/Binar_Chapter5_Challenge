package com.example.chapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.chapter5.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity(){
    private lateinit var binding : ActivityFragmentBinding
    private val pagerAdapter by lazy {
        ViewPagerAdapter(supportFragmentManager)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            vp.offscreenPageLimit = 3
            pagerAdapter.also { viewPagerAdapter ->
                viewPagerAdapter.addFragment(FirstLanding(),"First Fragment")
                viewPagerAdapter.addFragment(SecondLanding(),"Second Fragment")
                viewPagerAdapter.addFragment(ThirdLanding(),"Third Fragment")
                vp.adapter = viewPagerAdapter
                dotsIndicator.setViewPager(vp)

            }


        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}