package com.techbow.homework.y2021.m11.schoolHW.matrixchainmultiplication;

public class App {

    public static void main(String args[]){

        //Creating A1, A2, A3 & A4
        Matrix matrices[] = {
                new Matrix(15,3),
                new Matrix(3,7),
                new Matrix(7,27),
                new Matrix(27,10),
                new Matrix(10,5),
                new Matrix(5,60)};

        MatrixChain matrixChain = new MatrixChain(matrices);
        int multiplications = matrixChain.solve();

        //Printing 2D array (memoize table)
        for(int i=0; i<matrices.length; i++){

            for(int j=0; j<matrices.length; j++){

                System.out.print(matrixChain.matrixMulCount[i][j]+ "\t");
            }

            System.out.println();

        }

        System.out.println("Minimum multiplications required: "+multiplications);
    }
}
