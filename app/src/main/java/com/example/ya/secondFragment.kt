package com.example.ya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_second)

        var data =intent.extras
        var newuser=data?.getParcelable<user>("empData")
        serviceText.text = "บริการ : ${newuser?.service}"
        doctorText.text = "แพทย์ : ${newuser?.doctor}"
        dateText.text = "วันที่ : ${newuser?.date}"
        salaryText.text = "เวลา : ${newuser?.time}"
    }
    fun onClickClose(view: View){
        finish()
    }
}