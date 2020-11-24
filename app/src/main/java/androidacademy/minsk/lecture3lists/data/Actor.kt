package androidacademy.minsk.lecture3lists.data

import android.net.Uri

data class Actor(
    val name: String,
    val avatar: Uri,
    val hasOscar: Boolean
)