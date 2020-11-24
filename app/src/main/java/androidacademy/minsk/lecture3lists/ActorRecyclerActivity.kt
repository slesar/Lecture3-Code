package androidacademy.minsk.lecture3lists

import android.os.Bundle
import android.widget.Toast
import androidacademy.minsk.lecture3lists.data.DataUtil.generateActors
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ActorRecyclerActivity : AppCompatActivity() {

    private lateinit var adapter: ActorRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_recycler)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = findViewById<RecyclerView>(R.id.actorList)
        adapter = ActorRecyclerAdapter(this, generateActors()) {
            val actor = adapter.getItem(it)
            val clickMessage = getString(R.string.actor_click_action, actor.name)
            Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}