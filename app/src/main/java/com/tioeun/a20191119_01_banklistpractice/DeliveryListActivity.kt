package com.tioeun.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tioeun.a20191119_01_banklistpractice.adapters.CompanyAdapter
import com.tioeun.a20191119_01_banklistpractice.datas.Bank
import com.tioeun.a20191119_01_banklistpractice.datas.Company
import com.tioeun.a20191119_01_banklistpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_delivery_list.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.util.ArrayList

class DeliveryListActivity : BaseAcitivity() {

    var companyList = ArrayList<Company>()
    var companyAdapter:CompanyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_list)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        companyAdapter = CompanyAdapter(mContext, companyList)
        deliveryCompanyListView.adapter = companyAdapter

        getCompanyFromServer()
    }

    fun getCompanyFromServer() {
        ServerUtil.getRequestCompanyList(mContext, object : ServerUtil.JonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("응답확인", json.toString())
                val code = json.getInt("code")

                if(code == 200) {
                    val data = json.getJSONObject("data")
                    val company = data.getJSONArray("company")

                    for (i in 0..company.length()-1) {
                        val companyJsonObject = company.getJSONObject(i)
                        val companyData = Company.getBankFromJsonObject(companyJsonObject)
                        companyList.add(companyData)
                    }
                    runOnUiThread {
                        companyAdapter?.notifyDataSetChanged()
                    }

                } else {
                    Toast.makeText(mContext, "서버 통신에 문제가 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }



}
