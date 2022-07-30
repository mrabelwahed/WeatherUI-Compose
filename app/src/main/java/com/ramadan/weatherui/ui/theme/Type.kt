package com.ramadan.weatherui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ramadan.weatherui.R

val customFont = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium , FontWeight.Medium),
    Font(R.font.poppins_bold , FontWeight.Bold)

)
// Set of Material typography styles to start with
val Typography = Typography(defaultFontFamily = customFont)