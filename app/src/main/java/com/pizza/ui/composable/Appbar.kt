package com.pizza.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pizza.R


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
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "",
                modifier = Modifier.clickable { onNavigateUp() },
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = "",
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp).padding(16.dp),
    )
}