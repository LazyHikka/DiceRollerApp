package com.example.botnavbar

sealed class Screens (val screen:String){
    data object d20: Screens("d20")
    data object d8: Screens("d8")
    data object d6: Screens("d6")
    data object d4: Screens("d4")
}