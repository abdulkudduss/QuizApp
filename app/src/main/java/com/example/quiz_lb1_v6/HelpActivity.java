package com.example.quiz_lb1_v6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class HelpActivity extends AppCompatActivity {
    public static final String EXTRA_INDEX_OF_QUESTION = "HelpActivity_index_of_question";
    public static final String EXTRA_HELP_WAS_USED = "HelpActivity_help_was_used";
    public static final String EXTRA_KEY= "isKEYarr";
    public static final String KEY= "isKEY";
    private boolean flag=false;
    private int qIndex;
    private TextView helpText;
    private final int[] arrHelp={R.string.help1,R.string.help2,R.string.help3,R.string.help4};
    private void setHlpUsdResult(boolean isHlpUsed){
        Intent data = new Intent();
        Intent intent = data.putExtra(EXTRA_HELP_WAS_USED, isHlpUsed);
        if(isHlpUsed) data.putExtra(EXTRA_KEY,qIndex);
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY,flag);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setHlpUsdResult(flag);

        if(savedInstanceState!=null){
            flag=savedInstanceState.getBoolean(KEY);
            setHlpUsdResult(flag);
        }
        qIndex=getIntent().getIntExtra(EXTRA_INDEX_OF_QUESTION,0);
        helpText=findViewById(R.id.helpTextView);
        Button btnHelp = findViewById(R.id.showHelpButton);
        btnHelp.setOnClickListener(view -> {
            helpText.setText(arrHelp[qIndex]);
            flag=true;

            setHlpUsdResult(flag);

        });
    }
}
