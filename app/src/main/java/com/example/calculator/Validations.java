package com.example.calculator;

import java.io.IOException;

public class Validations {



    public static boolean digitControl(int counter){
        boolean validated = false;
        try{
            if(counter==6){
                validated= true;
            }
        }catch (Exception e){
            System.out.println("SOMETHING WENT WRONG");
        }
        return validated;
    }

    public static boolean pointControl(boolean usedOperand, boolean noNumber2){

        try{

            if(usedOperand){
                noNumber2=false;
            }else if(!usedOperand){
                noNumber2 = false;
            }

        }catch(Exception e){
            System.out.println("SOMETHING WENT WRONG");
        }

        return noNumber2;
    }

}
