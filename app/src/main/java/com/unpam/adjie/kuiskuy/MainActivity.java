package com.unpam.adjie.kuiskuy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // UI references.
    private TextView mAnswerClueView;
    private TextView mQuestionView;
    private EditText mAnswerFieldView;
    private Button mButtonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ClassSoal Soal1 = new ClassSoal();

        Soal1.setQuestion("Presiden Pertama Negara Finlandia");
        Soal1.setRealAnswer("JAMAL");

        mQuestionView = (TextView) findViewById(R.id.textView2);
        String realAnswer = Soal1.getRealAnswer();

        mQuestionView.setText(Soal1.getQuestion());

        mAnswerClueView = (TextView) findViewById(R.id.answerClue);
        mAnswerClueView.setText(createClue(realAnswer));

        mAnswerFieldView = (EditText) findViewById(R.id.editText);
        mAnswerClueView = (TextView) findViewById(R.id.email);
        mButtonAnswer = (Button) findViewById(R.id.button);
        mButtonAnswer.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v)
            {
                String answer = mAnswerFieldView.getText().toString().toUpperCase();
                Soal1.setAnswer(answer);
                answerAttemp(Soal1.getCorrect());
            }
        }
        );
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public String createClue(String realAnswer) {
        Integer len = realAnswer.length();
        Integer rand = randomWithRange(0, len + 1);
        String newString = "";

        for(Integer i=0; i<len; i++){
            if (i == rand) {
                newString += realAnswer.charAt(i) + " ";
            } else {
                newString += "_ ";
            }
        }

        return newString.toUpperCase();
    }

    public void answerAttemp(Boolean correct){
        if (correct) {
            openDialog("Correct");
        } else {
            openDialog("Incorrect");
        }
    }

    public void openDialog(String str) {
        Toast.makeText(getBaseContext(), "Your answer is " + str , Toast.LENGTH_SHORT ).show();
    }



}
