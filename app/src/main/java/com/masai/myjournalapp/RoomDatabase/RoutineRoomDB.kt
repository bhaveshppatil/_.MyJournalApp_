package com.masai.myjournalapp.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.masai.myjournalapp.Model.RoutineModel
import com.masai.myjournalapp.Model.UserModel

@Database(entities = [RoutineModel::class, UserModel::class], version = 4)
abstract class RoutineRoomDB : RoomDatabase() {

    abstract fun getRoutineDAO(): RoutineDAO

    companion object {
        private var INSTANCE: RoutineRoomDB? = null

        fun getDatabaseObject(context: Context): RoutineRoomDB {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext, RoutineRoomDB::class.java, "routine.db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
            }
            return INSTANCE!!
        }
    }
}