package com.example.visitsomerset.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Attraction(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val imgAuthor: Int,
    @StringRes val imgAlt: Int,
    @StringRes val imgLicense: Int,
    @DrawableRes val img: Int

)
