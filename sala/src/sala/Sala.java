/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Arrays;

/**
 *
 * @author Rares
 */
class Greutate {

	int kg;
	int rep;

	public Greutate(int x, int y) {
		this.kg = x;
		this.rep = y;
	}

}

public class Sala {

	static class Task {

		public final static String INPUT_FILE = "sala.in";
		public final static String OUTPUT_FILE = "sala.out";

		int n, m;
		Greutate[] v;

		public int computeFormula(Greutate w[]) {
			int i;
			int sum = 0;
			int min = w[0].kg;
			for (i = 0; i < m; i++) {
				sum = sum + w[i].rep;
				min = Math.min(min, w[i].kg);
			}
			return sum * min;
		}

		public int computeMax(Greutate w[], Greutate g) {
			int max = computeFormula(w);
			int fvalue;
			int i;
			int index = -1;
			Greutate aux;
			//Greutate[] rez=w;
			for (i = 0; i < m; i++) {
				aux = w[i];
				w[i] = g;
				fvalue = computeFormula(w);
				if (fvalue > max) {
					index = i;
					max = fvalue;
				}
				w[i] = aux;
			}

			return index;
		}

		private int readInput() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));

			String s;

			String[] s1;
			s = br.readLine();
			s1 = s.split(" ");
			n = Integer.parseInt(s1[0]);
			m = Integer.parseInt(s1[1]);
			v = new Greutate[m];
			Greutate g;
			//int max;
			int index;
			for (int i = 0; i < m; i++) {
				v[i] = new Greutate(Integer.MAX_VALUE, 0);
			}

			//v[0] = new T(-1, -1);
			for (int i = 0; i < n; i++) {
				s = br.readLine();
				s1 = s.split(" ");
				g = new Greutate(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
				index = computeMax(v, g);
				if (index != -1) {
					v[index] = g;
				}
				

			}
			//                   v[4]=new Greutate(1, 1);
			System.out.println(computeFormula(v));
				for (int k = 0; k < m; k++) {
					System.out.println(v[k].kg + " " + v[k].rep);
				}
				System.out.println();
			return computeFormula(v);
			//Arrays.sort(v, new Sort());
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
			/*int i, j;
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
			}*/
			writeOutput(readInput());
		}
	}

	public static void main(String[] args) throws IOException {
		new Task().solve();
	}

}
