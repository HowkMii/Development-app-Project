package coj.example.pwdevapp

class student {
    var stdID:Int?=null
    var Fname:String?=null
    var Lname:String?=null
    constructor(stdID:Int,Fname:String,Lname:String){
        this.stdID=stdID
        this.Fname=Fname
        this.Lname=Lname

    }
    open class Presence{
        var pID:Int?=null
        var stdID:Int?=null
        var prS:Boolean?=null
        var dateP:Long?=null
        constructor(pID:Int,stdID: Int,prS:Boolean,dateP:Long){
            this.pID=pID
            this.stdID=stdID
            this.prS=prS
            this.dateP=dateP

        }
        constructor(stdID: Int,prS:Boolean){
            this.stdID=stdID
            this.prS=prS
        }
    }
    class Evalataion:Presence {
        var noteE:Int?=null
        constructor(stdID: Int,prS:Boolean,noteE:Int) : super(stdID,prS){
            this.noteE=noteE

        }

    }
}