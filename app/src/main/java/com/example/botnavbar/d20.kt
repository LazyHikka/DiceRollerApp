package com.example.botnavbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun d20(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice20_1
        2 -> R.drawable.dice20_2
        3 -> R.drawable.dice20_3
        4 -> R.drawable.dice20_4
        5 -> R.drawable.dice20_5
        6 -> R.drawable.dice20_6
        7 -> R.drawable.dice20_7
        8 -> R.drawable.dice20_8
        9 -> R.drawable.dice20_9
        10 -> R.drawable.dice20_10
        11 -> R.drawable.dice20_11
        12 -> R.drawable.dice20_12
        13 -> R.drawable.dice20_13
        14 -> R.drawable.dice20_14
        15 -> R.drawable.dice20_15
        16 -> R.drawable.dice20_16
        17 -> R.drawable.dice20_17
        18 -> R.drawable.dice20_18
        19 -> R.drawable.dice20_19

        else -> R.drawable.dice20_20
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
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { result = (1..20).random() },
            ) {
                Text(text = stringResource(R.string.roll), fontSize = 24.sp)
            }
        }
    }
}