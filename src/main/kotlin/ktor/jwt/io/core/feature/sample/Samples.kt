package ktor.jwt.io.core.feature.sample

import ktor.jwt.io.core.base.BaseEntity
import ktor.jwt.io.core.base.BaseEntityClass
import ktor.jwt.io.core.base.BaseIdTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.*

// 테이블 명세는 복수
object Samples : BaseIdTable<Long>("users", idType = Long::class) {
    val name = varchar("name", 255)
    val age = integer("age")
}


// 엔티티는 단수
class Sample(id: EntityID<Long>) : BaseEntity<Long>(id, Samples){
    companion object: BaseEntityClass<Sample, Long>(Samples)
    var name by Samples.name
    var age by Samples.age
}