package com.ripalay.store.di

import com.ripalay.store.ui.profile.orders.OrdersViewModel
import com.ripalay.store.ui.catalogue.CatalogueViewModel
import com.ripalay.store.ui.detail_caps_fragment.DetailCapsViewModel
import com.ripalay.store.ui.home_fragment.HomeViewModel
import com.ripalay.store.ui.profile.order_details.OrderDetailsViewModel
import com.ripalay.store.ui.profile.profile_fragment.ProfileViewModel
import com.ripalay.store.ui.sign_in.SignInViewModel
import com.ripalay.store.ui.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { CatalogueViewModel(get()) }
    viewModel { DetailCapsViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { OrdersViewModel(get()) }
    viewModel { OrderDetailsViewModel(get()) }
}