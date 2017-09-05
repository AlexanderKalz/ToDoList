package de.drkalz.todolist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        title = "New To Do Item"

        val button = findViewById<Button>(R.id.buAdd)
        val editText = findViewById<EditText>(R.id.etItem)
        val checkBox = findViewById<CheckBox>(R.id.cbImportant)

        button.setOnClickListener {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            val toDo = ToDOItem()
            toDo.item = editText.text.toString()
            toDo.important = checkBox.isChecked
            realm.copyToRealm(toDo)
            realm.commitTransaction()

            finish()
        }
    }
}
