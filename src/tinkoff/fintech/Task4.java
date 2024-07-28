package tinkoff.fintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> deps = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            deps.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            int m = Integer.parseInt(row[0]);

            for (int j = 0; j < m; j++) {
                deps.get(Integer.parseInt(row[j + 1]) - 1).add(i);
                inDegree[i]++;
            }
        }

        int[] levels = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                levels[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int proc = queue.poll();
            for (int dep : deps.get(proc)) {
                inDegree[dep]--;
                if (inDegree[dep] == 0) {
                    queue.offer(dep);
                    levels[dep] = levels[proc] + 1;
                }
            }
        }

        System.out.println(levels[0]);
        reader.close();
    }
}
