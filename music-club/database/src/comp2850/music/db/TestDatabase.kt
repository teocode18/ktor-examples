// Object representing a small in-memory test database

package comp2850.music.db

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object TestDatabase {
    const val URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"
    const val DRIVER = "org.h2.Driver"

    val db by lazy {
        Database.connect(URL, DRIVER)
    }

    fun create() {
        transaction(db) {
            SchemaUtils.drop(ArtistTable, AlbumTable)
            SchemaUtils.create(ArtistTable, AlbumTable)

            val artist1 = ArtistTable.insert {
                it[name] = "A Band"
            } get ArtistTable.id

            val artist2 = ArtistTable.insert {
                it[name] = "Doe, John"
                it[isSolo] = true
            } get ArtistTable.id

            AlbumTable.insert {
                it[title] = "An Album"
                it[artist] = artist1
                it[year] = 2025
            }

            AlbumTable.insert {
                it[title] = "First Album"
                it[artist] = artist2
                it[year] = 2019
            }

            AlbumTable.insert {
                it[title] = "Second Album"
                it[artist] = artist2
                it[year] = 2023
            }
        }
    }
}
