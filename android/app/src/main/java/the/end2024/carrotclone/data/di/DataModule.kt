package the.end2024.carrotclone.data.di

import org.koin.dsl.module

private val apiModule = module {

}

private val repositoryModule = module {

}

private val dataSourceModule = module {

}

val dataModule = apiModule + repositoryModule + dataSourceModule