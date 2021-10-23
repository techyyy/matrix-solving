package com.java;


import java.util.Arrays;

class SeidelAlgorithm {

    public static double[] solve(double[][] A, double[] f) {
        double epsilon = 0.000001;
        double s;
        double sum;
        double delta;
        double[] x0 = {0, 0, 0, 0};
        double[] x1 = new double[4];
        do {
            for (int i = 0; i < 4; i++) {
                x1[i] = f[i];
                for (int j = 0; j < i - 1; j++) {
                    x1[i] -= A[i][j] * x1[j];
                }
                for (int j = i + 1; j < 4; j++) {
                    x1[i] -= A[i][j] * x0[j];
                }
                x1[i] /= A[i][i];
            }
            delta = 0;
            for (int i = 0; i < 4; i++) {
                delta += Math.abs(x1[i] - x0[i]);
                x0[i] = x1[i];
            }
            s = 0;
            for (int i = 0; i < 4; i++) {
                sum = f[i];
                for (int j = 0; j < 4; j++) {
                    sum -= A[i][j] * x1[j];
                }
                s += sum * sum;
            }
            s = Math.sqrt(s);
        } while (s > epsilon && delta > epsilon);
        return x1;
    }

    public static void main(String[] args) {
        double[][] A = {{500, 11, 11, -13},
                {-3, 500, 30, -20},
                {7, 1, 500, 10},
                {2, 7, -2, 500}};
        double[] f = {10, 10, 20, 15};
        System.out.println(Arrays.toString(solve(A, f)));
    }
}