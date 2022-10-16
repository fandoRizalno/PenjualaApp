package iglo.indocyber.penjualan

import android.app.Application
import iglo.indocyber.penjualan.module.useCaseModule
import iglo.indocyber.penjualan.module.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PenjualanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@PenjualanApplication)
            modules(vmModule, useCaseModule)
        }
    }
}