package com.prmto.profilecardlayout

import androidx.annotation.DrawableRes

data class UserProfile(val name: String, val status: Boolean, @DrawableRes val drawableId: Int)

val userProfileList = arrayListOf(
    UserProfile("Kim Min Jae", true, R.drawable.images),
    UserProfile("Anna Joans", false, R.drawable.images_women)
)


