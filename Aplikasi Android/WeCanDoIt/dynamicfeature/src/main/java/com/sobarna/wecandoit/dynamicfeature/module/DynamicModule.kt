package com.sobarna.wecandoit.dynamicfeature.module

import com.sobarna.wecandoit.dynamicfeature.DynamicFeatureViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dynamicModule = module {
    viewModel { DynamicFeatureViewModel(get()) }
}