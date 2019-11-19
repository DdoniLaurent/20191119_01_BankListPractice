package com.tioeun.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class Bank {

    var id = 0
    var code = ""
    var name = ""
    var logo = ""

    companion object {
         fun getBankFromJsonObject(json:JSONObject) : Bank {
             val bank = Bank()
//             파싱 코드들 작성
             bank.id = json.getInt("id")
             bank.code = json.getString("code")
             bank.name = json.getString("name")
             bank.logo = json.getString("logo")
             return bank
         }
    }
}