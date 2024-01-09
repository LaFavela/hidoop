package com.papela.hidoop.util

data class DataAssigment(
    val date: String,
    val month: String,
    val day: String,
    val year: String,
    val title: String,
    val time: String
)

data class DataProcedure(
    val title: String,
    val content: String,
    val image : String,
    val number: Int
)