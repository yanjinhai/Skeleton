import java.util.ArrayList;

/**
 *
 *
 * TODO features to implement (in no particular order):
 *  - ref & rref via Gaussian elimination
 *  - the ref & rref functions should not only output the final matrix, but also the steps taken to achieve it. This will be useful to display each step on screen, and could be used by the inverse function later.
 *  - Solving augmented matrices (in parametric form if there are any free variables)
 *  - Finding the span of a set of column vectors represented by a matrix
 *  - Checking the linear dependence of a set of column vectors represented by a matrix
 *  - Changing basis
 *  - Linear transformations (I don't know how yet though)
 *  - Null spaces
 *  - Finding the inverse of a matrix
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
    public boolean equals(Matrix other){
        return false;
    }

    // operation should be in the order of this * other, not other * this.
    public Matrix multiply(Matrix other) {
        if (columns != other.rows) {
            throw new java.lang.RuntimeException("Invalid matrix multiplication: the first matrix must have as many " +
                    "columns as the second matrix has rows.");
        }
        double[][] resultEntries = new double[rows][other.columns];
        for (int i = 0; i < other.columns; i++) { // for each column in other matrix (and resulting matrix)
            for (int j = 0; j < rows; j++) { // for each row in this matrix (and resulting matrix)
                // for each pair of entries from both matrices multiply and add up to form an entry in the resulting matrix
                for (int k = 0; k < columns; k++) {
                    resultEntries[j][i] += other.entries[k][i] * entries[j][k];
                }
            }
        }
        return new Matrix(resultEntries);
    }

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

    // The following three private functions are for internal gaussian multiplication.
    // They should all be modifying the 'this' object, AKA the instance of Matrix that called the function.
    // The instance that called the function should be a 'result' object used internally for other functions.
    // Not sure whether I should implement column operations at all, nor whether they should be public or private.
    // In fact, should these row operation functions be public after all? I might come back to this later.

    private Matrix scaleRow (int row, double factor) {
        return null;
    }

    private Matrix interchangeRow (int row1, int row2) {
        return null;
    }

    private Matrix replaceRow (int preservedRow, int replacedRow) {
        return null;
    }

    public Matrix inverse() {
        return null;
    }

    /**
     *
     * @return
     */
    public boolean isInvertible() {
        // One way of finding out whether a matrix is invertible is to find its determinant.
        // If the determinant is not zero, the matrix is invertible.
        return this.findDeterminant() != 0;
    }

    // TODO: implement finding the determinant of the matrix.
    public double findDeterminant() {
        // I can probably use ref() here to find the triangular form of the matrix.
        // Reminder: determinants are only defined for square matrices.
        // Would it ever be necessary to convert from a matrix transformation equation to a determinant equation by
        // taking the determinant of both sides? If so, would here be the best place to implement it?
        return 0;
    }
}
