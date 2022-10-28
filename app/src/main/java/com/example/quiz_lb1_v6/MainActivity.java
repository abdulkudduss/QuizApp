package com.example.quiz_lb1_v6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    private final String KEY_INDEX="index";
    private final String KEY_isHlp="hlp";
    private final String TAG="MainActivity";
    private boolean isHlpUsd;
    boolean arrAns[]={false,false,false,false};
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
        if(isHlpUsd){
            Toast.makeText(this,R.string.advice,Toast.LENGTH_SHORT).show();
            isHlpUsd=false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu12,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.hlpOn:findViewById(R.id.btnHelp).setEnabled(true);return true;
            case R.id.hlpOff:findViewById(R.id.btnHelp).setEnabled(false);return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState"); //запись в журнал
        savedInstanceState.putInt(KEY_INDEX, questIndex); //сохранить пару
        // «ключ-значение»
        // в объекте
        // saveInstanceState
        savedInstanceState.putBoolean(KEY_isHlp,isHlpUsd);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null) return;
        isHlpUsd=data.getBooleanExtra(HelpActivity.EXTRA_HELP_WAS_USED,false);
        arrAns[data.getIntExtra(HelpActivity.EXTRA_KEY,questIndex)]=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tvQuestion = findViewById(R.id.rules_TextView);
        if(savedInstanceState!=null){
            questIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            isHlpUsd=savedInstanceState.getBoolean(KEY_isHlp);
        }
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
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                intent.putExtra(HelpActivity.EXTRA_INDEX_OF_QUESTION,questIndex);
                startActivityForResult(intent,7);


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
                isHlpUsd=arrAns[questIndex];
                updateQuestion();
            }
        });

    }

}