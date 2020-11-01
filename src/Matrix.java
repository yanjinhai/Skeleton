import java.util.ArrayList;

/**
 *
 *
 * TODO features to implement (in no particular order):
 *  - Matrix multiplication
 *  - ref & rref via Gaussian elimination
 *  - the ref & rref functions should not only output the final matrix, but also the steps taken to achieve it. This will be useful to display each step on screen, and could be used by the inverse function later.
 *  - Solving augmented matrices (in parametric form if there are any free variables)
 *  - Finding the span of a set of column vectors represented by a matrix
 *  - Checking the linear dependence of a set of column vectors represented by a matrix
 *  - Changing basis
 *  - Linear transformations (I don't know how yet though)
 *  - Allow for symbolic entries in addition to numeric ones (does the TI-nspire do this? What about Octave? SageMath?)
 *  - A lot more; keep reading the textbook. Might need to cover more material than the course does.
 *
 * @author jinhai
 */
public class Matrix {

    private final double[][] entries; // first index represents rows, second index represents columns
    private final int rows, columns;

    /**
     * Initializes a newly created Matrix.
     *
     * @param entries the contents of the Matrix object.
     */
    public Matrix(double[][] entries) {
        if(entries.length == 0 || entries[0].length == 0) {
            throw new java.lang.RuntimeException("Instances of class Matrix cannot have zero entries.");
        }
        this.entries = entries;
        rows = entries.length;
        columns = entries[0].length;
        for (int i = 0; i < rows; i++) {
            if (entries[i].length != columns) {
                throw new java.lang.RuntimeException("Instances of class Matrix must have the same number of entries in each row.");
            }
        }
    }

    /**
     *
     * @param rows
     * @param columns
     * @return
     */
    public static Matrix zero(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new java.lang.RuntimeException("Instances of class Matrix cannot have zero or fewer entries.");
        }
        double[][] entries = new double[rows][columns];
        return new Matrix(entries);
    }

    /**
     *
     * @param size
     * @return
     */
    public static Matrix identity(int size) {
        if (size < 1) {
            throw new java.lang.RuntimeException("Instances of class Matrix cannot have zero or fewer entries.");
        }
        double[][] entries = new double[size][size];
        for (int i = 0; i < size; i++) {
            entries[i][i] = 1;
        }
        return new Matrix(entries);
    }

    /**
     *
     * @return
     */
    public double[][] getEntries() {
        return entries;
    }

    /**
     *
     * @return
     */
    public int getRowCount() {
        return rows;
    }

    /**
     *
     * @return
     */
    public int getColumnCount() {
        return columns;
    }

    /**
     *
     * @return
     */
    public String toString() {
        int maxCharLength = findMaxCharLength();
        String formatted = "";
        for (int i = 0; i < rows; i++) {
            formatted += "{";
            for (int j = 0; j < columns; j++) {
                double currentEntry = entries[i][j];
                formatted += currentEntry;
                int spacing = 0;
                if (j < columns - 1) { // Skip the last column
                    spacing += 2; // minimum spacing between entries
                }
                int currentCharLength = charLength(currentEntry);
                spacing += maxCharLength - currentCharLength;
                for (int k = 0; k < spacing; k++) {
                    formatted += " ";
                }
            }
            formatted += "}\n";
        }
        return formatted;
    }

    // Used to help format the return value of Matrix.toString()
    private int findMaxCharLength() {
        int result = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int length = charLength(entries[i][j]);
                if (length > result) {
                    result = length;
                }
            }
        }
        return result;
    }

    // Used to help format the return value of Matrix.toString()
    private int charLength(double number) {
        String numberAsString = "" + number;
        return numberAsString.length();
    }

    // unsure whether this is needed
    public boolean equals(){
        return false;
    }

//    public Matrix multiply(Matrix other) {
//        Matrix result = new Matrix();
//        return result;
//    }

    public Matrix[] getColumnVectors(){
        return null;
    }

    public Matrix ref(){
        for (int i = 0; i < columns; i++) {
            ArrayList<Integer> nonZeroEntries = new ArrayList<Integer>(); // The rows with non-zero entries in column i.
            for (int j = 0; j < rows; j++) {
                if (entries[j][i] != 0) {
                    nonZeroEntries.add(j);
                }
            }
            //unfinished
            for (int n : nonZeroEntries) {

            }
        }
        return null;
    }

    // row operations
    // arrange the rows in triangular order

    public Matrix rref(){

        return null;
    }

    public Matrix inverse() {
        return null;
    }


}
