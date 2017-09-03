package de.drkalz.todolist

import android.app.Application
import io.realm.Realm

/**
 * Created by Alex on 03.09.17.
 */
public class ToDoList : Application() {
    public override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}