package it.kotlinsaleskata

interface taxable {
    fun tax(): Double
}

interface importable {
    fun importTax(): Double
}

open class Good(val name: String, val price: Double, val imported: Boolean = false): taxable, importable {
    override fun tax() = (price / 100) * 10
    override fun importTax() = if (imported) (price / 100) * 5 else 0.0
}

class NoTaxableGood(name: String, price: Double, imported: Boolean = false) : Good(name, price, imported) {
    override fun tax() = 0.0
}