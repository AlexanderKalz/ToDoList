package de.drkalz.todolist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        title = "New To Do Item"


    }
}
