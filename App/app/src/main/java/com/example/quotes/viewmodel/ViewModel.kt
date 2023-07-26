package com.example.quotes.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.model.ApiRequest
import com.example.quotes.model.Student
import com.example.quotes.repo.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val network: Network
) : ViewModel() {
    var text_a = mutableStateOf("")
    var text_b = mutableStateOf("")
    var id = mutableStateOf("")

    fun push() {
        CoroutineScope(Dispatchers.IO).launch {
            network.insertOne(
                ApiRequest(
                    student = Student(
                        id = id.value,
                        name = text_a.value,
                        age = text_b.value.toInt()
                    )
                )
            )
        }
    }

    fun update() {
        viewModelScope.launch(Dispatchers.IO) {
            network.updateOne(
                apiRequest = ApiRequest(
                    student = Student(
                        id = id.value,
                        name = text_a.value,
                        age = text_b.value.toInt()
                    )
                )
            )
        }
    }


    fun delete() {
        viewModelScope.launch(Dispatchers.IO) {
            network.deleteOne(
                apiRequest = ApiRequest(
                    id = id.value
                )
            )
        }
    }
}