package it.kotlinsaleskata

class PurchaseCart(val purchaseGoods: List<PurchaseGoodStack>) {
    fun salesTaxes(): Double
            = purchaseGoods.fold(0.0){ sum, element -> element sumTax sum }

    fun total(): Double
            = purchaseGoods.fold(0.0) { sum, element -> element sumPrice sum }

    override fun toString(): String
        = purchaseGoods.fold("") {string, element -> string + element + "\n"} +
            "Sales Taxes: " + salesTaxes() + "\n" +
            "Total: " + total()
}