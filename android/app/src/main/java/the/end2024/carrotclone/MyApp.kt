package the.end2024.carrotclone

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import the.end2024.carrotclone.data.di.dataModule
import the.end2024.carrotclone.presentation.di.viewModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApp)
            modules(viewModule + dataModule)
        }
    }
}