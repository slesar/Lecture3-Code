package androidacademy.minsk.lecture3lists

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidacademy.minsk.lecture3lists.data.DataUtil.generateActors
import androidx.appcompat.app.AppCompatActivity

class ActorListActivity : AppCompatActivity() {

    private lateinit var adapter: ActorListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_list)

        val list = findViewById<ListView>(R.id.actorList)
        adapter = ActorListAdapter(this, generateActors())
        list.adapter = adapter
        list.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            val actor = adapter.getItem(position)
            val clickMessage = getString(R.string.actor_click_action, actor.name)
            Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actor_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.switchList -> {
                startActivity(Intent(this, ActorRecyclerActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}