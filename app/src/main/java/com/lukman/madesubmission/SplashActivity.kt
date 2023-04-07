package com.lukman.madesubmission

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lukman.madesubmission.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

  private lateinit var binding : ActivitySplashBinding
  private val SPLASH_DISPLAY_LENGTH = 3000

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySplashBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.hide()

    Handler().postDelayed({
      val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
      startActivity(mainIntent)
      finish()
    }, SPLASH_DISPLAY_LENGTH.toLong())

  }
}