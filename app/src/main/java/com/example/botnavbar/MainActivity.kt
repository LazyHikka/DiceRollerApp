package com.example.botnavbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.botnavbar.ui.theme.BotNavBarTheme
import com.example.botnavbar.ui.theme.GreenBN


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotNavBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MyBottomAppBar()
                }
            }
        }
    }
}


@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = GreenBN
            ) {
                IconButton(
                    onClick = {
                              selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.d20.screen){
                            popUpTo(0)
                        }
                },
                modifier = Modifier.weight(1f) ) {
                    Image(painter = painterResource(R.drawable.d20_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        contentScale = ContentScale.Fit)

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.d8.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f) ) {
                    Image(painter = painterResource(R.drawable.d8_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        contentScale = ContentScale.Fit)

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Build
                        navigationController.navigate(Screens.d6.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f) ) {
                    Image(painter = painterResource(R.drawable.d6_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        contentScale = ContentScale.Fit)

                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Add
                        navigationController.navigate(Screens.d4.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f) ) {
                    Image(painter = painterResource(R.drawable.d4_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        contentScale = ContentScale.Fit)

                }
            }
        }
    ) {paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.d20.screen,
            modifier = Modifier.padding(paddingValues)) {
            composable(Screens.d20.screen){ d20()}
            composable(Screens.d8.screen){ d8() }
            composable(Screens.d6.screen){ d6() }
            composable(Screens.d4.screen){ d4() }
        }

    }
}