package uz.codemaster.fragmentmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val messageToActivity: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val messageToFrag1: MutableLiveData<String> by lazy{

        MutableLiveData<String>()
    }

    val messageToFrag2: MutableLiveData<String> by lazy {

        MutableLiveData<String>()
    }



}