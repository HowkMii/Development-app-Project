package coj.example.pwdevapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {
    val dbName="stdPresence"
    val dbTable="student"
    val colstdID="stdID"
    val colFname="Fname"
    val colLname="Lname"
    val dbVersion=1
    val sqlCreateTable="Create table if not exist"+dbTable+"("+colstdID+"Integer primary key"+colFname+"text"+colLname+"text);"
    var sqlDB: SQLiteDatabase?=null
    constructor(context: Context){
        val db=DatabaseHelperStudent(context)
        sqlDB=db.writableDatabase
    }
    inner class DatabaseHelperStudent:SQLiteOpenHelper{
        var context: Context?=null

        constructor(context:Context):super(context,dbName,null,dbVersion){
            this.context=context

        }
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context,"database is created",Toast.LENGTH_SHORT).show()

        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        }

    }
}
