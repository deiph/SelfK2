package com.example.selfk2.database

import android.app.Application

class App:Application() {

    companion object{
        private var db:AppDatabase?=null
        fun getDb():AppDatabase{
            return db!!
        }
    }

    override fun onCreate(){
        super.onCreate()

        db= AppDatabase.getDB(applicationContext)

    }

}