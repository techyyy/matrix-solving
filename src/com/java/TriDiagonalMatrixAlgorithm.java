package com.java;

public class TriDiagonalMatrixAlgorithm {

    public static double[] solve(double[] a, double[] b, double[] c, double[] d) {
        int n = d.length;
        double temp;
        c[0] /= b[0];
        d[0] /= b[0];
        for (int i = 1; i < n; i++) {
            temp = 1.0 / (b[i] - c[i - 1] * a[i]);
            c[i] *= temp;
            d[i] = (d[i] - d[i - 1] * a[i]) * temp;
        }
        double[] x = new double[n];
        x[n - 1] = d[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            x[i] = d[i] - c[i] * x[i + 1];
        }
        return x;
    }

    /*
        For matrix:

        | 2 3 0 0 | x |x_1| = |21|
        | 6 3 9 0 |   |x_2|   |69|
        | 0 2 5 2 |   |x_3|   |34|
        | 0 0 4 3 |   |x_4|   |22|

        Expected output:
        x_1= 3
        x_2= 5
        x_3= 4
        x_4= 2
     */

    public static void main(String[] args) {
        double[] a = {0, 6, 2, 4};
        double[] b = {2, 3, 5 ,3};
        double[] c = {3, 9, 2, 0};
        double[] d = {21, 69, 34, 22};
        for (double element : solve(a,b,c,d)) {
            System.out.print(element + " ");
        }
    }
}
