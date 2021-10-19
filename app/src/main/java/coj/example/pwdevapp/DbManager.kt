package coj.example.pwdevapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {

    val dbName="stdPresence"
    val dbTable="Student"
    val dbTableE="Evaluation"
    val dbTableP="Presance"
    val colstdID="stdID"
    val colFname="Fname"
    val colLname="Lname"
    var colMajor="Major"
    var colBirth="Birth"
    val colID="ID"
    val colprS="prS"
    val coldateP="dateP"
    val colnoteE="noteE"
    var dbVersion=1
    val sqlCreateTable="CREATE TABLE "+dbTable+"  ("+colstdID+" INTEGER PRIMARY KEY , "+
            colFname+" TEXT ,"+colLname+" TEXT ,"+colMajor+" TEXT ,"+colBirth+" DATE );"
    val sqlCreateTableP="CREATE TABLE "+dbTableP+"  ("+colID+" INTEGER PRIMARY KEY , "+
            colprS+" BOOLEAN ,"+colstdID+" INTEGER , "+
            coldateP+" DATE , FOREIGN KEY("+colstdID+") REFERENCES "+dbTable+"("+colstdID+"));"
    val sqlCreateTableE="CREATE TABLE "+dbTableE+"   ( "+colstdID+" INTEGER  ,"+
            colnoteE+" INTEGER,  FOREIGN KEY("+
            colstdID+") REFERENCES "+dbTable+"("+colstdID+"));"

    var sqlDB: SQLiteDatabase? = null
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

