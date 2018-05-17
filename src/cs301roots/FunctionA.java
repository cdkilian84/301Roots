/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs301roots;

//Class to hold the first hard-coded function (function "a" from assignment specs)
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
    
}
