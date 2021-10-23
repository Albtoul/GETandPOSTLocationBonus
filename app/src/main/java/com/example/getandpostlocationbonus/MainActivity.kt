package com.example.getandpostlocationbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){
    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var ed3:EditText
    lateinit var tv:TextView
    lateinit var bt1:Button
    lateinit var bt2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed1=findViewById(R.id.editTextTextPersonName)
        ed2=findViewById(R.id.editTextTextPersonName2)
        ed3=findViewById(R.id.editTextTextPersonName3)
        tv=findViewById(R.id.textView)
        bt1=findViewById(R.id.button)
        bt2=findViewById(R.id.button2)


        bt1.setOnClickListener { addUserdetails() }

        bt2.setOnClickListener {  GetuserDetails() }





    }


    fun GetuserDetails(){

        val apiInterface = APIClient().getClient()?.create(APIinterface::class.java)//call api to fetch data

        apiInterface!!.getUser()?.enqueue(object : Callback<PersonDetails?> {
            override fun onResponse(
                call: Call<PersonDetails?>,
                response: Response<PersonDetails?>
            ) {

               for(index in response.body()!!){

                   if(ed3.text.toString()==index.name){
                       tv.text="${index.location}"

                   }
               }
            }

            override fun onFailure(call: Call<PersonDetails?>, t: Throwable) {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()

            }
        })

    }


    fun addUserdetails(){

        val apiInterface = APIClient().getClient()?.create(APIinterface::class.java)
        if(apiInterface!=null){

            apiInterface.addUser(PersonDetails.PersonDetailsItem(ed1.text.toString(),ed2.text.toString(),1)).enqueue(object : Callback<PersonDetails.PersonDetailsItem?> {
                override fun onResponse(
                    call: Call<PersonDetails.PersonDetailsItem?>,
                    response: Response<PersonDetails.PersonDetailsItem?>
                ) {
                    Toast.makeText(applicationContext, "add", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PersonDetails.PersonDetailsItem?>, t: Throwable) {
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                }
            } )

        }
    }










}