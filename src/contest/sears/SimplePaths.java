package contest.sears;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kewl
 */
public class SimplePaths {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i, c);
        }
        for (int i = 0; i < m; i++) {
            int ai = in.nextInt();
            int bi = in.nextInt();
            int ci = in.nextInt();
            Edge edge = new Edge(ai, bi, ci);
            nodes[ai].list.add(edge);
            nodes[bi].list.add(edge);
        }

        int q = in.nextInt();
        while (q-- > 0) {
            boolean[] vis = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                nodes[i].color = new boolean[c + 1];
            }
            int from = in.nextInt();
            int to = in.nextInt();
            int start = from;
            int[] colors = new int[n + 1];
            colors[start] = 0;
            vis[start] = true;
            ArrayDeque<Integer> que = new ArrayDeque<>();
            que.add(start);
            while (!que.isEmpty()) {
                int curr = que.pollFirst();
                Iterator<Edge> it = nodes[curr].list.iterator();
                while (it.hasNext()) {
                    Edge temp = it.next();
                    if (!vis[temp.dest(curr)]) {
                        vis[temp.dest(curr)] = true;
                        nodes[temp.dest(curr)].addColor(nodes[curr].color);
                        nodes[temp.dest(curr)].color[temp.color] = true;
                        que.add(temp.dest(curr));
                    }
                }
                if (curr == to) {
                    break;
                }
            }
            System.out.println(Math.abs(nodes[to].getColor() - nodes[from].getColor()));
        }
    }

    static class Node {

        int val;
        boolean[] color;

        List<Edge> list = new ArrayList<>();

        Node(int val, int c) {
            this.val = val;
            color = new boolean[c + 1];
        }

        void addColor(boolean[] colors) {
            for (int i = 0; i < colors.length; i++) {
                color[i] = colors[i];
            }
        }

        int getColor() {
            int count = 0;
            for (int i = 1; i < color.length; i++) {
                if (color[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    static class Edge {

        int from, to, color;

        public Edge(int from, int to, int color) {
            this.from = from;
            this.to = to;
            this.color = color;
        }

        int dest(int source) {
            return source == from ? to : from;
        }
    }
}
