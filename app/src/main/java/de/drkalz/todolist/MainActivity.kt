package de.drkalz.todolist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            var addItemIntent = Intent(this, AddItemActivity::class.java)
            startActivity(addItemIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val query = realm.where(ToDOItem::class.java)
        val results = query.findAll()

        val listView = findViewById<ListView>(R.id.lvToDo)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)

        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val selectedToDo = results[i]
            val completeIntent = Intent(this, CompleteActivity::class.java)
            completeIntent.putExtra("item", selectedToDo.getId())
            startActivity(completeIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
