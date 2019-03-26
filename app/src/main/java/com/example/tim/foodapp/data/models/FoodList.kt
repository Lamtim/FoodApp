package com.example.tim.foodapp.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class FoodList(
        var name: String
        //var products: List<Product>?
        ) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    val safeName: String
        get() = name

   /* override fun equals(other: Any?): Boolean {
        if (other == null)
            return false // null check
        if (javaClass != other.javaClass)
            return false // type check

        val mOther = other as FoodList
        return id == mOther.id
                && name == mOther.name
                && products == mOther.products
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, products)
    }*/
}