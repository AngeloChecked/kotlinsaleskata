package it.kotlinsaleskata

import org.junit.*

import kotlin.test.assertEquals

class PurchaseGoodsTest {

    @Test
    internal fun `purchaseGood should have sum of price and importTax with importTax Rounded nearest number 0 05`() {
        val price = 11.25
        val good = Good( "box of chocolates", price, true)
        val purchaseGood = PurchaseGoods(good,3)

        assertEquals(35.55, purchaseGood.price())
    }

    @Test
    fun `purchaseGood toString should be a pattern (quantity) (imported) (name) (price)`() {
        val good = NoTaxableGood("box of chocolates", 11.25, true)
        val purchaseGood = PurchaseGoods(good,3)

        assertEquals("3 imported box of chocolates: 35.55", purchaseGood.toString())
    }

    @Test
    fun `no imported purchaseGood toString should be a pattern (quantity) (name) (price)`() {

        val good = Good("bottle of perfume", 18.99, false)
        val purchaseGood = PurchaseGoods(good,1)

        assertEquals("1 bottle of perfume: 20.89", purchaseGood.toString())
    }

    @Test
    fun `round up nearest number 0 05`() {

        assertEquals( .05,PurchaseGoods.round(0.01))
        assertEquals( .05,PurchaseGoods.round(.02))
        assertEquals( .05,PurchaseGoods.round(.03))
        assertEquals( .05,PurchaseGoods.round(.04))
        assertEquals( .05,PurchaseGoods.round(.05))
        assertEquals( .1,PurchaseGoods.round(.06))
        assertEquals( .1,PurchaseGoods.round(.07))
        assertEquals( .1,PurchaseGoods.round(.08))
        assertEquals( .1,PurchaseGoods.round(.09))
        assertEquals( .1,PurchaseGoods.round(.1))

    }
}