/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs301roots;

//simple interface demanding that all "functions" must implement a method which accepts a double and returns another double
public interface Function {    
    public double theFunction(double x);
    public double derivativeOfTheFunction(double x);
}
