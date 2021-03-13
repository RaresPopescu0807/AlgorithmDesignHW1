package gard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

class T {

	int x;
	int y;

	public T(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

class Sort implements Comparator<T> {

	@Override
	public int compare(T a, T b) {
		if (a.x != b.x) {
			return a.x - b.x;
		} else {
			return b.y - a.y;
		}

	}
}

public class Gard {

	static class Task {

		public final static String INPUT_FILE = "gard.in";
		public final static String OUTPUT_FILE = "gard.out";

		int n;
		T[] v;

		private void readInput() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
			n = Integer.parseInt(br.readLine());
			String s;
			v = new T[n + 1];
			String[] s1;

			v[0] = new T(-1, -1);
			for (int i = 1; i <= n; i++) {
				s = br.readLine();
				s1 = s.split(" ");

				v[i] = new T(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
			}
			Arrays.sort(v, new Sort());
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
			int i, j;
			int aux;
			int r = 0;
			for (i = 1; i <= n - 1; i++) {
				aux = 0;
				for (j = i + 1; j <= n; j++) {
					if (v[j].y > v[i].y) {
						break;
					}
					aux++;
				}
				i = i + aux;
				r = r + aux;
			}
			writeOutput(r);
		}
	}

	public static void main(String[] args) throws IOException {
		new Task().solve();
	}

}
