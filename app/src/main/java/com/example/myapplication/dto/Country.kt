package com.example.myapplication.dto


data class Country(
    val name: Name,

    val population: Long,
)

data class Name(
    val common:String,
    val official:String
)