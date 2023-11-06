package com.agalobr.ex04_tapasview.features.data.remote

import com.agalobr.ex04_tapasview.features.domain.Tapas

class ApiTapasRemoteSource {
    companion object {
        val listTapas: List<Tapas> = listOf(

            Tapas(
                1,
                "Comida",
                "2",
                "Casa de Pèpe",
                "6",
                "8.0",
                "https://chankete.com/wp-content/uploads/2022/01/Plato-de-degustacio%CC%81n-de-tapas.jpeg"
            )
        )
    }
}