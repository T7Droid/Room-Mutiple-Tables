package com.thyagoneves.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.thyagoneves.roomdatabasewithmultipletables.entities.School
import com.thyagoneves.roomdatabasewithmultipletables.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
            @Relation(
                parentColumn = "schoolName",
                entityColumn = "schoolName"
            )
            val student: List<Student>
)