package androidacademy.minsk.lecture3lists

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidacademy.minsk.lecture3lists.data.Actor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

private val imageOption = RequestOptions()
    .placeholder(R.drawable.avatar_default_list)
    .fallback(R.drawable.avatar_default_list)
    .centerCrop()

class ActorRecyclerAdapter(
    context: Context,
    private val actors: List<Actor>,
    private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    fun getItem(position: Int): Actor = actors[position]

    class ViewHolder(itemView: View, listener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatar)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val oscar: ImageView = itemView.findViewById(R.id.oscar)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(actor: Actor) {
            Glide.with(avatar)
                .load(actor.avatar)
                .apply(imageOption).into(avatar)
            name.text = actor.name
            oscar.visibility = if (actor.hasOscar) View.VISIBLE else View.GONE
        }
    }
}