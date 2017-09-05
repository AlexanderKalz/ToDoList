package de.drkalz.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by Alex on 03.09.17.
 */
open class ToDOItem : RealmObject() {
    @PrimaryKey
    private var id = UUID.randomUUID().toString()
    var item = ""
    var important = false

    fun getId(): String {
        return id
    }
}