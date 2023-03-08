package com.dicoding.submissionbeginnerandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(val nama: String, val deskripsi: String, val image: String) : Parcelable
