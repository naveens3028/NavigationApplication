package com.example.navigationapplication.sealed

import android.util.Log
import kotlin.math.sign

sealed class MySealedClass {
    object Demo : MySealedClass() {
        fun myFun() {
            Log.e("squarefunc", "12345")
        }
    }
}

open class Example: NonSealedClass() {

    open fun myDemo(){
        super.myDemos()
        MySealedClass.Demo.myFun()
        val d1= MySealedClass.Demo
        println("PRINTER------------->"+d1.myFun())
        fibonacci()
        stringReversal()
    }

    open fun fibonacci(){
        var t1 = 0
        var t2 = 1

        for (i in 0 until 20){

            print("$t1  ")

            t1 = t2
            t2 += t1

        }
    }


    open fun stringReversal(){
        val nums = "12345"
        val arr = nums.toCharArray()

        for (i in (arr.size-1).downTo(0)){
            println("${arr[i]}  ")
        }

    }



    open fun contiguousPerfectSquare(arr: IntArray, n: Int): Int {
        var a: Int
        var b: Float
        var current_length = 0
        var max_length = 0
        for (i in 0 until n) {
            b = Math.sqrt(arr[i].toDouble()).toFloat()
            a = b.toInt()

            // if both a and b are equal then
            // arr[i] is a perfect square
            if (a.toFloat() == b) current_length++ else current_length = 0
            max_length = Math.max(max_length, current_length)
        }
        return max_length
    }


    override fun myDemos() {
        super.myDemos()
    }
}