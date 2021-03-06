package _0000_study._graph._undirectedgraph.shortestpath;

import _0000_study._graph.graphrepresentation.WeightedGraph;
import _0000_study._graph.util.FilePrefix;

import java.util.Arrays;

/*
 * Dijkstra算法：单源最短路径，不能处理负权边
 * 算法步骤：
 * (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
 * (2) 确认这个节点的最短路就是当前大小（确定一个解）
 * (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
 * 时间复杂度：O(V^2) 其中V为图中节点个数
 */

public class Dijkstra {

    private WeightedGraph G;
    private int s;  // 源点
    private int[] dis;  // dis[i]存储从源点s到i的最短路径
    private boolean[] visited;  // 存储当前节点是否已经确定了最短路径

    public Dijkstra(WeightedGraph G, int s) {

        this.G = G;

        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);  // 初始化 源点s 到 任意点的距离都是无穷大
        dis[s] = 0;  // 源点s到源点s的最短路径为0

        visited = new boolean[G.V()];

        while (true) {
            // (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
            int cur = -1, curdis = Integer.MAX_VALUE;
            for (int v = 0; v < G.V(); v++)
                if (!visited[v] && dis[v] < curdis) {
                    curdis = dis[v];
                    cur = v;
                }

            if (cur == -1) break;  // 说明所有的点都已经找到了最短路径
            // (2) 确认这个节点的最短路就是当前大小（确定一个解）
            visited[cur] = true;
            // (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
            for (int w : G.adj(cur))
                if (!visited[w]) {
                    if (dis[cur] + G.getWeight(cur, w) < dis[w])
                        dis[w] = dis[cur] + G.getWeight(cur, w);
                }
        }
    }

    public boolean isConnectedTo(int v) {

        G.validateVertex(v);
        return visited[v];
    }

    public int distTo(int v) {

        G.validateVertex(v);
        return dis[v];
    }

    static public void main(String[] args) {
        String graphPath = FilePrefix.pathPrefix + "_undirectedgraph/shortestpath";
        WeightedGraph g = new WeightedGraph(graphPath + "/g.txt");

        Dijkstra dij = new Dijkstra(g, 0);
        for (int v = 0; v < g.V(); v++)
            System.out.print(dij.distTo(v) + " ");
        System.out.println();
    }
}
