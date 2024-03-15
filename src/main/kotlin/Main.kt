import java.util.Scanner

fun main() {
    val printer = Printer()
    val scanner = Scanner(System.`in`)
    var input: Int

    do {
        println("Menu:")
        println("1. Piramida")
        println("2. Piramida Terbalik")
        println("3. Layang-Layang")
        println("4. X Shape")
        println("5. Piramida Hollow")
        println("6. Exit")
        print("Pilih nomor 1-6: ")

        input = scanner.nextInt()

        when (input) {
            1 -> {
                print("Masukkan tinggi piramida: ")
                val tinggi = scanner.nextInt()
                val piramida = Piramida(tinggi)
                printer.printShape(piramida, tinggi)

            }
            2 -> {
                print("Masukkan tinggi piramida terbalik: ")
                val tinggi = scanner.nextInt()
                val piramidaTerbalik = PiramidaTerbalik(tinggi)
                printer.printShape(piramidaTerbalik, tinggi)
            }
            3 -> {
                print("Masukkan tinggi layang-layang: ")
                val tinggi = scanner.nextInt()
                val layangLayang = LayangLayang(tinggi)
                printer.printShape(layangLayang, tinggi)
            }
            4 -> {
                print("Masukkan tinggi X Shape: ")
                val tinggi = scanner.nextInt()
                val xShape = XShape(tinggi)
                printer.printShape(xShape, tinggi)
            }
            5 -> {
                print("Masukkan tinggi piramida hollow: ")
                val tinggi = scanner.nextInt()
                val piramidaHollow = PiramidaHollow(tinggi)
                printer.printShape(piramidaHollow, tinggi)
            }
            6 -> println("Exiting program...")
            else -> println("Input tidak valid. Mohon masukkan nomor 1-6.")
        }

    } while (input != 6)
}

class Printer {

    fun printShape(shape: Shape, tinggi: Int) {
        println("Mencetak ${shape.name} dengan tinggi $tinggi")
        println()
        shape.print()
        println()
    }
}

interface Shape {
    val name: String
    fun print()
}

class Piramida(val tinggi: Int) : Shape {
    override val name: String
        get() = "Piramida"

    override fun print() {
        for (i in 1..tinggi) {
            for (j in 1..tinggi - i) {
                print(" ")
            }
            for (j in 1..2 * i - 1) {
                print("*")
            }
            println()
        }
    }
}

class PiramidaTerbalik(val tinggi: Int) : Shape {
    override val name: String
        get() = "Piramida Terbalik"

    override fun print() {
        for (i in tinggi downTo 1) {
            for (j in 1..tinggi - i) {
                print(" ")
            }
            for (j in 1..2 * i - 1) {
                print("*")
            }
            println()
        }
    }
}

class LayangLayang(val tinggi: Int) : Shape {
    override val name: String
        get() = "Layang Layang"

    override fun print() {
        for (i in 1..tinggi) {
            for (j in 1..tinggi - i) {
                print(" ")
            }
            for (j in 1..2 * i - 1) {
                print("*")
            }
            println()
        }
        for (i in tinggi - 1 downTo 1) {
            for (j in 1..tinggi - i) {
                print(" ")
            }
            for (j in 1..2 * i - 1) {
                print("*")
            }
            println()
        }
    }
}

class XShape(val tinggi: Int) : Shape {
    override val name: String
        get() = "X"

    override fun print() {
        for (i in 1..tinggi) {
            for (j in 1..tinggi) {
                if (j == i || j == tinggi - i + 1) {
                    print("*")
                } else {
                    print(" ")
                }
            }
            println()
        }
    }
}

class PiramidaHollow(val tinggi: Int) : Shape {
    override val name: String
        get() = "Piramida Hollow"

    override fun print() {
        for (i in 0 until tinggi) {
            for (j in 0 until tinggi - i - 1) {
                print(" ")
            }
            if (i == 0 || i == tinggi - 1) {
                for (j in 0 until i * 2 + 1) {
                    print("\u001B[31m*\u001B[0m")
                }
            } else {
                print("\u001B[31m*\u001B[0m")
                for (j in 0 until i * 2 - 1) {
                    print(" ")
                }
                print("\u001B[31m*\u001B[0m ")
            }
            println()
        }
    }
}



