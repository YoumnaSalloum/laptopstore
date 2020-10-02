package com.example.laptopstore;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SharedPreference {
    // the name of the file.
    public static final String PREFS_NAME = "GIFT_APP";
    //key for data in shared
    public static final String FAVORITES  = "GIFTS";
    public SharedPreference() {
        super();
    }
    // THIS FOUR METHODS ARE USED FOR MAINTAINING FAVORITES.
    public void saveFavorite(Context context, ArrayList<lap> lap) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(lap);
        editor.putString(FAVORITES, jsonFavorites);
        editor.apply();
    }

    public void addFavorite(Context context, lap lap) {
        ArrayList<lap> favorites = getFavorites(context);
        if (favorites == null) {
            favorites = new ArrayList<>();
            favorites.add(lap);
            saveFavorite(context, favorites);
        }
        else {
            favorites.add(lap);
            saveFavorite(context,favorites);
        }
    }
    public void removeFavorite(Context context, int index) {
        ArrayList<lap> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(index);
            saveFavorite(context, favorites);
        }
    }
    public void  removeall(Context context){
        ArrayList<lap> favorites = getFavorites(context);
        if (favorites != null) {
            favorites=null;
            saveFavorite(context, favorites);
        }

    }
    public ArrayList<lap> getFavorites(Context context) {
        SharedPreferences settings;
        List<lap> favorites;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        // contains data in SharedPreferences??
        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            lap[] favoriteItems = gson.fromJson(jsonFavorites,
                    lap[].class);
            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<>(favorites);
        } else {
            return new ArrayList<>();
        }
        return (ArrayList<lap>) favorites;
    }
}