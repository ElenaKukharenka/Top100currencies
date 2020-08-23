package com.example.top100currencies.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top100currencies.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //установка стрелки возврата в тулбаре
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //инициализируем баннер
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)


        //слушатель для кнопки рейтинга , по нажатию открывает страницу приложения в маркете
        buttonRateApp.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${applicationContext.packageName}")))
        }

    }
}
