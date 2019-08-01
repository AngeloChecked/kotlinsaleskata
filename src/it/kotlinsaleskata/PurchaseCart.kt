package it.kotlinsaleskata

class PurchaseCart(val purchaseGoods: List<PurchaseGoods>) {
    fun salesTaxes(): Double
            = purchaseGoods.fold(0.0){ sum, element -> element.tax() + sum }

    fun total(): Double
            = purchaseGoods.fold(0.0) { sum, element -> element.price() + sum }

    override fun toString(): String
        = purchaseGoods.fold("") {string, element -> string + element + "\n"}
}