package com.bukreevei.daggerexample.di.module;

import com.bukreevei.daggerexample.di.ViewModelKey;
import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DataViewModel.class)
    abstract ViewModel bindUserViewModel(DataViewModel userViewModel);
}
