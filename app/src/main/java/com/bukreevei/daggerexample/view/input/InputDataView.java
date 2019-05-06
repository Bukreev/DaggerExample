package com.bukreevei.daggerexample.view.input;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bukreevei.daggerexample.MainActivity;
import com.bukreevei.daggerexample.R;
import com.bukreevei.daggerexample.viewmodel.DataViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class InputDataView extends LinearLayout {

    @Inject
    protected DataViewModel dataViewModel;

    @BindView(R.id.input_name)
    protected EditText inputName;

    @BindView(R.id.input_email)
    protected EditText inputEmail;

    @BindView(R.id.input_phone)
    protected EditText inputPhone;

    @BindView(R.id.button_next)
    protected Button buttonNext;

    public InputDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.view_input_data, this);
        ButterKnife.bind(this);
        buttonNext.setEnabled(false);
    }

    @OnTextChanged(R.id.input_name)
    protected void onNameChanged() {
        if (inputEmail.length() > 0 && inputPhone.length() > 0)
            buttonNext.setEnabled(true);
        dataViewModel.setName(inputName.getText().toString());
    }

    @OnTextChanged(R.id.input_email)
    protected void onEmailChanged() {
        if (inputName.length() > 0 && inputPhone.length() > 0)
            buttonNext.setEnabled(true);
        dataViewModel.setEmail(inputEmail.getText().toString());
    }

    @OnTextChanged(R.id.input_phone)
    protected void onPhoneChanged() {
        if (inputEmail.length() > 0 && inputName.length() > 0)
            buttonNext.setEnabled(true);
        dataViewModel.setPhone(inputPhone.getText().toString());
    }

    @OnClick(R.id.button_next)
    protected void onNextButtonClick() {
        final MainActivity mainActivity = ((MainActivity) getContext());
        mainActivity.getNavController().navigate(R.id.dataOutputFragment);
    }
}
