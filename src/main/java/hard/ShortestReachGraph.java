package hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

class Solution {
    public static void algoritm(Map<Integer, Integer> nodeMaps, Integer start, Integer nodeNumbers){
        for (Integer key : nodeMaps.keySet()) {
            if (key == start) {
                System.out.printf("6");
            }
            if (nodeMaps.get(key) == nodeNumbers) {
                System.out.printf("6");
            } else {
                System.out.printf("-1");
            }
        }
        System.out.println("");
    }
}

public class ShortestReachGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Number of queries: ");
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i=0; i<q; i++){
            Map<Integer, Integer> nodesMap = new HashMap<>();
            Integer start = null;
            Integer nodeNumbers = null;

            System.out.println("Node numbers | Edges numbers: ");
            String readNumberNode = bufferedReader.readLine().trim();
            nodeNumbers = Integer.parseInt(readNumberNode.split(" ")[0]);
            int e = Integer.parseInt(readNumberNode.split(" ")[1]);

            for(int j=0; j<e; j++){
                System.out.println("Node n | Node m: ");
                String readNodeToNode = bufferedReader.readLine().trim();
                int nM = Integer.parseInt(readNodeToNode.split(" ")[0]);
                int nN = Integer.parseInt(readNodeToNode.split(" ")[1]);
                nodesMap.put(nM, nN);
            }
            System.out.println("Start Node: ");
            start = Integer.parseInt(bufferedReader.readLine().trim());

            Solution.algoritm(nodesMap, start, nodeNumbers);
        }

        bufferedReader.close();
    }
}

