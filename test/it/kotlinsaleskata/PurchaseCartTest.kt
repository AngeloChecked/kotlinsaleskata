package it.kotlinsaleskata

import org.junit.*
import kotlin.test.assertEquals

class PurchaseCartTest{

    @Test
    internal fun `match output purchase cart 1`() {
        val purchaseGoods = listOf(
            PurchaseGoodStack(NoTaxableGood("book", 12.49, false), 2),
            PurchaseGoodStack(Good("music CD", 14.99, false), 1),
            PurchaseGoodStack(NoTaxableGood("chocolate bar", 0.85, false), 1)
        )

        val purchaseCart = PurchaseCart(purchaseGoods)

        assertEquals(42.32, purchaseCart.total())
        assertEquals(1.50, purchaseCart.salesTaxes())
    }

    @Test
    internal fun `match output purchase cart 2`() {
        val purchaseGoods = listOf(
            PurchaseGoodStack(NoTaxableGood("box of chocolates", 10.00, true), 1),
            PurchaseGoodStack(Good("bottle of perfume", 47.50, true), 1)
        )

        val purchaseCart = PurchaseCart(purchaseGoods)

        assertEquals(65.15, purchaseCart.total())
        assertEquals(7.65, purchaseCart.salesTaxes())
    }

    @Test
    internal fun `match output purchase cart 3`() {
        val purchaseGoods = listOf(
            PurchaseGoodStack(Good("bottle of perfume", 27.99, true), 1),
            PurchaseGoodStack(Good("bottle of perfume", 18.99, false), 1),
            PurchaseGoodStack(NoTaxableGood("packet of headache pills", 9.75, false), 1),
            PurchaseGoodStack(NoTaxableGood("box of chocolates", 11.25, true), 3)
        )

        val purchaseCart = PurchaseCart(purchaseGoods)

        assertEquals(98.38, purchaseCart.total())
        assertEquals(7.90, purchaseCart.salesTaxes())
    }
}