package it.kotlinsaleskata

import org.junit.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GoodTest{

    @Test
    internal fun `good tax should be 10% of the price and importTax should be 5% of the price` () {
        val price = 14.99
        val good = Good("music cd", 14.99, true)

        assertEquals( price/100*10, good.tax())
        assertEquals(price/100*5, good.importTax())
     }

    @Test
    internal fun `noTaxableGood tax should be 0`() {
        val price = 12.49
        val good = NoTaxableGood("book", price)

        assertEquals(0.0, good.tax())
    }
}