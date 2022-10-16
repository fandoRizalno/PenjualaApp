package iglo.indocyber.penjualan.module

import iglo.indocyber.penjualan.view_model.LoginViewModel
import iglo.indocyber.penjualan.view_model.ProductViewModel
import iglo.indocyber.service.usecase.LoginUseCase
import iglo.indocyber.service.usecase.ProductUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel {
        LoginViewModel(get(),get())
    }
    viewModel {
        ProductViewModel(get(),get())
    }

}

val useCaseModule = module {
    factory {
        ProductUseCase()
    }
    factory {
        LoginUseCase()
    }
}

//val networkService = module {
//    single {
//        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
//    }
//
//    single {
//        Retrofit.Builder().baseUrl("http://192.168.6.13:7171/").client(get())
//            .addConverterFactory(GsonConverterFactory.create(Gson())).build()
//    }
//
//    single {
//        get<Retrofit>().create(ProductService::class.java)
//    }
//    single {
//        get<Retrofit>().create(UserService::class.java)
//    }
//}