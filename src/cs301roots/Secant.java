//Christopher Kilian
//CS 301 - Spring 2018
//Project 2 - Roots

package cs301roots;

import java.io.File;
import java.io.PrintWriter;

//Class implementing the Secant method
public class Secant {
    private final int NUMPREVIOUSVALS = 4; //number of previous f(x) values to check for divergence
    
    //Method to calculate the Secant root of a provided function. Inputs include the function being tested, the two initial
    //guess values "a" and "b", the maximum iterations allowed, the error percentage (represented as a value from 0 to 1) epsilon,
    //and the value "zeroThreshhold" which represents how close to 0 the f(x) value should be before being accepted as a root.
    //The function will run either until the relative error is less than the provided epsilon value and the absolute value of
    //f(x) is less than zeroThreshhold, or until the maximum number of iterations has been reached. The method may also quit
    //prematurely if it is detected to be divergent (ie the functional values are continually moving away from zero rather than towards it).
    public void runAlg(Function func, double a, double b, int nMax, double epsilon, double zeroThreshhold){
        double fOfA = func.theFunction(a);
        double fOfB = func.theFunction(b);
        double[] previousFuncVals = new double[NUMPREVIOUSVALS];
        double previousRelError = 0.0;
        StringBuilder plot = new StringBuilder(); //for use in plotting iterations vs relative error via CSV
        
        if(Math.abs(fOfA) > Math.abs(fOfB)){
            //swap previous and current functional vals
            double temp = fOfA;
            fOfA = fOfB;
            fOfB = temp;
            //swap previous and current X vals
            temp = a;
            a = b;
            b = temp;
        }
        
        //initial functional values to be tracked for divergence
        previousFuncVals[NUMPREVIOUSVALS-1] = fOfB;
        previousFuncVals[NUMPREVIOUSVALS-2] = fOfA;
        
        System.out.println("n = 0, x = " + a + ", f(x) = " + fOfA);
        System.out.println("n = 1, x = " + b + ", f(x) = " + fOfB);
        plot.append(0).append(",").append("null").append(",").append(a).append(",").append(fOfA).append("\n");
        plot.append(1).append(",").append("null").append(",").append(b).append(",").append(fOfB).append("\n");
        
        for(int n = 2; n <= nMax; n++){
            if(Math.abs(fOfA) > Math.abs(fOfB)){
                //swap previous and current functional vals
                double temp = fOfA;
                fOfA = fOfB;
                fOfB = temp;
                //swap previous and current X vals
                temp = a;
                a = b;
                b = temp;
            }

            double difference = (b - a) / (fOfB - fOfA);
            b = a;
            fOfB = fOfA;
            difference = difference * fOfA;
            a = a - difference;
            fOfA = func.theFunction(a);
            double relError = Math.abs((a-b)/a);
            plot.append(n).append(",").append(relError).append(",").append(a).append(",").append(fOfA).append("\n");
            System.out.println("n = " + n + ", x = " + a + ", f(x) = " + fOfA + ", relative error = " + relError);
            
            //Divergence check done here to stop iteration early if iterations are diverging significantly
            //from root - functional values gathered and checked
            if(n < NUMPREVIOUSVALS){
                previousFuncVals[NUMPREVIOUSVALS-(n+1)] = fOfA;
            }else{
                if(checkIfDiverging(previousFuncVals)){
                    System.out.println("Values are diverging - stopping iteration.");
                    break;
                }else{
                    updatePreviousVals(previousFuncVals, fOfA);
                }
            }
            
            if((relError < epsilon) && (Math.abs(fOfA) < zeroThreshhold)){
                System.out.println("Convergence achieved");
                break;
            }
        }
        
        outputResults(plot.toString(), "Secant Method Results.csv");
    }
    
    //Method used to check if iterations are diverging away from root - if 4 iterations in a row have increasing f(x) values,
    //then the iterations are declared as diverging and a "true" value is returned.
    private boolean checkIfDiverging(double[] previousVals){
        boolean diverging = false;
        int numDiverging = 0;
        
        //previousVals array is arranged with 0 element being most recent, and last element being least recent
        //Therefore if the difference between the absolute values of the i'th and (i+1)'th element is positive, then the values are diverging
        for(int i = 0; i < (previousVals.length - 1); i++){
            double diff = Math.abs(previousVals[i]) - Math.abs(previousVals[i+1]);
            if(diff > 0){
                numDiverging++;
            }
        }
        
        if(numDiverging >= (NUMPREVIOUSVALS - 1)){
            diverging = true;
        }
        
        return diverging;
    }
    
    //Method to update the previous values array by moving all values up one index value, and adding the newest value
    //at index 0.
    private void updatePreviousVals(double[] previousVals, double newVal){
        for(int i = (previousVals.length - 1); i > 0; i--){
            previousVals[i] = previousVals[i-1]; //shift values up array - ie previousVals[4] now holds previousVals[3], up to previousVals[1]
        }
        previousVals[0] = newVal;
    }
    
    //Method to output test results to a file. Used to generate CSV files.
    private void outputResults(String resultsString, String fileName){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File(fileName));
            StringBuilder output = new StringBuilder();
            output.append("Iteration,");
            output.append("Relative Error,");
            output.append("x,");
            output.append("f(x)");
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
