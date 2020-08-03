package com.sippitechnologies.gsonexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Convert Data Class Object into jsonString
        val person = Person("Test","lastNameofTest",20)
        val personjson= Gson().toJson(person)

        Log.d("Object to Json",personjson)
        val person2 = Gson().fromJson<Person>(personjson,Person::class.java)
        Log.d("Json to Object",person2.firstName)

        //Nested Object conversion from json to object and vise -versa
        val address = Address("105 Main Street","Delhi","Delhi","India")
        val college = College("MT College",address)

        val collegejsonString = Gson().toJson(college)
        Log.d("Nested Object to json",collegejsonString)
        val college2 = Gson().fromJson<College>(collegejsonString,College::class.java)

        Log.d("json to Nested Object",college2.name)

        
        //Convert List of object to jsonString and vice versa
        val persons = listOf<Person>(person,person,person,person)
        val typeToken = object:TypeToken<List<Person>>(){}.type
        val personlistjson = Gson().toJson(persons)
        Log.d("List of Object to json",personlistjson)
        val convertedlistfromjson = Gson().fromJson<List<Person>>(personlistjson,typeToken)
        Log.d("json to List of Object",convertedlistfromjson.size.toString())

        //Convert Map to json and vice verso
        //Convert List of object to jsonString and vice versa

        val typeTokenforMap = object:TypeToken<Map<String,Any>>(){}.type
        val mapjsonofcollege = Gson().toJson(college)
        Log.d("Object to json",mapjsonofcollege)
        val collegeMap = Gson().fromJson<Map<String,Any>>(mapjsonofcollege,typeTokenforMap)
        Log.d("json to Map",collegeMap.size.toString())







        

    }
}