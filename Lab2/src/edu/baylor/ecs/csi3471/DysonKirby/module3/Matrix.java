package edu.baylor.ecs.csi3471.DysonKirby.module3;

public class Matrix {
    int[][] matrix;
    int cols, rows;

    public Matrix(int width, int height) {
        cols = width;
        rows = height;
        matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = (int)(Math.random()*255);
            }
        }
    }

    public void add(Matrix m) throws Exception{
        if(cols != m.cols || rows != m.rows){
            throw new Exception("Operation cannot occur");
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] += m.matrix[i][j];
            }
        }
    }

    public void subtract(Matrix m) throws Exception{
        if(cols != m.cols || rows != m.rows){
            throw new Exception("Operation cannot occur");
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] -= m.matrix[i][j];
            }
        }
    }

    public void multiply(Matrix m) throws Exception {
        if(cols != m.rows || rows != m.cols){
            throw new Exception("Operation cannot occur");
        }
        int[][] result = new int[rows][m.cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < m.cols; j++){
                for (int k = 0; k < cols; k++) {
                    result[i][j] += matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        matrix = result;
        rows = m.rows;
    }

    public void print(){
        for(int i = 0; i < rows; i++){
            System.out.print("[");
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j]);
                if(j  < cols - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try{
            Matrix m1 = new Matrix(3, 2);
            Matrix m2 = new Matrix(3, 2);
            System.out.println("Matrix 1:");
            m1.print();
            System.out.println();
            System.out.println("Matrix 2:");
            m2.print();
            m1.add(m2);
            System.out.println();
            System.out.println("Added Matrices:");
            m1.print();
            System.out.println();

            Matrix m3 = new Matrix(3, 2);
            Matrix m4 = new Matrix(3, 2);
            System.out.println("Matrix 3:");
            m3.print();
            System.out.println();
            System.out.println("Matrix 4:");
            m4.print();
            System.out.println();
            System.out.println("Subtracted Matrices:");
            m3.subtract(m4);
            m3.print();
            System.out.println();

            Matrix m5 = new Matrix(2, 3);
            Matrix m6 = new Matrix(3, 2);
            System.out.println("Matrix 5:");
            m5.print();
            System.out.println();
            System.out.println("Matrix 6:");
            m6.print();
            m5.multiply(m6);
            System.out.println();
            System.out.println("Multiplied Matrices:");
            m5.print();
        } catch(Exception excp){
            System.out.println(excp.getMessage());
        }
    }
}