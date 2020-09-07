package com.avic.kotlinfirst.realm

import io.realm.RealmObject

open class Pokemon : RealmObject() {

    var name: String? = null
    var type: String? = null
}