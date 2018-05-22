//Christopher Kilian
//CS 301 - Spring 2018
//Project 2 - Roots

package cs301roots;

//Class to hold the first hard-coded function (function "a" from assignment specs)

import java.io.File;
import java.io.PrintWriter;

public class FunctionA implements Function{

    @Override
    //functionA returns the value of f(x) = 2x^3 - 11.7x^2 + 17.7x - 5
    public double theFunction(double x){
        
        double result = (2 * Math.pow(x, 3)) - (11.7 * Math.pow(x, 2)) + (17.7 * x) - 5;
        
        return result;
    }
    
    //returns the functional value of the derivative of f(x), f'(x) = 6x^2 - 23.4x + 17.7
    public double derivativeOfTheFunction(double x){
        
        double result = (6 * Math.pow(x, 2)) - (23.4 * x) + 17.7;
        
        return result;
    }
    
    //method to plot the function from a start to end X value.
    public void plotFunction(int startX, int endX){
        StringBuilder plot = new StringBuilder();
        for(int i = startX; i <= endX; i++){
            double yVal = theFunction(i);
            plot.append(i).append(",").append(yVal).append("\n");
        }
        
        outputResults(plot.toString(), "Function A Results.csv");
    }
    
    
    //method to plot the function from a start to end X value using quarter step values - for plotting points more precisely
    public void precisePlotFunction(double startX, double endX){
        StringBuilder plot = new StringBuilder();
        double counter = startX;
        while(counter < endX){
            double yVal = theFunction(counter);
            plot.append(counter).append(",").append(yVal).append("\n");
            counter += 0.25;
        }
        
        outputResults(plot.toString(), "Function A Results.csv");
    }
    
    
    //Method to output test results to a file. Used to generate CSV files.
    private void outputResults(String resultsString, String fileName){
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
