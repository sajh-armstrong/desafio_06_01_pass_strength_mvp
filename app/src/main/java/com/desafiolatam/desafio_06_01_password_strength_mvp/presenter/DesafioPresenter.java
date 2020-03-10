package com.desafiolatam.desafio_06_01_password_strength_mvp.presenter;

import androidx.annotation.NonNull;

import com.desafiolatam.desafio_06_01_password_strength_mvp.view.IDesafioPresenter;

public class DesafioPresenter implements IDesafioPresenter {

    private IDesafioView view;

    public DesafioPresenter(@NonNull IDesafioView view){
        this.view = view;
    }

    @Override
    public void setPass(String pass) {

    }
}
