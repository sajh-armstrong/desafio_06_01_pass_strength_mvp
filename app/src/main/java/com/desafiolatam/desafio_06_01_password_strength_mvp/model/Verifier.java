package com.desafiolatam.desafio_06_01_password_strength_mvp.model;

public class Verifier implements IVerifier{

    public static final int PASS_STRENGTH_WEAK = 0;
    public static final int PASS_STRENGTH_MEDIUM = 1;
    public static final int PASS_STRENGTH_STRONG = 2;
    public static final int PASS_STRENGTH_VERY_STRONG = 3;

    public static final int PASS_MIN_LENGTH = 5;

    public boolean checkPassLength(String pass){
        return pass.length() >= PASS_MIN_LENGTH;
    }

    public boolean checkPassHasUppercase(String pass) {
        boolean check = false;
        char[] charArray = pass.toCharArray();

        for(char temp : charArray){
            if(Character.isUpperCase(temp)){
                check = true;
                break;
            }
        }

        return check;
    }

    public boolean checkPassHasDigit(String pass){
        boolean check = false;
        char[] charArray = pass.toCharArray();

        for(char temp : charArray){
            if(Character.isDigit(temp)){
                check = true;
                break;
            }
        }

        return check;
    }

    public int checkPassStrength(String pass){
        if(!checkPassLength(pass))
            return PASS_STRENGTH_WEAK;
        else if(!checkPassHasUppercase(pass))
            return  PASS_STRENGTH_MEDIUM;
        else if(!checkPassHasDigit(pass))
            return PASS_STRENGTH_STRONG;
        else
            return PASS_STRENGTH_VERY_STRONG;
    }

    @Override
    public int sendPassStrength(String pass) {
        return checkPassStrength(pass);
    }
}
