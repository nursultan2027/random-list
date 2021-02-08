package kz.nurs.randomlist

import kz.nurs.randomlist.model.Event
import kz.nurs.randomlist.model.Move
import kz.nurs.randomlist.model.Notice
import java.util.*

class RandomElements{
    private val list: ArrayList<Element> = arrayListOf()
    private val baseTypeList: ArrayList<Element> = arrayListOf(
        Event(),
        Notice(),
        Move()
    )

    fun addNewType(newType: Element){
        if(isNotExist(newType)){
            baseTypeList.add(newType)
        }
    }

    private fun generateType(): Int {
        return kotlin.random.Random.nextInt(0, baseTypeList.size+1)
    }

    private fun isNotExist(newType: Element): Boolean {
        var exist = 0
        for (i in 0 until baseTypeList.size){
            if(i.javaClass.simpleName == baseTypeList[0].javaClass.simpleName){
                exist++
            }
        }
        return exist <= 0
    }

    fun generateData(): ArrayList<Element> {
        val elementsCount = RandomHelper().generateElementsCount()
        for (i in 0 until elementsCount){
            val type = generateType()
            list.add(baseTypeList[type].generateRandom())
        }
        return list
    }
}