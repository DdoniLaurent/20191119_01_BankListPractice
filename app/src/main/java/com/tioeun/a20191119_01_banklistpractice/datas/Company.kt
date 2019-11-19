package com.tioeun.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class Company {

    var id = 0
    var name = ""
    var logo = ""

    companion object {
        fun getBankFromJsonObject(json: JSONObject) : Company {
            var company = Company()
            company.id = json.getInt("id")
            company.name = json.getString("name")
            company.logo = json.getString("logo")
            return company

        }
    }
}