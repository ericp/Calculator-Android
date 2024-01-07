package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class Main extends AppCompatActivity implements View.OnClickListener {

        //Variables Declaration
        TextView Operation;
        TextView Result;
        double number1;
        double number2 = 0;
        String b1;
        String b2;
        String b3;
        String b4;
        String b5;
        String b6;
        String b7;
        String b8;
        String b9;
        String b0;
        String bpoint;
        String bequal;
        String nNumber2;
        BigDecimal total;
        String operand;
        int counter=0;
        //"Check Variables":
        boolean used=false;
        boolean noNumber2=true;
        boolean usedOperand=false;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

            //Declarations:
            Operation = (TextView) findViewById(R.id.operation);
            Result = (TextView) findViewById(R.id.result);

            //Listeners:
            findViewById(R.id.one).setOnClickListener(this);
            findViewById(R.id.two).setOnClickListener(this);
            findViewById(R.id.three).setOnClickListener(this);
            findViewById(R.id.four).setOnClickListener(this);
            findViewById(R.id.five).setOnClickListener(this);
            findViewById(R.id.six).setOnClickListener(this);
            findViewById(R.id.seven).setOnClickListener(this);
            findViewById(R.id.eight).setOnClickListener(this);
            findViewById(R.id.nine).setOnClickListener(this);
            findViewById(R.id.zero).setOnClickListener(this);
            findViewById(R.id.add).setOnClickListener(this);
            findViewById(R.id.rest).setOnClickListener(this);
            findViewById(R.id.multiply).setOnClickListener(this);
            findViewById(R.id.divide).setOnClickListener(this);
            findViewById(R.id.equal).setOnClickListener(this);
            findViewById(R.id.point).setOnClickListener(this);
            findViewById(R.id.ac).setOnClickListener(this);
            findViewById(R.id.c).setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
                try{
                    //We are using a switch to print depending on the button pressed by the user
                  switch (view.getId()){
                      case R.id.one:
                          b1="1";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b1);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.two:
                          b2="2";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b2);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.three:
                          b3="3";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b3);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.four:
                          b4="4";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b4);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.five:
                          b5="5";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b5);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.six:
                          b6="6";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b6);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.seven:
                          b7="7";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b7);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.eight:
                          b8="8";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b8);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.nine:
                          b9="9";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b9);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                      case R.id.zero:
                          b0="0";
                          if(!Validations.digitControl(counter)){
                              Operations.typePressedButtons(Operation,b0);
                              counter++;
                          }
                          noNumber2 = Validations.pointControl(usedOperand, noNumber2);
                          break;
                          //If the TextView is empty, we don't print the point.
                          //If there is a "0", then we print it
                          //We make sure the user does not type two points in one number, setting "used" to true
                          //If the user presses a number and an operand, and then he presses ".", we print a "0" and then a "."
                          //If the user already used the point, we don't print it again.
                          //If the user didn't press it before, we simply print it.

                      case R.id.point:
                         bpoint = ".";
                         nNumber2 = String.valueOf(number2);

                         if(!(Validations.digitControl(counter)) && !(Operation.getText().toString().equals(""))){

                             if(!used && Operation.getText().toString().equals("0")){

                                 used = true;
                                 Operation.setText(Operation.getText() + bpoint);

                             }else if(!used && operand != null && noNumber2 == true){

                                 String zero = "0";
                                 used = true;
                                 Operation.setText(Operation.getText() + zero + bpoint);
                                 number2 = 0;

                             }else if(!used){

                                 Operations.typePressedButtons(Operation, bpoint);
                                 used = true;

                             }else{
                                 Toast.makeText(this, "ERROR, A NUMBER CAN ONLY HAVE ONE POINT", Toast.LENGTH_LONG).show();
                             }
                         }

                         break;

                         //When the user presses "AC" we set all to 0 and false
                      case R.id.ac:

                          Operation.setText("0");
                          Result.setText("");
                          number1 = 0.0;
                          number2 = 0.0;
                          total = new BigDecimal(0);
                          counter = 0;
                          used = false;
                          usedOperand = false;

                          break;

                          //We make sure the user pressed a number before pressing "C" and
                          //we update the counter to keep it updated
                          //In case the TextView is empty, we set all to 0 and false
                      case R.id.c:
                          Operation.setText(Operations.delete(Operation.getText().toString()));

                          if(counter > 0){

                              counter = counter -1;

                          }else if(Operation.getText().toString().equals("")) {

                              Result.setText("");
                              number1 = 0.0;
                              number2 = 0.0;
                              total = new BigDecimal(0);
                              counter = 0;
                              used = false;
                              usedOperand = false;

                          }
                          break;

                          //If the TextView is null, we don't print the "="
                          //If the number2 == -1, means there's still no number2, so if
                          //the user types a number1 and operand, and then presses "=", we won't print it
                          //We check that in case operand is "/" and number2 = 0, we show the message "ERROR"
                          //Any other case, we print the total in "Result" TextView, and set all to 0 and false
                      case R.id.equal:

                          noNumber2 = false;

                          if(!(Operation.getText().toString().equals("") || operand == null)) {

                              number2 = Operations.catchNumber2(Operation, number2, operand);

                              if (number2 == -1) {

                              } else if (operand.equals("/") && number2 == 0.0) {

                                  Result.setText("ERROR");

                              } else {

                                  Result.setText(Operations.typeResult(Operation, number1, number2, total, operand));
                                  Operation.setText("0");
                                  number1 = 0.0;
                                  number2 = 0.0;
                                  total = new BigDecimal(0);
                                  counter = 0;
                                  used = false;
                                  usedOperand = false;
                                  noNumber2 = false;

                              }
                          }
                          break;
                          //If the "usedOperand" is true, it means the user already pressed an operand button,
                          //so we show him the message
                          //Then we set counter to 0 and point warner to false, so the user can use the point again
                          //Then we set "usedOperand" to true, so he cannot use it again
                      case R.id.add:
                          if(usedOperand){
                              Result.setText("1 OPERAND ALLOWED MAX");
                          }else{
                              operand = "+";
                              used = false;
                              counter = 0;
                              noNumber2 = true;
                              if(!Operation.getText().toString().isEmpty()){
                                  number1 = (Operations.typeOperands(Operation, operand, number1));
                                  usedOperand = true;
                              }
                          }
                          break;
                      case R.id.rest:
                          if(usedOperand){
                              Result.setText("1 OPERAND ALLOWED MAX");
                          }else{
                              operand = "-";
                              used = false;
                              counter = 0;
                              noNumber2 = true;
                              if(Operation.getText().toString().isEmpty()){
                                  number1 = (Operations.typeOperands(Operation, operand, number1));
                                  usedOperand = false;
                              }else{
                                  number1 = (Operations.typeOperands(Operation, operand, number1));
                                  usedOperand = true;
                              }
                          }
                          break;
                      case R.id.multiply:
                          if(usedOperand){
                              Result.setText("1 OPERAND ALLOWED MAX");
                          }else{
                              operand = "x";
                              used = false;
                              counter = 0;
                              noNumber2 = true;
                              if(!Operation.getText().toString().isEmpty()){
                                  number1 = (Operations.typeOperands(Operation, operand, number1));
                                  usedOperand = true;
                              }
                          }
                          break;
                      case R.id.divide:

                          if(usedOperand){
                              Result.setText("1 OPERAND ALLOWED MAX");
                          }else{
                              operand = "/";
                              used = false;
                              counter = 0;
                              noNumber2 = true;
                              if(!Operation.getText().toString().isEmpty()){
                                  number1 = (Operations.typeOperands(Operation, operand, number1));
                              }
                          }
                          break;
                  }








                }catch(Exception e){
                        Toast.makeText(this, "SOMETHING WENT WRONG",Toast.LENGTH_LONG).show();
                }

        }
}