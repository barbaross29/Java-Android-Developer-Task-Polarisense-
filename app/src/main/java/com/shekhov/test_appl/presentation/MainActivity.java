package com.shekhov.test_appl.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
//import com.shekhov.test_appl.Core.DI.DaggerMainActivityComponent;
import com.shekhov.test_appl.Core.DI.AppComponent;
//import com.shekhov.test_appl.Core.DI.DaggerMainActivityComponent;
import com.shekhov.test_appl.Core.DI.MainActivityComponent;
import com.shekhov.test_appl.R;
import com.shekhov.test_appl.domain.models.Quote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static AppComponent appComponent;
    private NavController navController;
    private MainActivityComponent mainActivityComponent;
    private AppLocalDatabase appLocalDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startHomeActivity();
    }
    private void startHomeActivity()
    {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                    if(checkUser()) navController.navigate(R.id.finishFragment);
                    startActivity(intent);
                }
            }, 2000);
    }
}