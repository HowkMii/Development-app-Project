package coj.example.pwdevapp

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
    val sqlDB: SQLiteDatabase?=null
    constructor(){

    }
}
class DatabaseHelperStudent:SQLiteOpenHelper{
    var context: Context?=null
    va
    constructor(context:Context):super(context,dbName,null,dbVersion){
        this.context=context

    }
    override fun onCreate(p0: SQLiteDatabase?) {
       p0!!.execSQL(sqlCreateTable)
        Toast.makeText(this.context)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}