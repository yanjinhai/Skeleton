public class Main {

    public static void main(String[] args) {
        double[][] matrixEntries = new double[][]{{.9,.5,1},{.07,0,0},{.03,.5,0}};
        Matrix matrix = new Matrix(matrixEntries);
//        Matrix matrixA = Matrix.identity(3);
//        Matrix matrixB = new Matrix();

        Matrix vect = new Matrix(new double[][] {{1},{0},{0}});

        for (int i = 1; i <= 10; i++) {
            vect = matrix.multiply(vect);
            System.out.println("iteration " + i + "\n" + vect + "\n");
        }

//        Matrix matrixC = matrixB.multiply(matrixA);
//	    System.out.println(matrixB.inverse());
//        Matrix matrixD = new Matrix(new double[][]{{20},{50}});
//        Matrix matrixE = new Matrix(new double[][]{{50},{20}});
//        System.out.println(matrixB.multiply(matrixD));
//        System.out.println("--------------------------------------------");
//        System.out.println(matrixB.multiply(matrixE));
    }
}
