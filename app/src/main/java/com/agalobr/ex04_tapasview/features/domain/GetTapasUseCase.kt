package com.agalobr.ex04_tapasview.features.domain

import com.agalobr.ex04_tapasview.app.Either
import com.agalobr.ex04_tapasview.app.ErrorApp

class GetTapasUseCase(private val repository: TapasRepository){

    operator fun invoke():Either<ErrorApp, List<Tapas>>{
        return repository.get()
    }
}