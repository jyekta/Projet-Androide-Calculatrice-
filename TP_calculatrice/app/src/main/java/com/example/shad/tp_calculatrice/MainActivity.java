package com.example.shad.tp_calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaration de la zone de saisie
    EditText num;

    //declaration des boutton
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    //button action
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonReset;
    Button buttonEgal;
    Button buttonPoint;

    //autre variable
    private double res;
    private boolean clicOperateur = false;

    //Variable qui enregiste l'operateur
    private String operateur = "";

    //verifie quela variable est mise a jour
    private boolean update = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView);

    //accesse au variables
        num = (EditText) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus =(Button) findViewById(R.id.button10);
        buttonMoins = (Button) findViewById(R.id.button11);
        buttonMul = (Button) findViewById(R.id.button12);
        buttonDiv = (Button) findViewById(R.id.button13);
        buttonPoint = (Button) findViewById(R.id.button14);
        buttonEgal = (Button) findViewById(R.id.button15);
        buttonReset= (Button) findViewById(R.id.button16);


        // Ecoute des boutton
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //chiffreClick("+");
                plusClick();

            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                resetClick();
            }
        });


    }

    //Retoune le chiffre
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!num.getText().equals("0"))
                str = num.getText() + str;
        }
        num.setText(str);
    }


    //Addition
    public void plusClick(){
        //si clicOperateur est vrai on calcule sinon on renvoi le resultat
        if(clicOperateur){
            calcul();
            num.setText(String.valueOf(res));
        }else{
            res = Double.valueOf(num.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }

    //Soustraction
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            num.setText(String.valueOf(res));
        }else{
            res = Double.valueOf(num.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }


    //Multiplication
    public void mulClick(){
        if(clicOperateur){
            calcul();
            num.setText(String.valueOf(res));
        }else{
            res = Double.valueOf(num.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    //division
    public void divClick(){
        if(clicOperateur){
            calcul();
            num.setText(String.valueOf(res));
        }else{
            res = Double.valueOf(num.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    //Egale
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //Reset
    public void resetClick() {
        clicOperateur = false;
        update = true;
        res = 0;
        operateur = "";
        num.setText("");

    }

    //Fait le calcul demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            res = res + Double.valueOf(num.getText().toString()).doubleValue();
            num.setText(String.valueOf(res));
        }

        if(operateur.equals("-")){
            res = res - Double.valueOf(num.getText().toString()).doubleValue();
            num.setText(String.valueOf(res));
        }

        if(operateur.equals("*")){
            res = res * Double.valueOf(num.getText().toString()).doubleValue();
            num.setText(String.valueOf(res));
        }

        if(operateur.equals("/")){
            try{
                res = res / Double.valueOf(num.getText().toString()).doubleValue();
                num.setText(String.valueOf(res));
            }catch(ArithmeticException e){
                num.setText("0");
            }
        }
    }


}
