package com.ripalay.store.di

import com.ripalay.store.ui.catalogue.CatalogueViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel{CatalogueViewModel(get())}
}