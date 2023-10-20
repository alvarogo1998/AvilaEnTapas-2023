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
                "https://scontent.fmad5-1.fna.fbcdn.net/v/t39.30808-6/356045542_781267970071828_8583688896678884086_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_ohc=c-yidyEapDwAX8dC9ut&_nc_ht=scontent.fmad5-1.fna&oh=00_AfAU7HD55_pRaxTudb8YJxAIAbqrHnmmWZ9POKLFyWkETw&oe=6536AFE9"
            )
        )
    }
}