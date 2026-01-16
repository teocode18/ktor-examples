// Artist entity, mapping onto Artists table

package comp2850.music.db

import org.jetbrains.exposed.v1.dao.UIntEntity
import org.jetbrains.exposed.v1.dao.UIntEntityClass
import org.jetbrains.exposed.v1.core.dao.id.EntityID

class Artist(id: EntityID<UInt>): UIntEntity(id) {
    companion object: UIntEntityClass<Artist>(ArtistTable)

    var name by ArtistTable.name
    var isSolo by ArtistTable.isSolo
    var info by ArtistTable.info
    val albums by Album referrersOn AlbumTable.artist

    val properName: String get() {
        // Converts "family-name, given-name" format of solo artist names
        // into the more familiar "given-name family-name" format
        if (isSolo) {
            val parts = name.split(",").map { it.trim() }
            return "${parts[1]} ${parts[0]}"
        }
        return name
    }

    override fun toString() = name
}
