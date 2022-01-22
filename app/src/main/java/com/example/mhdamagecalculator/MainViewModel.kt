package com.example.mhdamagecalculator

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val rawModifierList = listOf(4.8, 3.3, 1.4, 1.4, 5.2, 4.2, 2.3, 2.3,
        3.5, 3.1, 3.6, 1.3, 1.5, 1.2)

    // Sets default values that can be changed
    var dmgList = calculateEqDmgValues(0, 0)
    var trueRaw = calculateRaw(0, 0)

    fun calculateRaw(bloatedValue: Int, weaponCode: Int): Int {
        return (bloatedValue / rawModifierList[weaponCode]).toInt()
    }

    fun calculateEqDmgValues(bloatedValue: Int, weaponCode: Int): MutableList<Int> {
        val eqDmgList = mutableListOf<Int>()
        for (i in 0 until rawModifierList.size) {
            eqDmgList.add(i, (calculateRaw(bloatedValue, weaponCode) * rawModifierList[i]).toInt())
        }
        return eqDmgList
    }
}