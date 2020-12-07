package com.example.drivererte;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.drivererte.model.loginSopir.LoginSopirData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USERS = "id_users";
    public static final String EMAIL = "email";
    public static final String NAMA = "nama";

    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginSopirData sopir){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_USERS, sopir.getIdUsers());
        editor.putString(EMAIL, sopir.getEmail());
        editor.putString(NAMA, sopir.getNama());
        editor.commit();
    }

//    public HashMap<String,String> getSopirDetail(){
//        HashMap<String,String> sopir = new HashMap<>();
//        sopir.put(ID_USERS, sharedPreferences.getString(ID_USERS, null));
//        sopir.put(EMAIL, sharedPreferences.getString(EMAIL, null));
//        sopir.put(NAMA, sharedPreferences.getString(NAMA, null));
//        return sopir;
//    }

    public HashMap<String,String> getSopirDetail(){
        HashMap<String,String> sopir = new HashMap<>();
        sopir.put(ID_USERS, sharedPreferences.getString(ID_USERS, null));
        sopir.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        sopir.put(NAMA, sharedPreferences.getString(NAMA, null));
//        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
//        user.put(KONTAK, sharedPreferences.getString(KONTAK, null));
////        user.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN, null));
//        user.put(ALAMAT, sharedPreferences.getString(ALAMAT, null));
        return sopir;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
