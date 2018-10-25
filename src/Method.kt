class Method(var lowerBound: Double, var higherBound: Double, var precision: Double, var function: Functions) {
    var result: Double = 0.0
    var number: Int = 0
    var RungePrecision: Double = 0.0
    fun compute() {
        var integral: Double
        var n = 1
        do {
            n *= 2
            integral = function.apply(lowerBound) + function.apply(higherBound)
            var h = (higherBound - lowerBound) / n
            var integral2 = function.apply(lowerBound) + function.apply(higherBound)
            var k = 4
            var x: Double
            var x2: Double
            for (j in 1..(n - 1)) {
                x2 = lowerBound + j * h
                integral2 += k * function.apply(x2)
                k = 6 - k
            }
            integral2 *= h / 3
            k = 4
            n *= 2
            h /= 2
            for (j in 1..(n - 1)) {
                x = lowerBound + j * h
                integral += k * function.apply(x)
                k = 6 - k
            }
            integral *= h / 3
            if (integral.equals(Double.NEGATIVE_INFINITY) || integral.equals(Double.POSITIVE_INFINITY)) break
        } while (!satisfiesPrecision(integral, integral2))
        result = integral
        number = n
    }

    private fun satisfiesPrecision(integralH: Double, integral2H: Double): Boolean {
        RungePrecision = Math.abs(integralH - integral2H) / 15
        return RungePrecision < precision
    }
}