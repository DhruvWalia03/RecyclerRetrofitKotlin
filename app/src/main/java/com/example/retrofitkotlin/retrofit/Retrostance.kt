package com.example.retrofitkotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrostance {

    companion object{
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://www.cryptingup.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

}