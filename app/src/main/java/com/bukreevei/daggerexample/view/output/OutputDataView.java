package com.bukreevei.daggerexample.view.output;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bukreevei.daggerexample.MainActivity;
import com.bukreevei.daggerexample.R;
import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OutputDataView extends LinearLayout {

    private final DataViewModel dataViewModel;

    @BindView(R.id.output_name)
    protected TextView outputName;

    @BindView(R.id.output_email)
    protected TextView outputEmail;

    @BindView(R.id.output_phone)
    protected TextView outputPhone;

    public OutputDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.view_output_data, this);
        ButterKnife.bind(this);
        final MainActivity activity = (MainActivity) getContext();
        this.dataViewModel = activity.getDataViewModel();
        setName();
        setEmail();
        setPhone();
    }

    private void setName() {
        if (dataViewModel != null && dataViewModel.getNameLiveData() != null) {
            outputName.setText(dataViewModel.getNameLiveData());
        }
    }

    private void setEmail() {
        if (dataViewModel != null && dataViewModel.getEmailLiveData() != null) {
            outputEmail.setText(dataViewModel.getEmailLiveData());
        }
    }

    private void setPhone() {
        if (dataViewModel != null && dataViewModel.getPhoneLiveData() != null) {
            outputPhone.setText(dataViewModel.getPhoneLiveData());
        }
    }
}
