package com.example.getandpostlocationbonus

import com.google.gson.annotations.SerializedName

class PersonDetails : ArrayList<PersonDetails.PersonDetailsItem>(){
    data class PersonDetailsItem(

      val location: String,

        val name: String,
        val pk: Int
    )
}