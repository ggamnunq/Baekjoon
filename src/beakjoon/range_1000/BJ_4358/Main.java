package beakjoon.range_1000.BJ_4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        int sum=0;
        TreeMap<String,Integer> tree=new TreeMap<>();

        while((str=br.readLine())!=null){
            ++sum;
            if(!tree.containsKey(str)) tree.put(str,1);
            else tree.replace(str,tree.get(str)+1);
        }

        StringBuilder sb=new StringBuilder();

        for(String key:tree.keySet()){
            double rate=100.0*tree.get(key)/sum;
            sb.append(String.format("%str %.4f",key,rate)).append("\n");
        }

        System.out.print(sb);

    }

}
