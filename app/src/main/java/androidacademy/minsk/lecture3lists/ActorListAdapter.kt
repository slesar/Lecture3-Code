package androidacademy.minsk.lecture3lists

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidacademy.minsk.lecture3lists.data.Actor
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

private val imageOption = RequestOptions()
    .placeholder(R.drawable.avatar_default_list)
    .fallback(R.drawable.avatar_default_list)
    .centerCrop()

class ActorListAdapter(
    context: Context,
    private val actors: List<Actor>
) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = actors.size

    override fun getItem(position: Int): Actor = actors[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row: View
        val holder: ViewHolder
        if (convertView == null) {
            holder = onCreateViewHolder(parent)
            row = holder.itemView
            row.tag = holder
        } else {
            row = convertView
            holder = row.tag as ViewHolder
        }
        onBindViewHolder(holder, position)
        return row
    }

    private fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false))
    }

    private fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class ViewHolder(val itemView: View) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatar)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val oscar: ImageView = itemView.findViewById(R.id.oscar)

        fun bind(actor: Actor) {
            Glide.with(avatar)
                .load(actor.avatar)
                .apply(imageOption).into(avatar)
            name.text = actor.name
            oscar.visibility = if (actor.hasOscar) View.VISIBLE else View.GONE
        }
    }

}