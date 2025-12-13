// Functions to handle connecting to the Music Club database

package comp2850.music.db

import org.jetbrains.exposed.sql.Database

const val DATABASE_URL = "jdbc:sqlite:file:music.db"

fun connectToDatabase() {
    Database.connect(DATABASE_URL)
}
