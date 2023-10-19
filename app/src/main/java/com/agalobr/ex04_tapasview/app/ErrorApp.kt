package com.agalobr.ex04_tapasview.app

sealed class ErrorApp {
    object UnKonowError : ErrorApp()
    object DataError : ErrorApp()
}