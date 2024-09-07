/*
Unsolved, here's the incorrect test and correct answer:
10 3
12 13 17 0 5 14 6 7 16 4
2   3  2 1 3  4 4 1  1 2
*/

package yandex_trainings.first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./src/yandex_trainings/first/input.txt"));

        String[] read = reader.readLine().split(" ");
        int d = Integer.parseInt(read[1]);
        read = reader.readLine().split(" ");
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < read.length; i++) {
            int num = Integer.parseInt(read[i]);
            events.add(new int[]{num, -1, i});
            events.add(new int[]{num + d, 1, i});
        }
        events.sort((o1, o2) -> {
            int comparedFirst = Integer.compare(o1[0], o2[0]);
            int comparedSecond = Integer.compare(o1[1], o2[1]);

            if (comparedFirst == 0) {
                return comparedSecond;
            }

            return comparedFirst;
        });

        int spokenStudents = 0;
        int maxVariants = 0;
        for (int[] event : events) {
            if (event[1] == -1) {
                spokenStudents++;
            }
            maxVariants = Math.max(spokenStudents, maxVariants);
            if (event[1] == 1) {
                spokenStudents--;
            }
        }

        events.sort(Comparator.comparingInt(o -> o[2]));
        System.out.println(maxVariants);

        reader.close();
    }
}
