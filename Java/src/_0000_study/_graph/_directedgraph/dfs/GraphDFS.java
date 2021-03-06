package _0000_study._graph._directedgraph.dfs;

import _0000_study._graph.graphrepresentation.Graph;
import _0000_study._graph.util.FilePrefix;

import java.util.ArrayList;

public class GraphDFS {
    // 有向无权图DFS
    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                dfs(v);
    }

    private void dfs(int v){

        visited[v] = true;
        pre.add(v);
        for(int w: G.adj(v))
            if(!visited[w])
                dfs(w);
        post.add(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args){
        String graphPath = FilePrefix.pathPrefix + "_directedgraph/dfs";
        Graph g = new Graph(graphPath + "/ug.txt", true);
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println("DFS preOrder : " + graphDFS.pre());
        System.out.println("DFS postOrder : " + graphDFS.post());
    }
}
