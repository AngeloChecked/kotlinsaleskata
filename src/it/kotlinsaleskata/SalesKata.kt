package it.kotlinsaleskata

class SalesKata {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val purchaseGoods = listOf(
                PurchaseGoodStack(NoTaxableGood("book", 12.49, false), 2),
                PurchaseGoodStack(Good("music CD", 14.99, false), 1),
                PurchaseGoodStack(NoTaxableGood("chocolate bar", 0.85, false), 1)
            )

            val purchaseCart = PurchaseCart(purchaseGoods)

            print(purchaseCart)
        }
    }
}