package com.example.quizmath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textLevel;
    TextView textRightAns;
    TextView textQ;

    Button buttonOp1;
    Button buttonOp2;
    Button buttonOp3;

    int level=0;
    int great =0;
    int rightAns=0;
    String realOp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        textLevel=findViewById(R.id.textQNum);
        textRightAns = findViewById(R.id.textRightAns);
        textQ=findViewById(R.id.textQ);

        buttonOp1 = findViewById(R.id.buttonOp1);
        buttonOp2 = findViewById(R.id.buttonOp2);
        buttonOp3 = findViewById(R.id.buttonOp3);

        textLevel.setText("Q : "+ level+ " / 10");
        textRightAns.setText("RA : "+ great+ " / 10");

        if(level<10){
            getARandomQuestion();
        }
    }

    private void getARandomQuestion() {

        buttonOp1.setBackgroundResource(R.drawable.button_op);
        buttonOp2.setBackgroundResource(R.drawable.button_op);
        buttonOp3.setBackgroundResource(R.drawable.button_op);

        int firstNum= new Random().nextInt(10);
        int secondNum= new Random().nextInt(10);

        int operation = new Random().nextInt(3)+1;

        int optinA= new Random().nextInt(50);
        int optinB= new Random().nextInt(50);

        if(operation ==1){
            realOp="+";
            rightAns=firstNum+secondNum;
            textQ.setText(firstNum+" "+ realOp+" "+secondNum+" = ?");
        }else{
            if(operation ==2){
                realOp="*";
                rightAns=firstNum * secondNum;
                textQ.setText(firstNum+" "+ realOp+" "+secondNum+" = ?");
            }else {
                if(operation == 3){
                    realOp="-";
                    if(firstNum < secondNum){
                        rightAns = secondNum - firstNum;
                        textQ.setText(secondNum+" "+ realOp+" "+firstNum+" = ?");
                    }else{
                        rightAns = firstNum - secondNum;
                        textQ.setText(firstNum+" "+ realOp+" "+secondNum+" = ?");
                    }
                }
            }
        }
    int position = new Random().nextInt(3)+1;
        if(position == 1){
            buttonOp1.setText(""+rightAns);
            buttonOp2.setText(""+optinA);
            buttonOp3.setText(""+optinB);
        }else {
            buttonOp1.setText(""+optinA);
            if(position==2){
                buttonOp2.setText(""+rightAns);
                buttonOp3.setText(""+optinB);
            }else {
                buttonOp2.setText(""+optinB);
                buttonOp3.setText(""+rightAns);
            }
        }
        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonOp1.getText().equals(""+rightAns)){
                    buttonOp1.setBackgroundResource(R.drawable.right_ans_bg);
              great ++;
              level ++;
              textLevel.setText("Q : "+level+" / 10");
              textRightAns.setText("RA : "+great+ " / 10");

                }else{
                    level = level+1;
                    textLevel.setText("Q : "+level+" / 10");
                    buttonOp1.setBackgroundResource(R.drawable.wrong_ans_bg);

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level<10){
                            getARandomQuestion();
                        }else{

                            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                            alert.setTitle("Result");
                            alert.setMessage("You answered "+great+" / 10");
                            alert.show();

                        }

                    }
                },1000);

            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonOp2.getText().equals(""+rightAns)){
                    buttonOp2.setBackgroundResource(R.drawable.right_ans_bg);
                    great = great+1;
                    level = level +1;
                    textLevel.setText("Q : "+level+" / 10");
                    textRightAns.setText("RA :"+great+ " / 10");

                }else{
                    level = level+1;
                    textLevel.setText("Q : "+level+" / 10");
                    buttonOp2.setBackgroundResource(R.drawable.wrong_ans_bg);

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level<10){
                            getARandomQuestion();
                        }else{

                            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                            alert.setTitle("Result");
                            alert.setMessage("You answered "+great+" / 10");
                            alert.show();
                        }

                    }
                },1000);

            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonOp3.getText().equals(""+rightAns)){
                    buttonOp3.setBackgroundResource(R.drawable.right_ans_bg);
                    great = great+1;
                    level = level +1;
                    textLevel.setText("Q : "+level+" / 10");
                    textRightAns.setText("RA :"+great+ " / 10");

                }else{
                    level = level+1;
                    textLevel.setText("Q : "+level+" / 10");
                    buttonOp3.setBackgroundResource(R.drawable.wrong_ans_bg);

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level<10){
                            getARandomQuestion();
                        }else{

                            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                            alert.setTitle("Result");
                            alert.setMessage("You answered "+great+" / 10");
                            alert.show();
                        }

                    }
                },1000);

            }
        });


    }
}