package com.example.eddiehw2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textGPA;
    EditText etm;
    EditText ete;
    EditText ets;
    EditText eth;
    EditText etg;
    LinearLayout main;
    Button button;
    Button clearbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textGPA=(TextView)findViewById(R.id.txtGPA);
        etm=(EditText)findViewById(R.id.etMath);
        ete=(EditText)findViewById(R.id.etEnglsih);
        ets=(EditText)findViewById(R.id.etScience);
        eth=(EditText)findViewById(R.id.etHistory);
        etg=(EditText)findViewById(R.id.etGym);
        main=(LinearLayout)findViewById(R.id.main);
        button=(Button) findViewById(R.id.btnGPA);
        clearbutton=(Button)findViewById(R.id.btnclear);
    }

    public void calculateGPA(View view) {

        if(TextUtils.isEmpty(etm.getText().toString()))
        {
            Toast.makeText(this, "fill in Math gpa", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(ete.getText().toString()))
        {
            Toast.makeText(this, "fill in English gpa", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(ets.getText().toString()))
        {
            Toast.makeText(this, "fill in Science gpa", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(eth.getText().toString()))
        {
            Toast.makeText(this, "fill in History gpa", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(etg.getText().toString()))
        {
            Toast.makeText(this, "fill in Gym gpa", Toast.LENGTH_SHORT).show();
            return;
        }

        String math=etm.getText().toString();
        int mathnum=Integer.parseInt(math);
        String english=ete.getText().toString();
        int englishnum=Integer.parseInt(english);
        String Science=ets.getText().toString();
        int sciencenum=Integer.parseInt(Science);
        String history=eth.getText().toString();
        int historynum=Integer.parseInt(history);
        String gym=etg.getText().toString();
        int gymnum=Integer.parseInt(gym);

        int totalclasses=5;
        int totalGPA=(mathnum+englishnum+sciencenum+historynum+gymnum)/totalclasses;

        if(totalGPA>=80)
        {
            main.setBackgroundColor(Color.rgb(0,255,0));
        }
        else if(totalGPA<80&&totalGPA>60)
        {
            main.setBackgroundColor(Color.rgb(255,255,0));
        }
        else if(totalGPA<=60)
        {
            main.setBackgroundColor(Color.rgb(255,0,0));
        }
        textGPA.setText("Total GPA: "+ totalGPA);
        button.setVisibility(view.GONE);
        clearbutton.setVisibility(View.VISIBLE);

    }

    public void Clear(View view) {
        main.setBackgroundColor(Color.rgb(255,255,255));
        etm.setText("");
        ete.setText("");
        etg.setText("");
        eth.setText("");
        ets.setText("");
        clearbutton.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
        textGPA.setText("");
    }
}