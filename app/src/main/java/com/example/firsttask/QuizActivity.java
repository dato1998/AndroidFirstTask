package com.example.firsttask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttask.data.Storage;
import com.example.firsttask.data.StorageSharePreferenceImpl;

public class QuizActivity extends AppCompatActivity {
    private EditText mQuestion1;
    private EditText mQuestion2;
    private EditText mQuestion3;
    private EditText mQuestion4;
    private EditText mQuestion5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestion1 = findViewById(R.id.question1);
        mQuestion2 = findViewById(R.id.question2);
        mQuestion3 = findViewById(R.id.question3);
        mQuestion4 = findViewById(R.id.question4);
        mQuestion5 = findViewById(R.id.question5);
    }

    public void submit(View view) {
        String questionAnswer1 = mQuestion1.getText().toString().trim();
        String questionAnswer2 = mQuestion2.getText().toString().trim();
        String questionAnswer3 = mQuestion3.getText().toString().trim();
        String questionAnswer4 = mQuestion4.getText().toString().trim();
        String questionAnswer5 = mQuestion5.getText().toString().trim();
        int countCorrect = 0;
        if (questionAnswer1.equals("ბრაზილია")) {
            countCorrect++;
        }
        if (questionAnswer2.equals("ვარშავა")) {
            countCorrect++;
        }
        if (questionAnswer3.equals("9") || questionAnswer3.equals("ცხრა")) {
            countCorrect++;
        }
        if (questionAnswer4.equals("4") || questionAnswer4.equals("ოთხი")) {
            countCorrect++;
        }
        if (questionAnswer5.equals("ვატიკანი")) {
            countCorrect++;
        }
        Storage storage = new StorageSharePreferenceImpl();
        storage.save(this, Integer.toString(countCorrect));
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("score", Integer.toString(countCorrect));
        setResult(10001, intent);
        finish();
    }
}
