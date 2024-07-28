package tinkoff.fintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task5 {
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

        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        int[] level = new int[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                level[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int proc = queue.poll();
            int curLevel = level[proc];

            if (levels.size() == curLevel) {
                levels.add(new ArrayList<>());
            }
            levels.get(curLevel).add(proc + 1);

            for (int dep : deps.get(proc)) {
                inDegree[dep]--;
                if (inDegree[dep] == 0) {
                    queue.offer(dep);
                    level[dep] = curLevel + 1;
                }
            }
        }

        System.out.println(levels.size());
        for (List<Integer> l : levels) {
            Collections.sort(l);
            System.out.print(l.size());
            for (int proc : l) {
                System.out.print(" " + proc);
            }
            System.out.println();
        }

        reader.close();
    }
}
