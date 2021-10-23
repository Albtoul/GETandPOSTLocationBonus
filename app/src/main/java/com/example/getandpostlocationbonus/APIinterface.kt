package com.example.getandpostlocationbonus

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIinterface{
    @Headers("Content-Type: application/json")
    @GET("/test/")
    fun getUser(): Call<PersonDetails?>?


    @Headers("Content-Type: application/json")
    @POST("/test/")

    fun addUser(@Body info:PersonDetails.PersonDetailsItem): Call<PersonDetails.PersonDetailsItem>
}

