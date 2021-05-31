package com.sobarna.wecandoit.di


import com.sobarna.wecandoit.domain.usecase.MovieInteract
import com.sobarna.wecandoit.domain.usecase.MovieUseCase
import com.sobarna.wecandoit.viewmodel.DetailViewModel
import com.sobarna.wecandoit.viewmodel.FavoriteViewModel
import com.sobarna.wecandoit.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module


val useCaseModule = module {
    factory<MovieUseCase> { MovieInteract(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}