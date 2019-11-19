package com.tioeun.a20191119_01_banklistpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tioeun.a20191119_01_banklistpractice.R
import com.tioeun.a20191119_01_banklistpractice.datas.Company
import java.util.ArrayList

class CompanyAdapter(context: Context, res:Int, list:ArrayList<Company>) : ArrayAdapter<Company>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list:ArrayList<Company>) : this(context, R.layout.delivery_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.delivery_list_item, null)
        }

        var row = tempRow!!

        var logoImg = row.findViewById<ImageView>(R.id.logoImg)
        var deliveryCompanyListTxt = row.findViewById<TextView>(R.id.deliveryCompanyListTxt)

        var data = mList.get(position)

        deliveryCompanyListTxt.text = data.name

        Glide.with(mContext).load(mList[position].logo).into(logoImg)


        return row
    }
}