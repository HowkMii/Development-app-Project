    package coj.example.pwdevapp

    import java.util.*

    open class Student {
    var stdID:Int?=null
    var Fname:String?=null
    var Lname:String?=null
    var Major:String?=null
    var Birth:Date?=null


    constructor(stdID:Int,Fname:String,Lname:String,Major:String,Birth:Date){
        this.stdID=stdID
        this.Fname=Fname
        this.Lname=Lname
        this.Major=Major
        this.Birth=Birth
    }
    constructor(stdID:Int){
        this.stdID = stdID
    }
}