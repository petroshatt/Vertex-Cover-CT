
//package vertexcover;

import java.util.*;

/**
 * Class that represents a graph
 */
public class Graph {

    /* number of vertices */
    private int V;

    /* a list of edges */
    private ArrayList<Edge> edges;

    /**
     * Constructor
     * @param V number of vertices
     */
    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList();
    }

    /**
     * Add an edge to the undirected graph
     * @param u start vertex
     * @param v end vertex
     */
    public void addEdge(int u, int v) {
        this.edges.add(new Edge(u, v));
    }

    /**
     * @return the number of vertices
     */
    public int getV(){
        return this.V;
    }

    /**
     * @return the list of edges
     */
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }


    public boolean edgeExists(int u, int v) {
        Edge e1 = new Edge(u, v);
        for(Edge e2 : this.edges)
            if(equalEdge(e1, e2))
                return true;
        return false;
    }

    public boolean equalEdge(Edge e1, Edge e2){
        if ((e1.getStartVertex() == e2.getStartVertex()) && (e1.getEndVertex() == e2.getEndVertex()))
            return true;
        return false;
    }
}
