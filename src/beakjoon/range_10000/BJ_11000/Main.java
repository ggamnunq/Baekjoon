package beakjoon.range_10000.BJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lecture {

    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> lectures = new PriorityQueue<>(((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        }));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures.offer(new Lecture(s, t));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        while (!lectures.isEmpty()) {

            Lecture lecture = lectures.poll();
            if (room.peek() <= lecture.start) {
                room.poll();
            }
            room.offer(lecture.end);
        }

        System.out.println(room.size());
    }

}
