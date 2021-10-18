package coj.example.pwdevapp

import java.util.*

open class Presence{
    var pID:Int?=null
    var stdID:Int?=null
    var prS:Boolean?=null
    var dateP:Date?=null
    constructor(pID:Int,stdID: Int,prS:Boolean,dateP:Date){
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