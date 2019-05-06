package com.bukreevei.daggerexample.di;

import android.app.Application;

import com.bukreevei.daggerexample.MainActivity;
import com.bukreevei.daggerexample.di.module.DataViewModelModule;
import com.bukreevei.daggerexample.view.input.InputDataView;
import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = DataViewModelModule.class)
interface DataViewModelComponent {

    void inject(final InputDataView inputDataView);

//    void inject(final OutputDataView outputDataView);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application root);

        DataViewModel build();
    }
}
