package beakjoon.range_1000.BJ_1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Lecture {

        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Lecture> queue = new PriorityQueue<>( ((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        }));

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Lecture(num, start, end));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);
        while (!queue.isEmpty()) {

            Lecture lecture = queue.poll();
            if (room.peek() <= lecture.start) {
                room.poll();
            }
            room.offer(lecture.end);
        }
        System.out.println(room.size());
    }

}
