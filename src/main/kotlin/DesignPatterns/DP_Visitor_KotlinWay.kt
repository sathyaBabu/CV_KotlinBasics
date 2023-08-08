package DesignPatterns
//import visitor.addition.Expression.*

interface Visitor9 {
    fun visit(expression: Expression)
}

sealed class Expression {
    fun accept(visitor: Visitor9) = visitor.visit(this)

    class Num(val value: Int) : Expression()

    class Sum(val left: Expression, val right: Expression) : Expression()
    class Mul(val left: Expression, val right: Expression) : Expression()
}

class PrintVisitor9() : Visitor9 {
    val sb = StringBuilder()

    override fun visit(e: Expression) {
        val x = when (e) {
            is Expression.Num -> sb.append(e.value)
            is Expression.Sum -> letsPadIt("+", e.left, e.right)
            is Expression.Mul -> letsPadIt("*", e.left, e.right)
            else -> {}
        }
    }

    fun letsPadIt(name : String, left: Expression, right: Expression) {
        sb.append('(')
        left.accept(this); sb.append(name); right.accept(this)
        sb.append(')')
    }

}

fun main() {
    val exp = Expression.Sum(Expression.Mul(Expression.Num(9), Expression.Num(10)), Expression.Sum(Expression.Num(1),
        Expression.Num(2)
    ))
    val visitor = PrintVisitor9()
    exp.accept(visitor)

    println(visitor.sb) // Output : ((9*10)+(1+2))
}

// Output : ((9*10)+(1+2))