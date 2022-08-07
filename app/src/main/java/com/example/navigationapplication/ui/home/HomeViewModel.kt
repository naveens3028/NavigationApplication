package com.example.navigationapplication.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationapplication.network.KtorModuleClass
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val listData = MutableLiveData<List<String>>()

    init {
        viewModelScope.launch {
           val a =  fetchAllMovies("viewModel")
            val b = async { }
            val c = launch { }
        }
    }

    fun getData() {

        val data = ArrayList<String>()
        data.apply {
            this.add("naveen0")
            this.add("naveen1")
            this.add("naveen2")
            this.add("naveen3")
            this.add("naveen4")
            this.add("naveen5")
            this.add("naveen6")
            this.add("naveen7")
            this.add("naveen8")
            this.add("naveen9")
            this.add("naveen10")
        }

        listData.value = data
    }

    @KtorExperimentalAPI
    suspend fun fetchAllMovies(callFrom: String)  {
        try {
            Log.e(callFrom, KtorModuleClass.client.get {
                url(KtorModuleClass.BASE_URL +"movielist.json")
            })
        } catch (e : java.lang.Exception) {
            Log.e(callFrom,e.toString())
        }
    }


}