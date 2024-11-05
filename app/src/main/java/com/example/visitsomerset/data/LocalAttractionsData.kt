package com.example.visitsomerset.data

import com.example.visitsomerset.R
import com.example.visitsomerset.model.Attraction

object LocalAttractionsData {

    val firstAttraction = getListOfAttractions()[1]

    fun getListOfAttractions(): List<Attraction> {
        return listOf(
            Attraction(
                name = R.string.wells,
                description = R.string.wells_description,
                imgAuthor = R.string.wells_img_author,
                imgAlt = R.string.wells,
                img = R.drawable.wells,
                imgLicense = R.string.wells_img_license
            ),
            Attraction(
                name = R.string.roman,
                description = R.string.roman_description,
                imgAuthor = R.string.roman_img_author,
                imgAlt = R.string.roman,
                imgLicense = R.string.roman_img_license,
                img = R.drawable.roman
            ),
            Attraction(
                name = R.string.bridgwater,
                description = R.string.bridgwater_description,
                imgAuthor = R.string.bridgwater_img_author,
                imgAlt = R.string.bridgwater,
                imgLicense = R.string.bridgwater_img_license,
                img = R.drawable.bridgwater
            ),
            Attraction(
                name = R.string.cheddar,
                description = R.string.cheddar_description,
                imgAuthor = R.string.cheddar_img_author,
                imgAlt = R.string.cheddar,
                imgLicense = R.string.cheddar_img_license,
                img = R.drawable.cheddar
            ),
            Attraction(
                name = R.string.glastonbury,
                description = R.string.glastonbury_description,
                imgAuthor = R.string.glastonbury_img_author,
                imgAlt = R.string.glastonbury,
                imgLicense = R.string.glastonbury_img_license,
                img = R.drawable.glastonbury
            )

        )
    }
}