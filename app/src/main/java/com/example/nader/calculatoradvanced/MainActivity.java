package com.example.nader.calculatoradvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;
import java.io.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView progtxt;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,minus,div,mult,C,power,equal,C2;
    Button plus,rbrk,lbrk,dot,fct;
    boolean clearflag = false;
    boolean inf = false;
    static int c;

    public static String TurnEq(String test1)
    {
        ArrayList<String> elements = new ArrayList<>();
        String emp = "";
        for(int i = 0 ; i < test1.length() ;i++)
        {
            if(test1.charAt(i) == ' ')
            {
                elements.add(emp);
                emp = "";
            }
            else {
                emp = emp + test1.charAt(i);
            }
        }
        elements.add(emp);
        emp = "";
        return check(elements);
    }
    public static String check(ArrayList<String> x)
    {
        Stack<Integer> brk = new Stack<>();
        for(int i = 0 ; i < x.size() ; i++)
        {
            if((x.get(i)).equals("("))
            {
                brk.push(i);
            }
            else
            {
                if((x.get(i)).equals(")"))
                {
                    int poss = brk.pop();
                    java.util.List<String> sub = x.subList(poss+1, i+1);
                    ArrayList<String> tempo = new ArrayList<>();
                    for(int j = 0 ; j < sub.size()-1 ; j++)
                    {
                        tempo.add(sub.get(j));
                    }

                    x.set(poss,Solve(tempo));
                    for(int j = poss + 1 ; j <= i ; i--)
                    {
                        x.remove(j);
                    }

                }
            }
        }
        return Solve(x);

    }
    public static String Solve(ArrayList<String> elements1) {
        double temp1, temp2;
        for (int i = 0; i < elements1.size(); i++) {
            if (elements1.get(i).equals("!")) {
                temp1 = Double.parseDouble(elements1.get(i - 1));
                double temp = 1;
                if(temp1 == 0){
                    temp = 1;
                }
                else{
                    for (int j = 1; j <= temp1; j++) {
                        temp = temp * j;
                    }
                    elements1.set(i - 1, "" + temp);
                    elements1.remove(i);
                    i--;
                }

            }
        }
            for (int i = 0; i < elements1.size(); i++) {
            if (elements1.get(i).equals("^")) {
                temp1 = Double.parseDouble(elements1.get(i - 1));
                temp2 = Double.parseDouble(elements1.get(i + 1));
                double temp = temp1;
                if(temp2 == 0){
                    temp = 1;
                }
                else{
                    for (int j = 1; j < temp2; j++) {
                    temp = temp * temp1;
                    }
                    elements1.set(i - 1, "" + temp);
                    elements1.remove(i);
                    elements1.remove(i);
                    i--;
                }

            }
        }
        for (int i = 0; i < elements1.size(); i++) {
            if (elements1.get(i).equals("x") || elements1.get(i).equals("/")) {
                temp1 = Double.parseDouble(elements1.get(i - 1));
                temp2 = Double.parseDouble(elements1.get(i + 1));
                if (elements1.get(i).equals("x")) {
                    temp1 = temp1 * temp2;
                } else {
                    temp1 = temp1 / temp2;
                }
                elements1.set(i - 1, "" + temp1);
                elements1.remove(i);
                elements1.remove(i);
                i--;
            }
        }
            for (int i = 0; i < elements1.size(); i++) {
            if (elements1.get(i).equals("+") || elements1.get(i).equals("-")) {
                temp1 = Double.parseDouble(elements1.get(i - 1));
                temp2 = Double.parseDouble(elements1.get(i + 1));
                if (elements1.get(i).equals("+")) {
                    temp1 = temp1 + temp2; }
                    else {
                        temp1 = temp1 - temp2;
                            }
                            elements1.set(i - 1, "" + temp1);
                            elements1.remove(i);
                            elements1.remove(i);
                            i--;
                        }
                    }return elements1.get(0);

                }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.but0);
        btn1 = findViewById(R.id.but1);
        btn2 = findViewById(R.id.but2);
        btn3 = findViewById(R.id.but3);
        btn4 = findViewById(R.id.but4);
        btn5 = findViewById(R.id.but5);
        btn6 = findViewById(R.id.but6);
        btn7 = findViewById(R.id.but7);
        btn8 = findViewById(R.id.but8);
        btn9 = findViewById(R.id.but9);
        dot = findViewById(R.id.dot);
        lbrk = findViewById(R.id.lbrk);
        rbrk = findViewById(R.id.rbrk);
        fct = findViewById(R.id.fct);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        div = findViewById(R.id.div);
        equal = findViewById(R.id.equal);
        mult = findViewById(R.id.mult);
        C = findViewById(R.id.C);
        C2 = findViewById(R.id.C2);
        power = findViewById(R.id.power);
        progtxt = findViewById(R.id.progtxt);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        fct.setOnClickListener(this);
        dot.setOnClickListener(this);
        lbrk.setOnClickListener(this);
        rbrk.setOnClickListener(this);
        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);
        power.setOnClickListener(this);
        C.setOnClickListener(this);
        C2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
                switch(v.getId()){
                    case (R.id.but0):
                        progtxt.setText(progtxt.getText().toString() + '0');
                        break;
                    case (R.id.but1):
                        progtxt.setText(progtxt.getText().toString() + '1');
                        break;
                    case (R.id.but2):
                        progtxt.setText(progtxt.getText().toString() + '2');
                        break;

                    case (R.id.but3):
                        progtxt.setText(progtxt.getText().toString() + '3');
                        break;
                    case (R.id.but4):
                        progtxt.setText(progtxt.getText().toString() + '4');
                        break;

                    case (R.id.but5):
                        progtxt.setText(progtxt.getText().toString() + '5');
                        break;

                    case (R.id.but6):
                        progtxt.setText(progtxt.getText().toString() + '6');
                        break;

                    case (R.id.but7):
                        progtxt.setText(progtxt.getText().toString() + '7');
                        break;

                    case (R.id.but8):
                        progtxt.setText(progtxt.getText().toString() + '8');
                        break;

                    case (R.id.but9):
                        progtxt.setText(progtxt.getText().toString() + '9');
                        break;

                    case(R.id.dot):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + ".");
                        }
                        break;

                    case(R.id.fct):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " ! ");
                        }
                        break;

                    case(R.id.lbrk):
                        if(progtxt.getText().toString().length() == 0)
                        {
                            progtxt.setText(progtxt.getText().toString() + "( ");
                            c++;
                        }
                        else{
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) == ' ' )
                            {
                                progtxt.setText(progtxt.getText().toString() + "( ");
                                c++;
                            }
                        }
                        break;

                    case(R.id.rbrk):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && c != 0 ){
                            progtxt.setText(progtxt.getText().toString() + " )");
                            c--;
                        }
                        break;
                    case(R.id.plus):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " + ");
                        }
                        else{
                            if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) != '(') {
                                progtxt.setText(progtxt.getText().toString() + " + ");
                            }
                        }
                        break;
                    case(R.id.minus):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " - ");
                        }
                        else{
                            if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) != '(') {
                                progtxt.setText(progtxt.getText().toString() + " - ");
                            }
                        }
                        break;
                    case(R.id.div):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " / ");
                        }
                        else{
                            if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) != '(') {
                                progtxt.setText(progtxt.getText().toString() + " / ");
                            }
                        }
                        break;
                    case(R.id.mult):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " x ");
                        }
                        else{
                            if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) != '(') {
                                progtxt.setText(progtxt.getText().toString() + " x ");
                            }
                        }
                        break;
                    case(R.id.power):
                        if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' '){
                            progtxt.setText(progtxt.getText().toString() + " ^ ");
                        }
                        else{
                            if(progtxt.getText().toString().length()!=0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) != ' ' && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) != '(') {
                                progtxt.setText(progtxt.getText().toString() + " ^ ");
                            }
                        }
                        break;
                    case(R.id.equal):
                        if(clearflag == false && c == 0 && inf == false && progtxt.getText().toString().length() !=0){
                        if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) == ' ')
                        {
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == 'x')
                                progtxt.setText(TurnEq(progtxt.getText().toString()+"1"));
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == '/')
                                progtxt.setText(TurnEq(progtxt.getText().toString()+"1"));
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == '+')
                                progtxt.setText(TurnEq(progtxt.getText().toString()+"0"));
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == '-')
                                progtxt.setText(TurnEq(progtxt.getText().toString()+"0"));
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == '^')
                                progtxt.setText(TurnEq(progtxt.getText().toString()+"1"));
                            else
                            {
                                progtxt.setText(TurnEq(progtxt.getText().toString()));
                            }
                            if(progtxt.getText().toString().equals("Infinity"))
                            {
                                inf = true;
                            }
                        }
                        else{
                            progtxt.setText(TurnEq(progtxt.getText().toString()));
                            if(progtxt.getText().toString().equals("Infinity"))
                            {
                                inf = true;
                            }
                        }
                    }
                    else{
                            if(c != 0)
                            {
                                Toast.makeText(getApplicationContext(),"The equation is not complete.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                if(inf == true)
                                {
                                    Toast.makeText(getApplicationContext(),"The equation is Infinit. Press C.", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"The equation is not complete. Press C.", Toast.LENGTH_SHORT).show();
                                    clearflag = true;
                                }

                            }
                        }
                        break;
                    case(R.id.C):
                        progtxt.setText("");
                        c = 0;
                        clearflag = false;
                        inf = false;
                        break;
                    case(R.id.C2):
                        if(progtxt.getText().toString().length()!=0 && clearflag == false){
                            if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-1) == ' '){
                                if(progtxt.getText().toString().length() != 0 && progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == '(')
                                {
                                    c--;
                                    String x = progtxt.getText().toString();
                                    progtxt.setText(x.substring(0,x.length()-2));
                                }
                                else{
                                    if(progtxt.getText().toString().charAt(progtxt.getText().toString().length()-2) == ')')
                                    {
                                        c++;
                                        String x = progtxt.getText().toString();
                                        progtxt.setText(x.substring(0,x.length()-3));
                                    }
                                    else{
                                        String x = progtxt.getText().toString();
                                        progtxt.setText(x.substring(0,x.length()-2));
                                    }
                                }
                            }
                            else{
                                String x = progtxt.getText().toString();
                                progtxt.setText(x.substring(0,x.length()-1));
                            }
                        }
                        break;
        }

            }
    }
