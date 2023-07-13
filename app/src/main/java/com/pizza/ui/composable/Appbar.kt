package com.pizza.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pizza.R
import com.pizza.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appbar(
    onNavigateUp: () -> Unit,
    title:String =""
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = Typography.titleLarge.copy(color = Color.Black),
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "",
                modifier = Modifier.clickable { onNavigateUp() },
                tint = Color.Black
            )
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = "",
                tint = Color.Black
            )
        },
        colors= TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        modifier = Modifier.padding(horizontal = 8.dp),
    )
}