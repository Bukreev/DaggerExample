package com.bukreevei.daggerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    public final NavController getNavController() {
        return navController;
    }
}
