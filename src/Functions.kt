import java.util.function.UnaryOperator

enum class Functions(val func: String) : UnaryOperator<Double> {
    FIRST("f(x) = ln(x) / x") {
        override fun apply(x: Double): Double {
            return Math.log(x) / x
        }
    },
    SECOND("f(x) = 3x^2") {
        override fun apply(x: Double): Double {
            return 3 * Math.pow(x, 2.0)
        }
    },
    THIRD("f(x) = 1 / (2sin(x) + cos(x) + 5)") {
        override fun apply(x: Double): Double {
            return 1 / (2 * Math.sin(x) + Math.cos(x) + 5)
        }
    },
    FOURTH("f(x) = (x^8 - 1) / (x(x^8 + 1))") {
        override fun apply(x: Double): Double {
            return (Math.pow(x, 8.0) - 1) / (x * (Math.pow(x, 8.0) + 1))
        }
    };

    abstract override fun apply(x: Double): Double
}