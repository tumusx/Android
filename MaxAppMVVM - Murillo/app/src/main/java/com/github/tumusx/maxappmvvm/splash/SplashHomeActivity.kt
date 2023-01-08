package com.github.tumusx.maxappmvvm.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.tumusx.maxappmvvm.databinding.ActivityHomeSplashBinding
import com.github.tumusx.maxappmvvm.menu.MenuActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instanceSplashBinding()
        configureSplashRoute()
        setContentView(binding.root)
    }

    private fun instanceSplashBinding() {
        binding = ActivityHomeSplashBinding.inflate(layoutInflater)
    }

    private fun configureSplashRoute() {
        lifecycleScope.launch {
            delay(600)
            startActivity(Intent(this@SplashHomeActivity, MenuActivity::class.java))
            this@SplashHomeActivity.finish()
        }
    }
}