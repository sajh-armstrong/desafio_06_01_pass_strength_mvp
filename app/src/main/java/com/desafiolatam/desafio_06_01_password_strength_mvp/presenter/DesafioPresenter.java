package com.desafiolatam.desafio_06_01_password_strength_mvp.presenter;

import androidx.annotation.NonNull;

import com.desafiolatam.desafio_06_01_password_strength_mvp.model.IVerifier;
import com.desafiolatam.desafio_06_01_password_strength_mvp.model.Verifier;
import com.desafiolatam.desafio_06_01_password_strength_mvp.view.IDesafioPresenter;

public class DesafioPresenter implements IDesafioPresenter {

    private IDesafioView view;
    private IVerifier verifier;

    public DesafioPresenter(@NonNull IDesafioView view){
        this.view = view;
        verifier = new Verifier();
    }

    @Override
    public void setPass(String pass) {
        view.ShowPassStrength(verifier.sendPassStrength(pass));
    }
}
