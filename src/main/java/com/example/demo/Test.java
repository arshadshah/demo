package com.example.demo;

public class Test {

    public static void main(String ar[]){
        double v1=20,v2=2;
        //for sum
        System.out.println("Sum of 2 values-"+v1+" and "+v2);
        Calculation calculation=new Test().getCalculationObject("SUM");
        System.out.println("Sum Output--"+calculation.doCalculation(v1,v2));

        //for substraction
        System.out.println("Substraction of 2 values-"+v1+" and "+v2);
        calculation=new Test().getCalculationObject("SUBSTRACTION");
        System.out.println("Substraction Output--"+calculation.doCalculation(v1,v2));

        //for multiplication
        System.out.println("Multiplication of 2 values-"+v1+" and "+v2);
        calculation=new Test().getCalculationObject("MULTIPLY");
        System.out.println("Multiplication Output--"+calculation.doCalculation(v1,v2));

        //for division
        System.out.println("Division of 2 values-"+v1+" and "+v2);
        calculation=new Test().getCalculationObject("DIVISION");
        System.out.println("Division Output--"+calculation.doCalculation(v1,v2));

    }

    public Calculation getCalculationObject(String calculationType){
       if(calculationType.equalsIgnoreCase("SUM")){
           return new SumCalculationImpl();
       }else if(calculationType.equalsIgnoreCase("SUBSTRACTION")){
           return new SubstractCalculationImpl();
       }
       else if(calculationType.equalsIgnoreCase("MULTIPLY")){
           return new MultiplyCalculationImpl();
       }else {
           return new DivideCalculationImpl();
       }
    }

    interface Calculation{
        double doCalculation(double v1,double v2);
    }

    class SumCalculationImpl implements Calculation{

        @Override
        public double doCalculation(double v1, double v2) {
            return (v1+v2);
        }
    }

    class MultiplyCalculationImpl implements Calculation{

        @Override
        public double doCalculation(double v1, double v2) {
            return (v1*v2);
        }
    }

    class SubstractCalculationImpl implements Calculation{

        @Override
        public double doCalculation(double v1, double v2) {
            return (v1-v2);
        }
    }

    class DivideCalculationImpl implements Calculation{

        @Override
        public double doCalculation(double v1, double v2) {
            return (v1/v2);
        }
    }
}


