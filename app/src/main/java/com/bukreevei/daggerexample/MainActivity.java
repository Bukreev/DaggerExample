package com.bukreevei.daggerexample;

import android.os.Bundle;

import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    protected DataViewModel dataViewModel;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        this.dataViewModel = ViewModelProviders.of(this, viewModelFactory).get(DataViewModel.class);

    }

    public DataViewModel getDataViewModel() {
        return dataViewModel;
    }

    public final NavController getNavController() {
        return navController;
    }
}
