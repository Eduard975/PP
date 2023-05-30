import java.beans.Expression
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

enum class TokenType{
    Minus, Plus, Ori, Impartit, Par_st, Par_dr, Numar
}

class Token(var tip: TokenType? = null, var prioritate: Int? = null, var valoare: Double? = null) {
    override fun toString(): String {
        return "Token(tip=$tip, prioritate=$prioritate, valoare=$valoare)"
    }
}

fun Turn_Into_Token(equation: String) : ArrayList<Token>{
    val lista = ArrayList<Token>()
    var i = 0
    while(i < equation.length) {
        when(equation[i]) {
            '(' -> {
                lista.add(Token(TokenType.Par_st))
                i++
            }

            ')' -> {
                lista.add(Token(TokenType.Par_dr))
                i++
            }

            '-' -> {
                lista.add(Token(TokenType.Minus, 1))
                i++
            }

            '+' -> {
                lista.add(Token(TokenType.Plus, 1))
                i++
            }

            '*' -> {
                lista.add(Token(TokenType.Ori, 2))
                i++
            }

            '/' -> {
                lista.add(Token(TokenType.Impartit, 2))
                i++
            }

            else -> {
                if (equation[i].isDigit()) {
                    val begin = i
                    while (i < equation.length && equation[i].isDigit()) {
                        i++
                    }
                    lista.add(Token(TokenType.Numar, 0, equation.substring(begin until i).toDouble()))
                }else {
                    val err = equation[i]
                    System.err.println("Error! $err is not a valid number")
                    exitProcess(0)
                }
            }
        }
    }

    return lista
}
fun Calcule(tokenuri:ArrayDeque<Token>): Double = with(Stack<Double>()) {
    tokenuri.forEach{
        when(it.tip){
            TokenType.Plus -> {
                val a = pop()
                val b = pop()
                push(a+b)
            }

            TokenType.Minus -> {
                val a = pop()
                val b = pop()
                push(a - b)
            }

            TokenType.Ori -> {
                val a = pop()
                val b = pop()
                push(a * b)
            }

            TokenType.Impartit -> {
                val a = pop()
                val b = pop()
                push(a / b)
            }
            else -> push(it.valoare)
        }
    }
    pop()
}

fun Shunting_Yard(tokenuri: ArrayList<Token>) : ArrayDeque<Token> {
    val output = ArrayDeque<Token>()
    val operatori_s = Stack<Token>()
    for (this_token in tokenuri) {
        when (this_token.tip) {
            TokenType.Numar -> output.add(this_token)
            TokenType.Par_st -> operatori_s.push(this_token)
            TokenType.Par_dr -> while (operatori_s.isNotEmpty() && (operatori_s.last().tip != TokenType.Par_st)) {
                output.add(operatori_s.pop())
            }

            TokenType.Plus, TokenType.Minus, TokenType.Ori, TokenType.Impartit -> {
                while (operatori_s.isNotEmpty() && ((operatori_s.last().tip != TokenType.Par_st) && (operatori_s.last().prioritate!! >= this_token.prioritate!!))) {
                    output.add(operatori_s.last())
                    operatori_s.pop()
                }
                operatori_s.add(this_token)
            }

            else -> {}
        }
    }

    while (operatori_s.isNotEmpty()) {
        if (operatori_s.last().tip != TokenType.Par_st)
            output.add(operatori_s.pop())
        else
            operatori_s.pop()
    }
    return output
}

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    print("Enter your Mathematical expression: ")
    val equation = reader.next()
    val lista = Turn_Into_Token(equation)
    val output = Shunting_Yard(lista)
    println("Rezultat: " + Calcule(output))
}