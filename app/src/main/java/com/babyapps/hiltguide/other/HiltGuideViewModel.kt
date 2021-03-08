package com.babyapps.hiltguide.other

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HiltGuideViewModel @Inject constructor(@Named("StringType1") strVm: String) : ViewModel() {

    init {
        Log.d("HiltViewModel", "Hilt ViewModel : $strVm")
    }
}