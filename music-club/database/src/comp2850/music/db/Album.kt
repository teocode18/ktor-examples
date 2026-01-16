// Album entity, mapping onto Albums table

package comp2850.music.db

import org.jetbrains.exposed.v1.dao.UIntEntity
import org.jetbrains.exposed.v1.dao.UIntEntityClass
import org.jetbrains.exposed.v1.core.dao.id.EntityID

class Album(id: EntityID<UInt>): UIntEntity(id) {
    companion object: UIntEntityClass<Album>(AlbumTable)

    var artist by Artist referencedOn AlbumTable.artist
    var title by AlbumTable.title
    var year by AlbumTable.year
    var youtube by AlbumTable.youtube

    override fun toString() = title
}
