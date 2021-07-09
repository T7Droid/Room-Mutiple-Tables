package com.thyagoneves.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.thyagoneves.roomdatabasewithmultipletables.entities.Student
import com.thyagoneves.roomdatabasewithmultipletables.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentsSubjectCrossRef::class)
    )
    val student: List<Student>
)
