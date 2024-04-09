package com.example.botnavbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botnavbar.ui.theme.GreenBN

@Composable
fun d8(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }
    val imageResource = when(result) {
        1 -> R.drawable.dice8_1
        2 -> R.drawable.dice8_2
        3 -> R.drawable.dice8_3
        4 -> R.drawable.dice8_4
        5 -> R.drawable.dice8_5
        6 -> R.drawable.dice8_6
        7 -> R.drawable.dice8_7
        else -> R.drawable.dice8_8
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier = Modifier.size(200.dp))
            Spacer(modifier = modifier)
            Button(
                onClick = { result = (1..8).random() },
            ) {
                Text(text = stringResource(R.string.roll), fontSize = 24.sp)
            }
        }
    }
}