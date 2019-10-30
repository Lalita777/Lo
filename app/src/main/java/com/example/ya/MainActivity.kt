package com.example.ya

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val subjectSpinner: Spinner = spinner_subject;
        val subjectArray = resources.getStringArray(R.array.subjectName_array)


        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner.adapter = arrayAdapter

        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                var subject = subjectArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        fun onClickShowDetail(v: View){

            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("empData",user(spinner_subject.toString(),spinner_subject1.toString(),text_date.text.toString()
                ,text_time.text.toString().toInt()))
            startActivity(intent)
        }
        fun showTimePickerDialog(v: View){
            val newTimeFragment = TimePickerFrament()
            newTimeFragment.show(supportFragmentManager, "Time Picker")

        }




        btn_date.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    text_date.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
        }



    }

    fun reset(v: View){
        spinner_subject.setSelection(0)
        spinner_subject1.setSelection(0)
        text_date.text = "dd / mm / yyyy"
        text_time.text="_ _ : _ _"
    }
}
