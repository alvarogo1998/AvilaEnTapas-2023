package com.agalobr.ex04_tapasview.features.data

import com.agalobr.ex04_tapasview.app.Either
import com.agalobr.ex04_tapasview.app.ErrorApp
import com.agalobr.ex04_tapasview.features.data.local.XmlTapasLocalSource
import com.agalobr.ex04_tapasview.features.data.remote.ApiTapasRemoteSource
import com.agalobr.ex04_tapasview.features.domain.Tapas
import com.agalobr.ex04_tapasview.features.domain.TapasRepository

class TapasDataRepository(
    private val localDataSource: XmlTapasLocalSource,
    private val remoteDataSource: List<Tapas> = ApiTapasRemoteSource.listTapas
) : TapasRepository {
    override fun get(): Either<ErrorApp, List<Tapas>> {
        val list = localDataSource.getAll()
        return if (list.isLeft() || list.get().isEmpty()) {
            localDataSource.save(remoteDataSource)
        } else {
            list
        }
    }
}