package com.tdd.uchit.techmania.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    @SerializedName("title")
    @Expose
    val title: Title,

    @SerializedName("jetpack_featured_media_url")
    @Expose
    val image: String,

    @SerializedName("content")
    @Expose
    val description: Content,

    @SerializedName("author")
    @Expose
    val author: String,

    @SerializedName("date")
    @Expose
    val date: String
) : Parcelable

@Parcelize
data class Title(
    @Expose
    @SerializedName("rendered")
    val rendered: String
) : Parcelable

@Parcelize
data class Content(

    @SerializedName("rendered")
    @Expose
    val rendered: String
) : Parcelable