package com.bukreevei.daggerexample.viewmodel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private final MutableLiveData<String> nameLiveData;
    private final MutableLiveData<String> emailLiveData;
    private final MutableLiveData<String> phoneLiveData;

    @Inject
    public DataViewModel() {
         this.nameLiveData = new MutableLiveData<>();
         this.emailLiveData = new MutableLiveData<>();
         this.phoneLiveData = new MutableLiveData<>();

    }

    public final void setName(final String data) {
        nameLiveData.postValue(data);
    }
    public final void setEmail(final String data) {
        emailLiveData.postValue(data);
    }
    public final void setPhone(final String data) {
        phoneLiveData.postValue(data);
    }

    public String getNameLiveData() {
        return nameLiveData.getValue();
    }

    public String getEmailLiveData() {
        return emailLiveData.getValue();
    }

    public String getPhoneLiveData() {
        return phoneLiveData.getValue();
    }
}
