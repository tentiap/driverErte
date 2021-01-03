package com.example.drivererte;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.drivererte.model.loginFeeder.LoginFeederData;

import java.util.HashMap;

public class SessionManagerFeeder {
    private Context _context;
    private SharedPreferences sharedPreferencesFeeder;
    private SharedPreferences.Editor editorFeeder;

    public static final String IS_LOGGED_IN_FEEDER = "isLoggedInFeeder";
    public static final String ID_USERS = "id_users";
    public static final String EMAIL = "email";
    public static final String NAMA = "nama";
    public static final String USERNAME = "username";
    public static final String KONTAK = "kontak";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String WILAYAH = "id_kota";

    public SessionManagerFeeder(Context context){
        this._context = context;
        sharedPreferencesFeeder = PreferenceManager.getDefaultSharedPreferences(context);
        editorFeeder = sharedPreferencesFeeder.edit();
    }

    public void createLoginFeederSession(LoginFeederData feeder){
        editorFeeder.putBoolean(IS_LOGGED_IN_FEEDER, true);
        editorFeeder.putString(ID_USERS, feeder.getIdUsers());
        editorFeeder.putString(EMAIL, feeder.getEmail());
        editorFeeder.putString(NAMA, feeder.getNama());
        editorFeeder.putString(USERNAME, feeder.getUsername());
        editorFeeder.putString(KONTAK, feeder.getKontak());
        editorFeeder.putString(JENIS_KELAMIN, feeder.getJenisKelamin());
        editorFeeder.putString(WILAYAH, feeder.getIdKota());
        editorFeeder.commit();
    }

    public HashMap<String,String> getFeederDetail(){
        HashMap<String,String> feeder = new HashMap<>();
        feeder.put(ID_USERS, sharedPreferencesFeeder.getString(ID_USERS, null));
        feeder.put(EMAIL, sharedPreferencesFeeder.getString(EMAIL, null));
        feeder.put(NAMA, sharedPreferencesFeeder.getString(NAMA, null));
        feeder.put(USERNAME, sharedPreferencesFeeder.getString(USERNAME, null));
        feeder.put(KONTAK, sharedPreferencesFeeder.getString(KONTAK, null));
        feeder.put(JENIS_KELAMIN, sharedPreferencesFeeder.getString(JENIS_KELAMIN, null));
        feeder.put(WILAYAH, sharedPreferencesFeeder.getString(WILAYAH, null));
        return feeder;
    }

    public void logoutSession(){
        editorFeeder.clear();
        editorFeeder.commit();
    }

    public boolean isLoggedInFeeder(){
        return sharedPreferencesFeeder.getBoolean(IS_LOGGED_IN_FEEDER, false);
    }

}
