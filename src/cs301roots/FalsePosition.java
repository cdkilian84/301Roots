//Christopher Kilian
//CS 301 - Spring 2018
//Project 2 - Roots

package cs301roots;

import java.io.File;
import java.io.PrintWriter;

//Class which implements the false position function (which is really bisection with a different choice for "c")
public class FalsePosition {
        
    //Method to calculate the false-positional root of a provided function. Inputs include the function being tested,
    //the initial bound "a" and "b", the maximum allowed iterations, and the epsilon value representing the sought after
    //error percentage (represented as a value from 0 to 1). The function will run either until the relative error is less than
    //the provided epsilon value, or until the maximum number of iterations has been reached.
    public void runAlg(Function func, double a, double b, int nMax, double epsilon){
        double fOfA = func.theFunction(a);
        double fOfB = func.theFunction(b);
        double fOfC;
        double error;
        double c;
        double relativeError;
        double previousC = 0.0; //track "previous" c value for use in calculating relative error
        StringBuilder plot = new StringBuilder(); //for use in plotting iterations vs relative error via CSV
        
        if(((fOfA > 0) && (fOfB > 0)) || ((fOfA < 0) && (fOfB < 0))){
            System.out.println("Function has same signs at a and b");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("f(a) = " + fOfA);
            System.out.println("f(b) = " + fOfB);
            System.out.println("No root can be found since a and b don't bracket it.");
        }else{
            error = b - a;
            for(int n = 0; n < nMax; n++){
                error = error / 2;
                c = ((a * fOfB) - (b * fOfA)) / (fOfB - fOfA); //main difference between false-position and basic bisectional method
                fOfC = func.theFunction(c);
                System.out.print("n = " + n + ", a = " + a + ", b = " + b + ", c = " + c + ", f(c) = " + fOfC);
                
                if(n > 0){
                    relativeError = Math.abs((c - previousC) / c);
                    System.out.print(", relative error = " + relativeError + "\n");
                    plot.append(n).append(",").append(relativeError).append(",")
                            .append(a).append(",").append(b).append(",").append(c).append(",").append(fOfA)
                            .append(",").append(fOfB).append(",").append(fOfC).append("\n");
                    if(relativeError < epsilon){
                        System.out.println("Convergence achieved");
                        break;
                    }
                }else{
                    System.out.print(", relative error = null\n");
                    plot.append(n).append(",").append("null").append(",")
                            .append(a).append(",").append(b).append(",").append(c).append(",").append(fOfA)
                            .append(",").append(fOfB).append(",").append(fOfC).append("\n");
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
            
            outputResults(plot.toString(), "False Position Results.csv");
        }
    }
    
    //Method to output test results to a file. Used to generate CSV files.
    private void outputResults(String resultsString, String fileName){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File(fileName));
            StringBuilder output = new StringBuilder();
            output.append("Iteration,");
            output.append("Relative Error,");
            output.append("a,");
            output.append("b,");
            output.append("c,");
            output.append("f(a),");
            output.append("f(b),");
            output.append("f(c)");
            output.append("\n");
            
            output.append(resultsString);
        
            pw.write(output.toString());
            pw.close();
        }catch(Exception e){
            System.out.println("PROBLEM OUTPUTTING VALUES");
            System.out.println(e.getMessage());
        }
    }
    
}
