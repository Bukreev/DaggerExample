package com.bukreevei.daggerexample.di.module;

import android.arch.lifecycle.ViewModelProviders;
import com.bukreevei.daggerexample.MainActivity;
import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataViewModelModule {

    @Provides
    @Singleton
    public DataViewModel provideViewModel(final MainActivity host) {
        return ViewModelProviders.of(host).get(DataViewModel.class);
    }
}
