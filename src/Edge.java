
//package vertexcover;

/**
 * Class that represents an edge in a graph
 */
public class Edge {

    /* the two vertices that form the edge */
    private int u, v;

    /**
     * Constructor
     * @param u start vertex
     * @param v end vertex
     */
    public Edge(int u, int v){
        this.u = u;
        this.v = v;
    }

    /**
     * @return the start vertex
     */
    public int getStartVertex(){
        return this.u;
    }

    /**
     * @return the end vertex
     */
    public int getEndVertex(){
        return this.v;
    }

    /**
     * print the edge
     */
    public void printEdge(){
        System.out.println("Start: " + this.u + " End: " + this.v);
    }

}
