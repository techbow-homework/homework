package com.techbow.homework.y2021.m11.schoolHW.matrixchainmultiplication;

public class MatrixChain {
    int numberOfMatrices;
    Matrix matrices[];
    int matrixMulCount[][];

    public MatrixChain(Matrix[] matrices) {
        this.matrices = matrices;
        this.numberOfMatrices = matrices.length;
        matrixMulCount = new int[this.numberOfMatrices][this.numberOfMatrices];
    }

    //Solving matrix chain multiplication using dynamic programming
    public int solve(){

        for(int k=1; k<numberOfMatrices; k++){

            for(int i=0; i<numberOfMatrices; i++){

                if(i+k >= numberOfMatrices) break;

                //matrixMulCount[i][i+k]

                matrixMulCount[i][i+k] = matrixMulCount[i][i]
                        + matrixMulCount[i+1][i+k]
                        + matrices[i].row * matrices[i].col * matrices[i+k].col;

                for(int j=i+1; j<i+k; j++){

                    matrixMulCount[i][i+k]= Integer.min(matrixMulCount[i][i+k],
                            matrixMulCount[i][j] + matrixMulCount[j+1][i+k]
                                    +( j+1 == i+k ? ( matrices[i].row * matrices[i+k].row * matrices[i+k].col): (matrices[i].row * matrices[j].col * matrices[i+k].col)));

                }
            }
        }
        return matrixMulCount[0][numberOfMatrices-1];
    }
}
