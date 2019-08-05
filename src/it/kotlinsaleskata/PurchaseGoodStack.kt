package it.kotlinsaleskata

import kotlin.math.ceil

open class PurchaseGoodStack(val good: Good, val quantity: Int, val round: (Double) -> Double = ::round): taxable, importable {
    companion object {
        fun round(price: Double) = ceil(price * 20) / 20
    }

    infix fun sumTax(value: Double): Double = round(importTax() + tax() + value)
    infix fun sumPrice(value: Double): Double = price() + value

    fun vanillaPrice(): Double = (good.price * quantity)
    fun price(): Double = vanillaPrice()+importTax()+tax()

    override fun importTax(): Double = round(good.importTax()) * quantity
    override fun tax(): Double = round(good.tax()) * quantity

    private fun importedString() = if (good.imported) " imported " else " "
    override fun toString()
            = "$quantity" + importedString() + good.name + ": %.02f".format(price())
}