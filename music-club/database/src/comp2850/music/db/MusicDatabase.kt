// Object representing the Music Club database

package comp2850.music.db

import org.jetbrains.exposed.v1.jdbc.Database

object MusicDatabase {
    const val URL = "jdbc:h2:./music"
    const val DRIVER = "org.h2.Driver"

    val db by lazy {
        Database.connect(URL, DRIVER)
    }
}
