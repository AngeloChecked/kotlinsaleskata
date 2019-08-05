package it.kotlinsaleskata

import org.junit.*

import kotlin.test.assertEquals

class PurchaseStackTest {

    @Test
    fun `round up nearest number 0 05`() {
        assertEquals( .05,PurchaseGoodStack.round(0.01))
        assertEquals( .05,PurchaseGoodStack.round(.02))
        assertEquals( .05,PurchaseGoodStack.round(.03))
        assertEquals( .05,PurchaseGoodStack.round(.04))
        assertEquals( .05,PurchaseGoodStack.round(.05))
        assertEquals( .1,PurchaseGoodStack.round(.06))
        assertEquals( .1,PurchaseGoodStack.round(.07))
        assertEquals( .1,PurchaseGoodStack.round(.08))
        assertEquals( .1,PurchaseGoodStack.round(.09))
        assertEquals( .1,PurchaseGoodStack.round(.1))
    }

    @Test
    internal fun `purchaseGood should have sum of price and importTax with importTax Rounded nearest number 0 05`() {
        val price = 11.25
        val good = Good( "box of chocolates", price, true)
        val purchaseGood = PurchaseGoodStack(good,3)

        assertEquals(35.55, purchaseGood.price())
    }

    @Test
    fun `purchaseGood toString should be a pattern (quantity) (imported) (name) (price)`() {
        val good = NoTaxableGood("box of chocolates", 11.25, true)
        val purchaseGood = PurchaseGoodStack(good,3)

        assertEquals("3 imported box of chocolates: 35.55", purchaseGood.toString())
    }

    @Test
    fun `no imported purchaseGood toString should be a pattern (quantity) (name) (price)`() {

        val good = Good("bottle of perfume", 18.99, false)
        val purchaseGood = PurchaseGoodStack(good,1)

        assertEquals("1 bottle of perfume: 20.89", purchaseGood.toString())
    }
}