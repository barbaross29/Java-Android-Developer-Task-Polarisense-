package com.shekhov.test_appl.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.Core.DI.RegisterActivityVMComponent;
import com.shekhov.test_appl.R;
import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.ViewModels.RegActivityViewModel;
import com.shekhov.test_appl.domain.models.Quote;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    public static AppComponent appComponent;
    public static RegisterActivityVMComponent homeActivityComponent;
    private Model model;
    public static NavController navController;
    private RegActivityViewModel regActivityViewModel;
    private AppLocalDatabase appLocalDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appLocalDatabase = AppLocalDatabase.getINSTANCE(getApplicationContext());
        navController = Navigation.findNavController(this, R.id.main_activity_nav_host_fragment);
        regActivityViewModel = new ViewModelProvider(this).get(RegActivityViewModel.class);

        //TODO: if you want to delete registered user from database to see all setting data fragments, uncomment line:
        //regActivityViewModel.deleteCurrentUser();

        regActivityViewModel.insertQuotes();
        if(regActivityViewModel.getUser() != null) navController.navigate(R.id.finishFragment);
    }

}