package com.example.retrofitkotlin.retrofit

import com.example.retrofitkotlin.RecyclerList
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("markets")
    fun getDatafromAPI(): Call<RecyclerList>

}