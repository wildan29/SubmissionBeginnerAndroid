package com.dicoding.submissionbeginnerandroid

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.submissionbeginnerandroid.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        supportActionBar?.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}