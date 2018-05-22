//Christopher Kilian
//CS 301 - Spring 2018
//Project 2 - Roots

package cs301roots;

//Class to hold the second hard-coded function (function "b" from assignment specs)

import java.io.File;
import java.io.PrintWriter;

public class FunctionB implements Function{
    
    @Override
    //functionA returns the value of f(x) = x + 10 - x * cosh(50 / x)
    public double theFunction(double x){
        
        double result = x + 10.0 - (x * Math.cosh(50.0/x));
        
        return result;
    }
    
    //returns the functional value of the derivative of f(x), f'(x) = ((50 * sinh(50 / x)) / x) - cosh(50 / x) + 1
    public double derivativeOfTheFunction(double x){
        
        double result = ((50.0 * Math.sinh(50.0 / x)) / x) - Math.cosh(50.0 / x) + 1.0;
        
        return result;
    }
    
    //method to plot the function from a start to end X value.
    public void plotFunction(int startX, int endX){
        StringBuilder plot = new StringBuilder();
        for(int i = startX; i <= endX; i++){
            double yVal = theFunction(i);
            plot.append(i).append(",").append(yVal).append("\n");
        }
        
        outputResults(plot.toString(), "Function B Results.csv");
    }
    
    
    //Method to output test results to a file. Used to generate CSV files.
    public void outputResults(String resultsString, String fileName){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File(fileName));
            StringBuilder output = new StringBuilder();
            output.append("X,");
            output.append("Y,");
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
