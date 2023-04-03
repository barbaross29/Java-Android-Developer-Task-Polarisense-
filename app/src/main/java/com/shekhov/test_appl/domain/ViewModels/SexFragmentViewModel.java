package com.shekhov.test_appl.domain.ViewModels;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

public class SexFragmentViewModel extends ViewModel {

    //some LiveData, in this app not needed, because we dont observe changing of DB tables

    public void setSharedPreference(Context context, String key, Boolean value)
    {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        prefs.edit().putBoolean(key, value).commit();
    }
}
