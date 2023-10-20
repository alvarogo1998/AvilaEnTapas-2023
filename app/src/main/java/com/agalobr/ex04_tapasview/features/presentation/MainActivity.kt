package com.agalobr.ex04_tapasview.features.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.agalobr.ex04_tapasview.app.extensions.GsonSerialization
import com.agalobr.ex04_tapasview.app.extensions.loadUrl
import com.agalobr.ex04_tapasview.databinding.ItemTapasAvilaBinding
import com.agalobr.ex04_tapasview.features.data.TapasDataRepository
import com.agalobr.ex04_tapasview.features.data.local.XmlTapasLocalSource
import com.agalobr.ex04_tapasview.features.data.remote.ApiTapasRemoteSource
import com.agalobr.ex04_tapasview.features.domain.GetTapasUseCase
import com.agalobr.ex04_tapasview.features.domain.Tapas

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ItemTapasAvilaBinding

    private val viewModel: TapasViewModel by lazy {
        TapasViewModel(
            GetTapasUseCase(
                TapasDataRepository(
                    XmlTapasLocalSource(this, GsonSerialization()),
                    ApiTapasRemoteSource.listTapas
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemTapasAvilaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpObserver()
        viewModel.loadTapas()

    }

    private fun setUpObserver() {
        val observer = Observer<TapasViewModel.UiState> {
            it.listTapas.apply{
                bindView(this.first())
            }
        }
        viewModel.uiState.observe(this, observer)
    }

    private fun bindView(tapas: Tapas) {
        binding.apply {
            imageTapa.loadUrl(tapas.image)
            textNumPosition.text = tapas.position
            textDescription.text = tapas.desription
            textNameRestaurant.text = tapas.nameRestaurant
            textPoints.text = tapas.points
            textTotalAverage.text = tapas.average
        }
    }

}