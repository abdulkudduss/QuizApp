package com.example.quiz_lb1_v6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnDev,btnHelp;
    private ImageButton btnNext;
    private int [] primeNum = new int[6];
    private  TextView tvQuestion;
   Questions[] questionArray = new Questions[]{
           new Questions(R.string.tvQuestion1,true,false,true,true,false,true),
           new Questions(R.string.tvQuestion2,true,false,false,true,false,true),
           new Questions(R.string.tvQuestion3,false,true,false,false,true,false),
           new Questions(R.string.tvQuestion4,false,true,false,false,false,false)
   };

    private int questIndex = 0;
    private void updateQuestion(){
        int question = questionArray[questIndex].getQuestion();
        tvQuestion.setText(question);
    }
    private void checkAnswer(Button bt){
        boolean[] trueAnswer = new boolean[6];
        trueAnswer[0]=questionArray[questIndex].isBtn_1();
        trueAnswer[1]=questionArray[questIndex].isBtn_2();
        trueAnswer[2]=questionArray[questIndex].isBtn_3();
        trueAnswer[3]=questionArray[questIndex].isBtn_4();
        trueAnswer[4]=questionArray[questIndex].isBtn_5();
        trueAnswer[5]=questionArray[questIndex].isBtn_6();
        int mResId = 0;
        String d= String.valueOf(bt.getTag());
        int u=Integer.parseInt(d);
        if(trueAnswer[u-1]){
            mResId=R.string.tstTrue;
        }else {
            mResId=R.string.tstFalse;
        }

        Toast.makeText(this,mResId,Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQuestion = findViewById(R.id.rules_TextView);
        updateQuestion();
        btnNext = findViewById(R.id.next_Button);
        btnDev = findViewById(R.id.btnDev);
        btnHelp = findViewById(R.id.btnHelp);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);

      //  int d1= (int) btnNum1.getTag();
        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        R.string.tstDev,
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        R.string.tstHelp,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnNum1);
            }
        });
        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnNum2);
            }
        });
        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnNum3);
            }
        });
        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnNum4);
            }
        });
        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnNum5);
            }
        });
        btnNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkAnswer(btnNum6);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questIndex = (questIndex+1) % questionArray.length;
                updateQuestion();
            }
        });
    }

}