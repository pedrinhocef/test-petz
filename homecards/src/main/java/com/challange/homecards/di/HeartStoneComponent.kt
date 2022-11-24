package com.challange.homecards.di

import com.challange.cache.homecards.repository.HomeCardsCacheRep
import com.challange.homecards.data.repository.HeartStoneRepository
import com.challange.homecards.data.repository.HeartStoneRepositoryImpl
import com.challange.homecards.data.usecase.HeartStoneUseCase
import com.challange.homecards.data.usecase.HeartStoneUseCaseImpl
import com.challange.homecards.view.viewmodel.HeartStoneViewModel
import com.challange.network.service.HearthstoneService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeartStoneViewModel(useCase = get()) }
}

val useCaseModule = module {
    factory <HeartStoneUseCase>  { HeartStoneUseCaseImpl(repository = get(), cache = get()) }
}

val repositoryModule = module {
    factory <HeartStoneRepository>  { HeartStoneRepositoryImpl(hearthstoneService = get()) }
}

val cache =  module {
    single { HomeCardsCacheRep }
}

val serviceModule = module {
    single { HearthstoneService() }
}


object HeartStoneComponent : KoinComponent {
    fun inject() = loadKoinModules(
        listOf(
            viewModelModule,
            useCaseModule,
            repositoryModule,
            serviceModule,
            cache
        )
    )
}