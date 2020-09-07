package com.avic.kotlinfirst.diffUtil

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import java.util.logging.Logger

class ContactDiffUtilCallBack(val newList: List<Person>, val oldList: List<Person>) : DiffUtil.Callback() {

    companion object{
        val log = Logger.getLogger(ContactDiffUtilCallBack::class.java.name)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val result = newList[newItemPosition].compareTo(oldList[oldItemPosition])
        if (result == 0){
            return true
        }
        return false
    }


    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val newPerson = newList[newItemPosition]
        val oldPerson = oldList[oldItemPosition]
        val bundle = Bundle()
        if (!(newPerson.name == oldPerson.name)){
            log.info("Changes put")
            bundle.putString("name", newPerson.name)
        }
        if (!(newPerson.status == oldPerson.status)){
            log.info("Changes put to status")
            bundle.putString("status", newPerson.status)
        }
        return bundle
    }





}



















