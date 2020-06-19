package com.example.firsttask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttask.data.Storage;
import com.example.firsttask.data.StorageSharePreferenceImpl;

public class MainActivity extends AppCompatActivity {
    private TextView mPreviousScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreviousScore = findViewById(R.id.score_text);
        Storage storage = new StorageSharePreferenceImpl();
        String score = storage.get(this);
        if (score != null) {
            mPreviousScore.setText(score);
        }
    }

    public void beginQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivityForResult(intent, 10001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPreviousScore.setText(data.getStringExtra("score"));
    }
}
