package com.example.lesson3

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.lesson3.bottom_navigation.Quiz
import com.example.lesson3.bottom_navigation.Settings
import com.example.lesson3.bottom_navigation.Stats
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageViewMusic.setImageResource(R.drawable.ic_baseline_music_off_24)
        listenSwitchButton()

        val settings: Fragment = Settings()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_3 -> {
                    change(settings)
                }
                R.id.page_2 -> {
                    val fragment: Fragment = Stats()
                    change(fragment)
                }
                R.id.page_1 -> {
                    val fragment: Fragment = Quiz()
                    change(fragment)
                }
            }
            true
        }

        // bottomNavListener()
    }

    private fun change(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        this.supportFragmentManager.executePendingTransactions();      // <----- This is the key
        fragmentTransaction.commit()
    }


    private fun listenSwitchButton() {
        val song = MediaPlayer.create(this, R.raw.song)
        song.start()
        switchMusic.setOnCheckedChangeListener() { _, isChecked ->
            if (isChecked) {
                song.pause()
            } else {
                song.start()
            }
        }
    }
}


