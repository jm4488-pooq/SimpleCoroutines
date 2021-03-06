package com.example.simplecoroutines.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Entity::class], version = 1,exportSchema = false)
abstract class MyDatabase:RoomDatabase(){
    abstract val sampleDao: PracticeDao

    companion object{

        @Volatile
        var INSTANCE : MyDatabase?=null
        fun getInstance(context: Context):MyDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance==null){
                    instance = Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"sample-database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}