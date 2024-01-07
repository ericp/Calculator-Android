package com.example.calculator;

import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operations {

    //Normally, we just type the numbers being pressed by the user.
    //If the users presses the 0 button first and keeps typing other numbers,
    //we delete the 0 number and then we type the next pressed numbers.
    public static void typePressedButtons(TextView Operation, String number) {

        try {
            if (Operation.getText().toString().equals("0")) {
                Operation.setText("");
                Operation.setText(number);

            }else{
                Operation.setText(Operation.getText() + number);
            }
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
        }

    }

    //We control the negative symbol telling three cases apart:
    //1.-If there was no numbers typed before, then we print the negative symbol
    //2.-If users presses 0 and then presses "-", then we print 0 -
    //3.-If there was already at least one number typed, then we just print the substract operand
    public static double typeOperands(TextView Operation, String operand, double number1) {
        try {
            if (Operation.getText().toString().equals("")) {
                if (operand.equals("-")) {
                    Operation.setText(operand);
                }
            } else if (Operation.getText().toString().equals("0")) {
                number1 = Double.parseDouble(Operation.getText().toString());
                Operation.setText(Operation.getText() + operand);
            } else {
                number1 = Double.parseDouble(Operation.getText().toString());
                Operation.setText(Operation.getText() + operand);
            }
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");

        }
        return number1;
    }

    //If the user doesn't press a second number, we set it equal to -1 and we don't catch it
    //if the user does, we catch it, turn it to Double and give it back

    public static double catchNumber2(TextView Operation, double number2, String operand){

        String text;
        String text2;

        try{

            text = Operation.getText().toString();
            text2 = text.substring(text.indexOf(operand) + 1, Operation.getText().toString().length());

            if(text2.equals("")){

                number2 = -1;

            }else{
                number2 = Double.parseDouble(text2);
            }

        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");

        }

        return number2;
    }


    //If the user presses "=" and the TextView is empty, or there's no number2 or operand, we don't print it
    //Otherwise, we check what is the operand and considering that, we operate

    public static String typeResult(TextView Operation, double number1, double number2, BigDecimal total, String operand){

        String result = null;
        String snumber1;
        String snumber2;

        try{
            snumber1 = String.valueOf(number1);
            snumber2 = String.valueOf(number2);


            if(Operation.getText().toString().equals("") || Operation.getText().toString().isEmpty()){

            }else if(snumber1 == "" || snumber2.isEmpty() || operand == null){

            }else{
                if(operand == "/"){

                    total = BigDecimal.valueOf(number1/number2);

                    result = (String.valueOf(total.setScale(5, RoundingMode.CEILING).stripTrailingZeros().toPlainString()));

                }else if(operand == "x"){

                    total = BigDecimal.valueOf(number1*number2);

                    result = (String.valueOf(total.setScale(5, RoundingMode.CEILING).stripTrailingZeros().toPlainString()));

                }else if(operand == "-"){

                    total = BigDecimal.valueOf(number1-number2);

                    result = (String.valueOf(total.setScale(5, RoundingMode.CEILING).stripTrailingZeros().toPlainString()));

                }else if(operand == "+"){

                    total = BigDecimal.valueOf(number1+number2);

                    result = (String.valueOf(total.setScale(5, RoundingMode.CEILING).stripTrailingZeros().toPlainString()));

                }
            }

        } catch (Exception e) {
        System.out.println("SOMETHING WENT WRONG");

        }
        return result;

    }



    //While the TextView is not empty, we delete the last digit of the TextView
    //when the user presses "C"

    public static String delete (String Operation) {

        String deleted = null;

        try{

            if(!Operation.equals("") || Operation.isEmpty()){
                deleted = (Operation.substring(0, Operation.length()-1));
            }

        }catch (Exception e){
        System.out.println("SOMETHING WENT WRONG");

        }

        return deleted;

    }
}
