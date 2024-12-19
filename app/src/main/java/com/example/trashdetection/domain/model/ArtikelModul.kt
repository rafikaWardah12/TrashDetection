package com.example.trashdetection.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ArtikelModul(
    val id: String,
    val title: String,
    val content: String,
    val bannerUrl: String,
    val date: String,
    val author: String
) : Parcelable