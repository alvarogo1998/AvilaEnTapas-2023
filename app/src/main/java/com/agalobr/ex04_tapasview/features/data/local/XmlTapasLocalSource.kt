package com.agalobr.ex04_tapasview.features.data.local

import android.content.Context
import com.agalobr.ex04_tapasview.app.Either
import com.agalobr.ex04_tapasview.app.ErrorApp
import com.agalobr.ex04_tapasview.app.extensions.JsonSerialization
import com.agalobr.ex04_tapasview.app.left
import com.agalobr.ex04_tapasview.app.right
import com.agalobr.ex04_tapasview.features.domain.Tapas

class XmlTapasLocalSource (context: Context, private val gson: JsonSerialization){

    private val sharedPref = context.getSharedPreferences("Tapas", Context.MODE_PRIVATE)


    fun save(listTapas: List<Tapas>): Either<ErrorApp, List<Tapas>>{
        return try {
            listTapas.forEach { tapas->
                sharedPref.edit().apply {
                    putString(tapas.id.toString(), gson.toJson(tapas, Tapas::class.java))
                }
            }
            listTapas.right()
        }catch (ex: Exception){
            ErrorApp.DataError.left()
        }
    }

    fun getAll():Either<ErrorApp, List<Tapas>>{
        return try {
            val tapasMap = sharedPref.all as Map<String, String>
            tapasMap.values.map {jsonTapas->
                gson.fromJson(jsonTapas, Tapas::class.java)
            }.right()
        } catch (ex: Exception){
            ErrorApp.DataError.left()
        }
    }
}