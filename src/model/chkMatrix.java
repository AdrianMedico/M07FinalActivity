package model;

public class chkMatrix {

	/*
	 * Metodo para resolver el sudoku
	 */
	public static boolean solve(int i, int j, int[][] celdas) {
		if (i == 9) {
			i = 0;
			if (++j == 9)
				return true;
		}
		if (celdas[i][j] != 0) // skip filled cells
			return solve(i + 1, j, celdas);

		for (int val = 1; val <= 9; ++val) {
			if (legal(i, j, val, celdas)) {
				celdas[i][j] = val;
				if (solve(i + 1, j, celdas))
					return true;
			}
		}
		celdas[i][j] = 0; // reset en backtrack
		return false;
	}
/*
 * metodo para comprobar si la matriz es legal.
 */
	public static boolean legal(int i, int j, int val, int[][] celdas) {
		for (int k = 0; k < 9; ++k) // row
			if (val == celdas[k][j])
				return false;

		for (int k = 0; k < 9; ++k) // col
			if (val == celdas[i][k])
				return false;

		int boxRowOffset = (i / 3) * 3;
		int boxColOffset = (j / 3) * 3;
		for (int k = 0; k < 3; ++k) // box
			for (int m = 0; m < 3; ++m)
				if (val == celdas[boxRowOffset + k][boxColOffset + m])
					return false;

		return true; // no hay violaciones, es legal
	}
}
