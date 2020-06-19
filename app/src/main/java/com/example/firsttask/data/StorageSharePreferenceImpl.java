package com.example.firsttask.data;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageSharePreferenceImpl implements Storage {

  private static final String QUIZ_SCORE = "quizScore";
  private static final String KEY = "previousScore";

  @Override
  public void save(Context context, String value) {
    SharedPreferences sharedPref = getInstance(context);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString(KEY, value);
    editor.apply();
  }

  @Override
  public String get(Context context) {
    SharedPreferences sharedPref = getInstance(context);
    return sharedPref.getString(KEY, null);
  }

  private SharedPreferences getInstance(Context context) {
    SharedPreferences sharedPref = context.getSharedPreferences(QUIZ_SCORE, Context.MODE_PRIVATE);
    return sharedPref;
  }

}
