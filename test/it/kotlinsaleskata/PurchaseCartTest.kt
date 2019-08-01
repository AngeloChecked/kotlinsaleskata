package it.kotlinsaleskata

import org.junit.*
import kotlin.test.assertEquals

class PurchaseCartTest{

    @Test
    internal fun `Purchase cart should be`() {
        val purchaseGoods = listOf(
            PurchaseGoods(NoTaxableGood("book", 12.49, false), 2),
            PurchaseGoods(Good("music CD", 14.99, false), 1),
            PurchaseGoods(NoTaxableGood("chocolate bar", 0.85, false), 1)
        )

        val purchaseCart = PurchaseCart(purchaseGoods)

        assertEquals(42.32, purchaseCart.total())
        assertEquals(1.50, purchaseCart.salesTaxes())
    }
}