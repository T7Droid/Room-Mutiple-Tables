package com.thyagoneves.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.thyagoneves.roomdatabasewithmultipletables.entities.Student
import com.thyagoneves.roomdatabasewithmultipletables.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentsSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)