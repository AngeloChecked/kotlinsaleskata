package it.kotlinsaleskata

import kotlin.math.ceil



open class PurchaseGoods(val good: Good, val quantity: Int, val round: (Double) -> Double = ::round): taxable, importable {
    companion object {
        fun round(price: Double) = ceil(price * 20) / 20
    }

    fun vanillaPrice(): Double = (good.price * quantity)
    fun price(): Double = vanillaPrice()+importTax()+tax()

    override fun importTax(): Double = round(good.importTax()) * quantity
    override fun tax(): Double = round(good.tax()) * quantity

    private fun importedString() = if (good.imported) " imported " else " "
    override fun toString()
            = "$quantity" + importedString() + good.name + ": %.02f".format(price())
}