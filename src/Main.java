public class Main {

    public static void main(String[] args) {
        double[][] matrixEntries = new double[][]{{9,1,1},{1,0,3},{2,0,0}};
//        Matrix matrix = new Matrix(matrixEntries);
//        Matrix matrixA = Matrix.identity(3);
        Matrix matrixB = new Matrix(matrixEntries);
//        Matrix matrixC = matrixB.multiply(matrixA);
	    System.out.println(matrixB.inverse());
//        Matrix matrixD = new Matrix(new double[][]{{20},{50}});
//        Matrix matrixE = new Matrix(new double[][]{{50},{20}});
//        System.out.println(matrixB.multiply(matrixD));
//        System.out.println("--------------------------------------------");
//        System.out.println(matrixB.multiply(matrixE));
    }
}
