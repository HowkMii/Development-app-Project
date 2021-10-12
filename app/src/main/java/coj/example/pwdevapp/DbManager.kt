package coj.example.pwdevapp

import android.database.sqlite.SQLiteDatabase

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