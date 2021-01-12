package com.minjee.stretchingapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minjee.stretchingapp.model.ListData
import com.minjee.stretchingapp.model.StretchMove

/*
 *      MainViewModel
 *      - viewModel that updates the MainFragment (the visible UI)
 *      - gets the data from model
 */
class MainViewModel: ViewModel() {

    private val listData = ListData(ArrayList<StretchMove>())
    val uiTextLiveData = MutableLiveData<String>()

    fun getUpdatedText() {
        val updatedText = "updated text"
        uiTextLiveData.postValue(updatedText)
    }

    fun initializeListOfMoves() {
        val move1 = StretchMove("Splits",
                            "Tuo jalkapohjat yhteen ja laske polvia kohti maata")
        val move2 = StretchMove("pohkeiden venytys",
                             "mene syvään kyykkyyn ja pidä kantapohjat maassa")
        val move3 = StretchMove("hartioiden venytys",
                             "pyöritä käsiä kumpaankin suuntaan")

        listData.listOfMoves.add(move1)
        listData.listOfMoves.add(move2)
        listData.listOfMoves.add(move3)

        for(move in listData.listOfMoves) {
            System.out.println("move: " + move.nameOfTheMove + ", decription: " + move.descriptionOfTheMove)
        }

        // TODO: next add recyclerview and populate it withlist items
    }
}