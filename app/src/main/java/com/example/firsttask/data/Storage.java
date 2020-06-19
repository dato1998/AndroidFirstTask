package com.example.firsttask.data;

import android.content.Context;

public interface Storage {
    void save(Context context, String value);
    String get(Context context);
}
