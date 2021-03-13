/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomboane;

/**
 *
 * @author Rares
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Bomboane {

	static class Task {

		public static final String INPUT_FILE = "bomboane.in";
		public static final String OUTPUT_FILE = "bomboane.out";

		int n, m;
		int[][] a;
		int mod = 1000000007;

		private void readInput() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			String s;
			String[] s1;
			s = br.readLine();
			s1 = s.split(" ");
			n = Integer.parseInt(s1[0]);
			m = Integer.parseInt(s1[1]);
			a = new int[n + 1][m + 1];
			int i, j, k;
			int x, y;
			s = br.readLine();
			s1 = s.split(" ");
			x = Integer.parseInt(s1[0]);
			y = Integer.parseInt(s1[1]);
			for (i = x; i <= y; i++) {
				a[1][i] = 1;
			}
			for (i = 2; i <= n; i++) {
				s = br.readLine();
				s1 = s.split(" ");
				x = Integer.parseInt(s1[0]);
				y = Integer.parseInt(s1[1]);
				for (j = 1; j <= m; j++) {
					for (k = x; k <= y; k++) {
						if (j - k >= 0) {
							a[i][j] = a[i][j] + a[i - 1][j - k];
							a[i][j]=a[i][j]%mod;
						}
					}
				}

			}
			System.out.println(a[n][m]);

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

		public void solve() throws IOException {
			readInput();
			writeOutput(a[n][m]);
		}
	}

	public static void main(String[] args) throws IOException {
		new Task().solve();
	}

}
