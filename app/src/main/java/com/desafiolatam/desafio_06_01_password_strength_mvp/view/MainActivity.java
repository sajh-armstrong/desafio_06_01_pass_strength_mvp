package com.desafiolatam.desafio_06_01_password_strength_mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.desafiolatam.desafio_06_01_password_strength_mvp.R;
import com.desafiolatam.desafio_06_01_password_strength_mvp.presenter.IDesafioView;

public class MainActivity extends AppCompatActivity implements IDesafioView {

    EditText editText_Password;
    TextView textView_PassStrength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_PassStrength = findViewById(R.id.textView_PassStrength);

        editText_Password = findViewById(R.id.editText_Password);
        editText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void ShowPassStrength(int passStrength) {
        switch (passStrength) {
            case 0:
                textView_PassStrength.setText(R.string.pass_strength_weak);
                textView_PassStrength.setBackgroundColor(getColor(R.color.colorPassStrengthWeak));
                break;
            case 1:
                textView_PassStrength.setText(R.string.pass_strength_medium);
                textView_PassStrength.setBackgroundColor(getColor(R.color.colorPassStrengthWeak));
                break;
            case 2:
                textView_PassStrength.setText(R.string.pass_strength_strong);
                textView_PassStrength.setBackgroundColor(getColor(R.color.colorPassStrengthWeak));
                break;
                //TODO VERY STRONG PASS
        }

    }
}
