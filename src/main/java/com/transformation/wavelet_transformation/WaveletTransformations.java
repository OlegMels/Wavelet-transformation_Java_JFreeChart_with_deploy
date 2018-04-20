/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transformation.wavelet_transformation;

/**
 *
 * @author Глеб
 */
public class WaveletTransformations {
        
    public static double f(double x) { if(delta == 0) return Math.sin(alpha * x);
                                       else return Math.cos(delta*Math.pow(x, q))+Math.sin(alpha * x);  }

    public static double psi1(double x) { return Math.exp(-Math.pow(x, 2) / (2 * Math.pow(sigma, 2))); }

    public static double psi2(double x) { return psi1(x) * Math.cos(beta * x); }

    public static double F(double a, double b) {
        double result = 0;

        double xk = -A;
        double h = 2 * A / Na;
        for (double k = 0; k < Na; ++k) {
            xk += h;
            result += f(xk) * psi1((xk - b)/a);
        }
        result /= 2 * A;
        return result;
    }
    
    public static double F1(double a, double b) {
        double result = 0;

        double xk = -A;
        double h = 2 * A / Na;
        for (double k = 0; k < Na; ++k) {
            xk += h;
            result += f(xk) * psi2((xk - b)/a);
        }
        result /= 2 * A;
        return result;
    }
    
    public static double FF(double a, double b) {
        double result = 0;

        double xk = -A;
        double h = 2 * A / Na;
        for (double k = 0; k < Na; ++k) {
            xk += h;
            result += f(xk) * psi2((xk - b)/a);
        }
        result /= 2 * A;
        return result;
    }
    
    protected static double A, B, C, alpha, beta, sigma, delta, q, Na, Nb, Nc, a, b;
    
}
