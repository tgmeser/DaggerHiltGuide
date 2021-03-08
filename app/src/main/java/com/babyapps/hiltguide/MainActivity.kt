package com.babyapps.hiltguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.babyapps.hiltguide.other.HiltGuideViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var firstArray: Array<String>
    //I used Array cuz of we can not use primitive types with lateinit modifier

    @Inject
    @Named("Arraylist_Type1")
    //Hilt can recognize by Named annotation comes from appmodule
    lateinit var arraylistString1: ArrayList<String>

    @Inject
    @Named("Arraylist_Type2")
    //Hilt can recognize by Named annotation comes from appmodule
    lateinit var arraylistString2: ArrayList<String>

    @Inject
    @Named("StringType1")
    lateinit var firstString: String

    @Inject
    @Named("StringType2")
    lateinit var connectedString: String

    private val hiltGuideViewModel: HiltGuideViewModel by viewModels()
    //viewmodels() comes from our dependency in gradle.app


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivityCheck", "String from DI : $firstString")
        Log.d("MainActivityCheck", "Array from DI : ${firstArray.first()}")

        Log.d("MainActivityCheck", "Arraylist string from DI : $arraylistString1")
        //We seperated providemethod's return types on Appmodule by Named annotation
        Log.d("MainActivityCheck", "Arraylist string from DI : $arraylistString2")

        Log.d("MainActivityCheck", "Connection ---> $connectedString  <---")


        hiltGuideViewModel //Check it out by HiltViewModel tag in Logcat

    }
}