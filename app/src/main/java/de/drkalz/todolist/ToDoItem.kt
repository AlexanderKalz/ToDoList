package de.drkalz.todolist

import io.realm.RealmObject

/**
 * Created by Alex on 03.09.17.
 */
open class Dog : RealmObject() {
    public var item = ""
    public var important = false
}