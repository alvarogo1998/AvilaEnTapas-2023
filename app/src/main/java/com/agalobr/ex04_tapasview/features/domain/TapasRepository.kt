package com.agalobr.ex04_tapasview.features.domain

import com.agalobr.ex04_tapasview.app.Either
import com.agalobr.ex04_tapasview.app.ErrorApp

interface TapasRepository {
    fun get():Either<ErrorApp, List<Tapas>>
}