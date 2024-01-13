package com.papela.hidoop.presentation.diet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.papela.hidoop.presentation.diet.components.DietProgress
import com.papela.hidoop.presentation.diet.components.Schedule
import com.papela.hidoop.presentation.diet.components.UpcomingMeal

@Composable
fun DietScreen() {
    Column {
        Text(text = "Your Diet Program")
        DietProgress()
        UpcomingMeal()
        Schedule()
    }
}