/*
Unsolved, here's the incorrect test:
1
17 35 17 35
*/

package yandex_trainings.first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(reader.readLine().split(" ")[0]);
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> read = new ArrayList<>();
            for (String stringNum : reader.readLine().split(" ")) {
                read.add(Integer.parseInt(stringNum));
            }

            int firstTime = read.get(0) * 60 + read.get(1);
            int secondTime = read.get(2) * 60 + read.get(3);

            events.add(new int[]{firstTime, -1, i + 1});
            if (firstTime != secondTime) {
                events.add(new int[]{secondTime, 1, i + 1});
            }
        }
        events.sort(Comparator.comparingInt(o -> o[0]));

        Set<Integer> opened = new HashSet<>();
        int openedNow = 0;
        int maxOpened = 0;

        for (int[] event : events) {
            if (event[1] == -1 && !opened.contains(event[2])) {
                opened.add(event[2]);
                openedNow++;
            } else if (event[1] == 1 && opened.contains(event[2])) {
                opened.remove(event[2]);
                openedNow--;
            }
            maxOpened = Math.max(openedNow, maxOpened);
        }
        for (int[] event : events) {
            if (event[1] == -1 && !opened.contains(event[2])) {
                opened.add(event[2]);
                openedNow++;
            } else if (event[1] == 1 && opened.contains(event[2])) {
                opened.remove(event[2]);
                openedNow--;
            }
            maxOpened = Math.max(openedNow, maxOpened);
        }

        if (maxOpened != n) {
            System.out.println(0);
            return;
        }

        opened.clear();
        openedNow = 0;
        int sum = 0;
        int openTime = -1;

        for (int[] event : events) {
            if (event[1] == -1 && !opened.contains(event[2])) {
                opened.add(event[2]);
                openedNow++;
            } else if (event[1] == 1 && opened.contains(event[2])) {
                opened.remove(event[2]);
                openedNow--;
            }
            maxOpened = Math.max(openedNow, maxOpened);
        }
        for (int[] event : events) {
            if (event[1] == -1 && !opened.contains(event[2])) {
                opened.add(event[2]);
                openedNow++;
            } else if (event[1] == 1 && opened.contains(event[2])) {
                opened.remove(event[2]);
                openedNow--;
            }

            if (openedNow == maxOpened) {
                openTime = event[0];
            } else if (openTime != -1) {
                if (event[0] > openTime) {
                    sum += event[0] - openTime;
                } else if (event[0] == openTime) {
                    sum += 1440;
                } else {
                    sum += 1440 - event[0] + openTime;
                }
                openTime = -1;
            }
        }

        System.out.println(sum);
        reader.close();
    }
}
