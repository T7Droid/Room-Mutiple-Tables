package com.thyagoneves.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.thyagoneves.roomdatabasewithmultipletables.entities.Director
import com.thyagoneves.roomdatabasewithmultipletables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)