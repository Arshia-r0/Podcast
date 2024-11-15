package com.arshia.podcast.core.data.di

import com.arshia.podcast.core.data.auth.AuthRepository
import com.arshia.podcast.core.data.auth.KtorAuthRepository
import com.arshia.podcast.core.data.book.BookRepository
import com.arshia.podcast.core.data.book.KtorBookRepository
import com.arshia.podcast.core.data.userdata.UserDataRepository
import com.arshia.podcast.core.data.userdata.UserDataRepositoryImp
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {

    singleOf(::UserDataRepositoryImp) {
        bind<UserDataRepository>()
    }

    singleOf(::KtorAuthRepository) {
        bind<AuthRepository>()
    }

    singleOf(::KtorBookRepository) {
        bind<BookRepository>()
    }

} 
