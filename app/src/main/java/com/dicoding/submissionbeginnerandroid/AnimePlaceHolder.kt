package com.dicoding.submissionbeginnerandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.submissionbeginnerandroid.databinding.AnimePlaceHolderBinding

class AnimePlaceHolder : AppCompatActivity() {
    private lateinit var binding : AnimePlaceHolderBinding
    private lateinit var anime : Anime
    companion object{
     val ANIME_ID = "hihi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnimePlaceHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        anime = intent.getParcelableExtra(ANIME_ID)!!

        if(anime != null){
            Glide.with(this).load(anime.image).into(binding.imgItemPhoto)
            binding.tvItemTitle.text =anime.nama
            binding.tvItemDescription.text = anime.deskripsi
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
            }
            R.id.action_share->{
                val imageUris: ArrayList<Uri> = arrayListOf(
                    Uri.parse(anime.image)
                )

                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND_MULTIPLE
                    putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris)
                    type = "image/*"
                }
                startActivity(Intent.createChooser(shareIntent, "Share images to.."))

            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share,menu)
        return super.onCreateOptionsMenu(menu)
    }
}