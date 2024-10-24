package ktor.jwt.io.core.base

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import kotlin.reflect.KClass

abstract class BaseIdTable<T: Comparable<T>>(tableName: String, pkName: String = "id", idType: KClass<T> ) : IdTable<T>(tableName) {

    final override val id: Column<EntityID<T>> = when (idType) {
        Long::class -> long(pkName).autoIncrement().entityId() as Column<EntityID<T>>
        String::class -> varchar(pkName, 50).entityId() as Column<EntityID<T>>
        else -> throw IllegalArgumentException("지원하지 않는 형식의 idType 입니다")
    }


    override val primaryKey = PrimaryKey(id)

//    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now(); }
//    val updatedAt = datetime("updated_at").clientDefault { LocalDateTime.now(); }
}

abstract class BaseEntity<T: Comparable<T>> (id: EntityID<T>, table: BaseIdTable<T>) : Entity<T>(id){
//    val createdAt by table.createdAt
//    var updatedAt by table.updatedAt
}

abstract class BaseEntityClass<E : BaseEntity<T>, T: Comparable<T>>(table: BaseIdTable<T>) : EntityClass<T,E>(table) {

    init {
        EntityHook.subscribe { action ->
            if (action.changeType == EntityChangeType.Updated) {
                try {
//                    action.toEntity(this)?.updatedAt = LocalDateTime.now()
                } catch (e: Exception) {
                    exposedLogger.warn("업데이트 실패 $this updatedAt", e.message)
                }
            }
        }
    }
}