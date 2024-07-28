package tinkoff.fintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        long[][] matrix = new long[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        long[] rowsSums = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowsSums[i] += matrix[i][j];
            }
        }

        long[] colsSums = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colsSums[i] += matrix[j][i];
            }
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(rowsSums[i] - colsSums[j]) <= matrix[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
        reader.close();
    }
}
