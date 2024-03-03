package the.end2024.carrotclone.presentation.di

import org.koin.dsl.module
import the.end2024.carrotclone.presentation.ex.ExViewModel

private val viewModelModule = module {
    single { ExViewModel() }
}

val viewModule = viewModelModule