package com.thyagoneves.roomdatabasewithmultipletables

import androidx.room.*
import com.thyagoneves.roomdatabasewithmultipletables.entities.Director
import com.thyagoneves.roomdatabasewithmultipletables.entities.School
import com.thyagoneves.roomdatabasewithmultipletables.entities.Student
import com.thyagoneves.roomdatabasewithmultipletables.entities.Subject
import com.thyagoneves.roomdatabasewithmultipletables.entities.relations.SchoolAndDirector
import com.thyagoneves.roomdatabasewithmultipletables.entities.relations.SchoolWithStudents
import com.thyagoneves.roomdatabasewithmultipletables.entities.relations.StudentWithSubjects
import com.thyagoneves.roomdatabasewithmultipletables.entities.relations.StudentsSubjectCrossRef

@Entity
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubsjectCrossRef(crossRef: StudentsSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>

}