package com.bukreevei.daggerexample.view.input;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bukreevei.daggerexample.MainActivity;
import com.bukreevei.daggerexample.R;

import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class InputDataView extends LinearLayout {

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
        buttonNext.setEnabled(false);
    }

    @OnTextChanged(R.id.input_name)
    protected void onNameChanged() {
        if (inputEmail.length() > 0 && inputPhone.length() > 0)
            dataViewModel.setDataReady();
        buttonNext.setEnabled(true);
    }

    @OnTextChanged(R.id.input_email)
    protected void onEmailChanged() {
        if (inputName.length() > 0 && inputPhone.length() > 0)
            dataViewModel.setDataReady();
        buttonNext.setEnabled(true);
    }

    @OnTextChanged(R.id.input_phone)
    protected void onPhoneChanged() {
        if (inputEmail.length() > 0 && inputName.length() > 0)
            dataViewModel.setDataReady();
        buttonNext.setEnabled(true);
    }

    @OnClick(R.id.button_next)
    protected void onNextButtonClick() {
        final MainActivity mainActivity = ((MainActivity) getContext());
        mainActivity.getNavController().navigate();
    }
}
