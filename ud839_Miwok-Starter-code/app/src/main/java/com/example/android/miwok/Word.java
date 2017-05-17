package com.example.android.miwok;

/**
 * Created by bruno on 17/05/2017.
 */

public class Word {

    //String with m because private
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    //constructor
    public Word(String defaultTranslation, String miwokTranslation ){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }


    //methods

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }


}
