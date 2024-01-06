package com.papela.hidoop.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun getScreenWidth(): Int {
    val configuration = LocalConfiguration.current

    return configuration.screenWidthDp
}
@Composable
fun getScreenHeight(): Int {
    val configuration = LocalConfiguration.current

    return configuration.screenHeightDp
}

