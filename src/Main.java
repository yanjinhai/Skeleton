public class Main {

    public static void main(String[] args) {
        double[][] matrixEntries = new double[][]{{4,2,0,4},{0,2,-1,0},{0,0,3,3},{0,4,0,7}};
//        Matrix matrix = new Matrix(matrixEntries);
//        Matrix matrixA = Matrix.identity(3);
        Matrix matrixB = new Matrix(matrixEntries);
//        Matrix matrixC = matrixB.multiply(matrixA);
//	    System.out.println(matrixC)
        System.out.println(matrixB.findDeterminant());
    }
}
