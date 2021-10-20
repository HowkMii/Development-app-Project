package coj.example.pwdevapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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
         fun insertUser(stdId :String, Fname:String,
            Lname:String,Major:String,Birth:String): Boolean {
            // Gets the data repository in write mode
            val db = writableDatabase

            // Create a new map of values, where column names are the keys
            val values = ContentValues()
            values.put(colstdID, stdId)
            values.put(colFname, Fname)
            values.put(colLname, Lname)
            values.put(colMajor, Major)
            values.put(colBirth, Birth)

            // Insert the new row, returning the primary key value of the new row
            val newRowId = db.insert(dbTable, null, values)
            return true
        }

         fun checkUser(v:String):Boolean {
             val db = writableDatabase
             val c: Cursor =db.rawQuery("SELECT * FROM " + dbTable + " WHERE " + colstdID + " =  ?", arrayOf(v));
             return c.count > 0;
         }



         fun updateUser(stdId :String, Fname:String,
                        Lname:String,Major:String,Birth:String): Boolean {
             // Gets the data repository in write mode
             val db = writableDatabase

             // Create a new map of values, where column names are the keys
             val values = ContentValues()
             values.put(colstdID, stdId)
             values.put(colFname, Fname)
             values.put(colLname, Lname)
             values.put(colMajor, Major)
             values.put(colBirth, Birth)

             // Insert the new row, returning the primary key value of the new row
             val newRowId = db.update(dbTable, values,
             colstdID + " = ?", arrayOf(stdId))
             return newRowId != -1
         }


    }
}

