import java.util.ArrayList;

/**
 *
 *
 * TODO features to implement (in no particular order):
 *  - ref & rref via Gaussian elimination
 *  - the ref & rref functions should not only output the final matrix, but also the steps taken to achieve it. This will
 *  be useful to display each step on screen, and could be used by the inverse function later.
 *  - Solving augmented matrices (in parametric form if there are any free variables)
 *  - Finding the span of a set of column vectors represented by a matrix
 *  - Checking the linear dependence of a set of column vectors represented by a matrix
 *  - Changing basis
 *  - Linear transformations
 *  - Null spaces
 *  - Column spaces (they're just the span of the vector set represented by a matrix, why did people invent a new term?)
 *  - is one-to-one & is onto (is invertible plays a role in both)
 *  - range, domain, and codomain fo a linear transformation
 *  - rank (literally the number of pivot positions the ref of the matrix contains)
 *  - Finding the inverse of a matrix
 *  - Finding the transpose of a matrix
 *  - rearrange to upper/lower triangular
 *  - eigenvalues (via diagonalization, not determinants, because using determinants to find eigenvalues requires algebraic expressions as entries,
 *  which is outside the scope of this project)
 *  - eigenvectors
 *  - Finding whether a matrix is symmetric
 *  - the elementary row operations as matrix transformations (as an alternative to just visual changes) for showing all the steps this way
 *  - the determinants of the matrices in the matrix transformations representing the elementary row operations
 *  - Allow for symbolic entries in addition to numeric ones (does the TI-nspire do this? What about Octave? SageMath?)
 *  - Markov Chains
 *  - Stochastic matrices, probability vectors & steady-state vectors
 *  - Discrete dynamical systems (taking an initial vector, transition matrix, and number of iterations as constructor parameters; with a function to return the resulting vector after applying the transition matrix to the initial vector n times).
 *  - A lot more; keep reading the textbook. Might need to cover more material than the course does.
 *  - Textbook: http://merganser.math.gvsu.edu/david/linear.algebra/ula/ula/frontmatter.html
 *  - Consider how the UI should look. Should I use a GUI, TUI, CLI, or just read and write to a text file?
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

    /**
     * Matrix multiplication operations should be in the order of this * rightMatrix, not rightMatrix * this.
     *
     * @param rightMatrix
     * @return
     */
    public Matrix multiply(Matrix rightMatrix) {
        if (columns != rightMatrix.rows) {
            throw new java.lang.RuntimeException("Invalid matrix multiplication: the first matrix must have as many " +
                    "columns as the second matrix has rows.");
        }
        double[][] resultEntries = new double[rows][rightMatrix.columns];
        for (int i = 0; i < rightMatrix.columns; i++) { // for each column in other matrix (and resulting matrix)
            for (int j = 0; j < rows; j++) { // for each row in this matrix (and resulting matrix)
                // for each pair of entries from both matrices multiply and add up to form an entry in the resulting matrix
                for (int k = 0; k < columns; k++) {
                    resultEntries[j][i] += entries[j][k] * rightMatrix.entries[k][i];
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

    // The following three private functions are for internal Gaussian multiplication.
    // Not sure whether I should implement column operations at all, nor whether they should be public or private.
    // In fact, should these row operation functions be public after all? I might come back to this later.

    /**
     * This method is one of the three elementary row operations used in Gaussian elimination.
     *
     * @param row
     * @param factor
     * @return
     */
    private Matrix scaleRow (int row, double factor) {
        double[][] newEntries = entries.clone();
        for (int i = 0; i < newEntries[row].length; i++) {
            newEntries[row][i] *= factor;
        }
        return new Matrix(newEntries);
    }

    /**
     * This method is one of the three elementary row operations used in Gaussian elimination.
     *
     * @param row1
     * @param row2
     * @return
     */
    private Matrix interchangeRow (int row1, int row2) {
        double[][] newEntries = entries.clone();
        newEntries[row2] = entries[row1];
        newEntries[row1] = entries[row2];
        return new Matrix(newEntries);
    }

    /**
     * This method multiplies preservedRow by factor, then adds the product to replacedRow.
     * The resulting matrix is returned as a separate new object.
     *
     * This method is one of the three elementary row operations used in Gaussian elimination.
     *
     * @param preservedRow
     * @param factor
     * @param replacedRow
     * @return
     */
    private Matrix replaceRow (int preservedRow, double factor, int replacedRow) {//TODO: test this method; make sure it works
        double[][] newEntries = entries.clone();
        for (int i = 0; i < newEntries[preservedRow].length; i++) {
            newEntries[replacedRow][i] += newEntries[preservedRow][i] * factor;
        }
        return new Matrix(newEntries);
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

    // Cofactor expansion: a simple recursive method of finding the determinant of a square matrix of any size without
    // using gaussian elimination.
    public double findDeterminant() {
        // Determinants are only defined for square matrices.
        if (rows != columns) {
            throw new java.lang.RuntimeException("The determinant of a matrix without the same number of rows and columns is undefined.");
        }
        return findDeterminant(this);
    }

    // The actual recursive part.
    private double findDeterminant(Matrix matrix) {
        if (matrix.rows == 2) {
            double a = matrix.entries[0][0];
            double b = matrix.entries[0][1];
            double c = matrix.entries[1][0];
            double d = matrix.entries[1][1];
            return a*d-b*c;
        }
        double result = 0;
        for (int i = 0; i < matrix.columns; i++) { // cofactor expansion, but always using the top row for simplicity
            // generate new matrix
            double[][] nextEntries = new double[matrix.rows-1][matrix.columns-1];
            int jj = 0;
            for (int j = 1; j < matrix.rows; j++) {  // for each row (except the top row, since it's always the selected row for cofactor expansion)
                int kk = 0;
                for (int k = 0; k < matrix.columns; k++) { // for each entry in row j
                    if (k != i) { // ignore the entry if it's in the same column as the entry currently selected for cofactor expansion
                        nextEntries[jj][kk] = matrix.entries[j][k];
                        kk++;
                    }
                }
                jj++;
            }
            Matrix nextMatrix = new Matrix(nextEntries);
            double nextDeterminant = findDeterminant(nextMatrix);
            double negativityFactor = Math.pow(-1, i + 2); // +1 for the 1st row, +1 for the first column
            result += matrix.entries[0][i] * negativityFactor * nextDeterminant;
        }
        return result;
    }
}
