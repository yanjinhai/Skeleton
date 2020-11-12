public class Main {

    public static void main(String[] args) {
        double[][] matrixEntries = new double[][]{{1,2,3},{4,5,6}};
//        Matrix matrix = new Matrix(matrixEntries);
        Matrix matrixA = Matrix.identity(3);
        Matrix matrixB = new Matrix(matrixEntries);
        Matrix matrixC = matrixB.multiply(matrixA);
	    System.out.println(matrixC);
    }
}
