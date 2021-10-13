package coj.example.pwdevapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {
    val dbName="stdPresence"
    val dbTable="student"
    val dbTableE="evaluation"
    val dbTableP="presance"
    val colstdID="stdID"
    val colFname="Fname"
    val colLname="Lname"
    val colID="ID"
    val colprS="prS"
    val coldateP="dateP"
    val colnoteE="noteE"
    val dbVersion=1
    val sqlCreateTable="CREATE TABLE IF NOT EXISTS "+dbTable+"("+colstdID+" INTEGER PRIMARY KEY ,"+colFname+" TEXT ,"+colLname+" TEXT );"
    val sqlCreateTableP="CREATE TABLE IF NOT EXISTS "+dbTableP+"("+colID+" INTEGER PRIMARY KEY ,"+colprS+" INTEGER ,"+colstdID+" INTEGER FOREIGN KEY ,"+coldateP+" Integer );"
    val sqlCreateTableE="CREATE TABLE IF NOT EXISTS "+dbTableP+"("+colID+" INTEGER FOREIGN KEY ,"+colstdID+" INTEGER FOREIGN KEY ,"+colnoteE+" INTEGER );"

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
            Toast.makeText(this.context,"database is created sqlCreateTableE",Toast.LENGTH_SHORT).show()
            p0!!.execSQL(sqlCreateTableP)
            Toast.makeText(this.context,"database is created sqlCreateTableP",Toast.LENGTH_SHORT).show()
            p0!!.execSQL(sqlCreateTableE)
            Toast.makeText(this.context,"database is created sqlCreateTableE",Toast.LENGTH_SHORT).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        }

    }
}
