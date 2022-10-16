package iglo.indocyber.service.usecase

import iglo.indocyber.common.entity.Product
import iglo.indocyber.common.entity.productA.Content
import iglo.indocyber.service.rService.ProductService
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class ProductUseCase() {
    operator fun invoke() = flow {
        val product = arrayListOf<Product>(
            Product(
                "SKHPPA", "So Klin Pewangi", 15000.00, "IDR",
                10, "13cm x 10cm", "PCS"
            ),
            Product(
                "AEDS", "Giv Biru", 11000.00, "IDR",
                0, "5cm x 2cm", "PCS"
            ),
            Product(
                "LOLST", "So Klin Liquid", 18000.00, "IDR",
                0, "13cm x 10cm", "PCS"
            ),
            Product(
                "TOTWEW", "Giv Kuning", 10000.00, "IDR",
                0, "5cm x 2cm", "PCS"
            )
        )

        emit(product)
    }
//    operator fun invoke() = flow<List<Content>>{
//        val product = productService.getProduct()
//        if(product.isSuccessful){
//            product.body()?.let {
//                emit(it.content)
//            }
//        }
//}


}