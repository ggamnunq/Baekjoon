package beakjoon.BJ_17503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int period = Integer.parseInt(st.nextToken());
        int minPref = Integer.parseInt(st.nextToken());
        int kind = Integer.parseInt(st.nextToken());

        Queue<Integer> prefers = new PriorityQueue<>();
        List<Beer> beers = new ArrayList<>();

        for (int i = 0; i < kind; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            beers.add(new Beer(p, a));
        }

        beers.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o1.alcohol == o2.alcohol) {
                    return o2.prefer - o1.prefer;
                }
                return o1.alcohol - o2.alcohol;
            }
        });

        int total = 0;
        int answer = -1;

        for (Beer beer : beers) {
            prefers.add(beer.prefer);
            total += beer.prefer;

            if (prefers.size() > period) {
                int poll = prefers.poll();
                total -= poll;
            }
            if (prefers.size() == period && total >= minPref) {
                answer = beer.alcohol;
                break;
            }
        }
        System.out.println(answer);
    }

    public static class Beer {

        public int prefer, alcohol;

        public Beer(int prefer, int alcohol) {
            this.prefer = prefer;
            this.alcohol = alcohol;
        }


    }

}
