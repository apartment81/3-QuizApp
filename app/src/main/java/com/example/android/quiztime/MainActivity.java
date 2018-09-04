package com.example.android.quiztime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void question_1() {

        RadioButton c = findViewById(R.id.radio_c);

        if (c.isChecked()) {
            score += 1;
        }
    }

    public void question_2() {

        RadioButton a = findViewById(R.id.radio_false);

        if (a.isChecked()) {
            score += 1;
        }
    }

    private void question_three() {

        EditText question_answer = findViewById(R.id.question_response_text);
        String answer = question_answer.getText().toString();
        if (answer.equalsIgnoreCase("RelativeLayout")) {
            score += 1;
        }
    }

    private void question_four() {

        CheckBox option1CheckBox = findViewById(R.id.good_answer1);
        boolean good_answer1 = option1CheckBox.isChecked();
        CheckBox option2CheckBox = findViewById(R.id.good_answer2);
        boolean good_answer2 = option2CheckBox.isChecked();
        CheckBox option3CheckBox = findViewById(R.id.wrong_answer);
        boolean wrongAnswer = option3CheckBox.isChecked();

        if (good_answer1 && good_answer2 && !wrongAnswer) {
            score += 1;
        }
    }

    public void question_5() {

        RadioButton a = findViewById(R.id.radio_5a);

        if (a.isChecked()) {
            score += 1;
        }
    }


    private void finalScore() {
        score = 0;
        question_1();
        question_2();
        question_three();
        question_four();
        question_5();
    }

    public void submitAnswers(View view) {

        finalScore();
        //Get user's name
        EditText nameField = findViewById(R.id.name_field_text);
        String userName = nameField.getText().toString();
        Toast toast = Toast.makeText(this, userName + ", your score is: " + score + "/5", Toast.LENGTH_LONG);
        toast.show();
    }
}
