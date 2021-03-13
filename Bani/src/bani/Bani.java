package bani;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Bani {

	static class Task {

		public static final String INPUT_FILE = "bani.in";
		public static final String OUTPUT_FILE = "bani.out";

		int n;
		int[][] r;
		int[][] a;
		int mod = 1000000007;
		int caz;

		private void readInput() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			String s;
			String[] s1;
			s = br.readLine();
			s1 = s.split(" ");
			caz = Integer.parseInt(s1[0]);
			n = Integer.parseInt(s1[1]);
			r = new int[6][6];
			int i, j;
			for (i = 1; i <= 5; i++) {
				for (j = 1; j <= 5; j++) {
					r[i][j] = 0;
				}
			}
			r[1][2] = 1;
			r[1][3] = 1;
			r[1][5] = 1;

			r[2][1] = 1;
			r[2][4] = 1;

			r[3][1] = 1;
			r[3][3] = 1;

			r[4][2] = 1;
			r[4][5] = 1;

			r[5][4] = 1;

			r[3][4] = 1;

		}

		private void writeOutput(int result) {
			try {
				PrintWriter pw = new PrintWriter(new File(OUTPUT_FILE));
				pw.printf("%d\n", result);
				pw.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public int caz1() {
			int i;
			int rez = 5;
			int inm = 1024 * 1024 * 1024;
			int n2 = (n - 1) / 30;
			for (i = 1; i <= n2; i++) {

				rez = (int) ((1L * rez * inm) % mod);
				rez = rez % mod;
			}
			for (i = 1; i <= (n - 1) % 30; i++) {

				rez = rez * 2;
				rez = rez % mod;
			}

			return rez;
		}

		public int caz2() {
			int i, j, x;
			int rez = 0;
			a = new int[n + 1][6];
			for (i = 1; i <= 5; i++) {
				a[1][i] = 1;
			}
			for (i = 1; i <= n; i++) {
				for (j = 1; j <= 5; j++) {
					for (x = 1; x <= 5; x++) {
						a[i][j] = a[i][j] + (int) (1L * (a[i - 1][x] % mod) * (r[j][x] % mod));
						a[i][j] = a[i][j] % mod;
					}
					if (a[i][j] < 0) {
						System.out.println(i);
					}
					a[i][j] = a[i][j] % mod;
				}
			}

			for (i = 1; i <= 5; i++) {
				rez = rez + a[n][i];
				rez = rez % mod;
			}
			return rez;
		}

		public void solve() throws IOException {
			readInput();
			if (caz == 1) {
				writeOutput(caz1());
			} else {
				writeOutput(caz2());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Task().solve();
	}

}
