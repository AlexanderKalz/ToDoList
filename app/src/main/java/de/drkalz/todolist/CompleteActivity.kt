package de.drkalz.todolist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.TextView
import io.realm.Realm

class CompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        title = "Complete to do"


        val id = intent.getStringExtra("item")
        val realm = Realm.getDefaultInstance()
        val completeItem = realm.where(ToDOItem::class.java).equalTo("id", id).findFirst()

        val item = findViewById<TextView>(R.id.tvItem)

        val important = findViewById<RadioButton>(R.id.radioButton)


    }
}
