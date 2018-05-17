/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs301roots;

/**
 *
 * @author Chris
 */
public class FalsePosition {
        
//    public void runAlg(Function func, double a, double b, int nMax, double epsilon){
//        double fOfA = func.theFunction(a);
//        double fOfB = func.theFunction(b);
//        double fOfC;
//        double error;
//        double c;
//        
//        if(((fOfA > 0) && (fOfB > 0)) || ((fOfA < 0) && (fOfB < 0))){
//            System.out.println("Function has same signs at a and b");
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("f(a) = " + fOfA);
//            System.out.println("f(b) = " + fOfB);
//        }else{
//            error = b - a;
//            for(int n = 0; n < nMax; n++){
//                error = error / 2;
//                c = ((a * fOfB) - (b * fOfA)) / (fOfB - fOfA);
//                fOfC = func.theFunction(c);
//                System.out.println("n = " + n + ", c = " + c + ", f(c) = " + fOfC + ", error = " + error);
//                
//                if(Math.abs(error) < epsilon){
//                    System.out.println("Convergence achieved");
//                    break;
//                }
//                
//                if(((fOfA > 0) && (fOfC < 0)) || ((fOfA < 0) && (fOfC > 0))){
//                    b = c;
//                    fOfB = fOfC;
//                }else{
//                    a = c;
//                    fOfA = fOfC;
//                }
//            }           
//        }
//    }
    
    public void runAlg(Function func, double a, double b, int nMax, double epsilon){
        double fOfA = func.theFunction(a);
        double fOfB = func.theFunction(b);
        double fOfC;
        double error;
        double c;
        
        //not from textbook
        double relativeError;
        double previousC = 0.0;
        
        if(((fOfA > 0) && (fOfB > 0)) || ((fOfA < 0) && (fOfB < 0))){
            System.out.println("Function has same signs at a and b");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("f(a) = " + fOfA);
            System.out.println("f(b) = " + fOfB);
        }else{
            error = b - a;
            for(int n = 0; n < nMax; n++){
                error = error / 2;
                c = ((a * fOfB) - (b * fOfA)) / (fOfB - fOfA);
                fOfC = func.theFunction(c);
                System.out.print("n = " + n + ", c = " + c + ", f(c) = " + fOfC + ", error = " + error);
                
                if(n > 0){
                    relativeError = (c - previousC) / c;
                    System.out.print(", relative error = " + Math.abs(relativeError) + "\n");
                    if(Math.abs(relativeError) < epsilon){
                        System.out.println("Convergence achieved");
                        break;
                    }
                }else{
                    System.out.print(", relative error = null\n");
                }
                
                if(((fOfA > 0) && (fOfC < 0)) || ((fOfA < 0) && (fOfC > 0))){
                    b = c;
                    fOfB = fOfC;
                }else{
                    a = c;
                    fOfA = fOfC;
                }
                previousC = c;
            }           
        }
    }
    
}
