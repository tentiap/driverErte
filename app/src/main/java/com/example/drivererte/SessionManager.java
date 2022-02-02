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
    public static final String ID_SOPIR = "id_sopir";
    public static final String ID_FEEDER = "id_feeder";
    public static final String EMAIL = "email";
    public static final String NAMA = "nama";
    public static final String USERNAME = "username";
    public static final String KONTAK = "kontak";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
//    public static final String PLAT = "plat_mobil";
//    public static final String MEREK = "merek_mobil";
    public static final String WILAYAH = "id_kota";



    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(LoginSopirData sopir){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(ID_SOPIR, sopir.getIdSopir());
        editor.putString(EMAIL, sopir.getEmail());
        editor.putString(NAMA, sopir.getNama());
        editor.putString(USERNAME, sopir.getUsername());
        editor.putString(KONTAK, sopir.getKontak());
        editor.putString(JENIS_KELAMIN, sopir.getJenisKelamin());
//        editor.putString(PLAT, sopir.get);
//        editor.putString(MEREK, sopir.getMerekMobil());
        editor.commit();
    }

//    public void createLoginFeederSession(LoginFeederData feeder){
//        editor.putBoolean(IS_LOGGED_IN, true);
//        editor.putString(ID_FEEDER, feeder.getIdUsers());
//        editor.putString(EMAIL, feeder.getEmail());
//        editor.putString(NAMA, feeder.getNama());
//        editor.putString(USERNAME, feeder.getUsername());
//        editor.putString(KONTAK, feeder.getKontak());
//        editor.putString(JENIS_KELAMIN, feeder.getJenisKelamin());
//        editor.putString(WILAYAH, feeder.getIdKota());
//        editor.commit();
//    }
//
//    public HashMap<String,String> getSopirDetail(){
//        HashMap<String,String> sopir = new HashMap<>();
//        sopir.put(ID_SOPIR, sharedPreferences.getString(ID_SOPIR, null));
//        sopir.put(EMAIL, sharedPreferences.getString(EMAIL, null));
//        sopir.put(NAMA, sharedPreferences.getString(NAMA, null));
//        return sopir;
//    }

    public HashMap<String,String> getSopirDetail(){
        HashMap<String,String> sopir = new HashMap<>();
        sopir.put(ID_SOPIR, sharedPreferences.getString(ID_SOPIR, null));
        sopir.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        sopir.put(NAMA, sharedPreferences.getString(NAMA, null));
        sopir.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        sopir.put(KONTAK, sharedPreferences.getString(KONTAK, null));
        sopir.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN, null));
//        sopir.put(PLAT, sharedPreferences.getString(PLAT, null));
//        sopir.put(MEREK, sharedPreferences.getString(MEREK, null));
        return sopir;
    }

//    public HashMap<String,String> getFeederDetail(){
//        HashMap<String,String> feeder = new HashMap<>();
//        feeder.put(ID_USERS, sharedPreferences.getString(ID_USERS, null));
//        feeder.put(EMAIL, sharedPreferences.getString(EMAIL, null));
//        feeder.put(NAMA, sharedPreferences.getString(NAMA, null));
//        feeder.put(USERNAME, sharedPreferences.getString(USERNAME, null));
//        feeder.put(KONTAK, sharedPreferences.getString(KONTAK, null));
//        feeder.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN, null));
//        feeder.put(WILAYAH, sharedPreferences.getString(WILAYAH, null));
//        return feeder;
//    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
