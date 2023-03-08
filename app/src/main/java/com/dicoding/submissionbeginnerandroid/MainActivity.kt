package com.dicoding.submissionbeginnerandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.submissionbeginnerandroid.databinding.ActivityMainBinding
import com.dicoding.submissionbeginnerandroid.Anime
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Anime>()
    override fun onCreate(savedInstanceState: Bundle?) {
        // add splash screen
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.anime.setHasFixedSize(true)

        list.addAll(getAnime())
        showRecyler()
        setContentView(binding.root)
    }

    private fun getAnime(): ArrayList<Anime> {
        val namaAnime = resources.getStringArray(R.array.nama_anime)
        val descAnime = resources.getStringArray(R.array.deskripsi_anime)
        val gambarAnime = resources.getStringArray(R.array.gambar_anime)
        val listAnime = ArrayList<Anime>()
        for(i in 0 until 10){
            listAnime.add(Anime(namaAnime[i],descAnime[i],gambarAnime[i]))
        }
        return listAnime
    }

    private fun showRecyler(){
        binding.anime.layoutManager = LinearLayoutManager(this)
        val animeAdapter = AnimeAdapter(list)
        binding.anime.adapter = animeAdapter
        animeAdapter.setOnItemClickCallback(object : AnimeAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Anime) {
                startActivity(Intent(this@MainActivity,AnimePlaceHolder::class.java).putExtra(AnimePlaceHolder.ANIME_ID, data))
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.account -> {
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}