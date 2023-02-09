package com.example.myapplication.services

import com.example.myapplication.dto.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesService {

    @GET("name/{name}")
    fun getCountries(@Path("name") countryName: String): Call<List<Country>>
}