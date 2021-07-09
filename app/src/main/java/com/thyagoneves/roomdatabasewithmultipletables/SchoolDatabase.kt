package com.thyagoneves.roomdatabasewithmultipletables

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thyagoneves.roomdatabasewithmultipletables.entities.Director
import com.thyagoneves.roomdatabasewithmultipletables.entities.School
import com.thyagoneves.roomdatabasewithmultipletables.entities.Student
import com.thyagoneves.roomdatabasewithmultipletables.entities.Subject
import com.thyagoneves.roomdatabasewithmultipletables.entities.relations.StudentsSubjectCrossRef

@Database(
    entities = [
        School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentsSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase(){

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}