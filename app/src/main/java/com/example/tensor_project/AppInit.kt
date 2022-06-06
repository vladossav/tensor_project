package com.example.tensor_project

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.tensor_project.api.RandomWordApi
import com.example.tensor_project.room.AppDatabase
import com.example.tensor_project.room.WordRepository


const val RANDOM_WORD = "RANDOM_WORD"
const val RANDOM_WORD_VALUE = "wordFromApi"
const val RANDOM_WORD_DEF = "defOfWordFromApi"

class AppInit: Application() {
    private val api = RandomWordApi.create()
    private val database by lazy {
        AppDatabase.getInstance(this)
    }
    val repository by lazy { WordRepository(database.getWordDao(), database.getRecentDao()) }
    val sharedPref: SharedPreferences by lazy { getSharedPreferences(RANDOM_WORD, Context.MODE_PRIVATE)}
   /* override fun onCreate() {
        super.onCreate()
        connectRandomWordApi()

    }

    fun connectRandomWordApi() {
        api.getWord().enqueue( object : Callback<List<RandomWord>> {
            override fun onResponse(call: Call<List<RandomWord>>?, response: Response<List<RandomWord>>?) {
                Log.d("Api",response.toString())

                if(response?.body() != null) {
                    val res = response.body()
                    val word: RandomWord = res!!.first()

                    sharedPref.edit()
                        .putString(RANDOM_WORD_VALUE, word.word)
                        .putString(RANDOM_WORD_DEF, word.definition)
                        .apply()

                    Log.d("Api",sharedPref.getString(RANDOM_WORD_VALUE,"nothing").toString())
                    Log.d("Api",sharedPref.getString(RANDOM_WORD_DEF,"nothing").toString())
                }
            }

            override fun onFailure(call: Call<List<RandomWord>>?, t: Throwable?) {
                Log.i("Api","some error: " + t?.message)
            }
        })
    }*/
}