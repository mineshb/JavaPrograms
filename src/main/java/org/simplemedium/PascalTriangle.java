package org.simplemedium;

/**
7. Print Pascal Triangle , print the value for the given co-orinates
Ex:
1
1 1
1 2 1
1 3 3 1"
 Given  Co-Orinates(3,2) means answer should be : 2
 */
public class PascalTriangle {

    public static void main(String[] args) {

        System.out.println("Result = " + findValueForCoordinate(3,2));
    }

    private static int findValueForCoordinate(int x, int y) {
        int result = 0;
        int pascalVal = 0;
        for(int row=0; row<5; row++) {
            for(int col=0; col<= row; col++) {
                pascalVal = getPascalVal(row, col);
                System.out.print(pascalVal + " ");
                if(row+1 == x && col+1 == y)
                    result = pascalVal;
            }
            System.out.println();
        }

        return result;
    }
    
    public static int getPascalVal(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        return getPascalVal(row-1, col-1) + getPascalVal(row-1, col);
    }
}

