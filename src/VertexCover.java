
//package vertexcover;

import java.util.*;

/**
 * Class that includes algorithms for the solution of the Vertex Cover problem
 */
public class VertexCover {

    /* a graph */
    private Graph g;

    private Random randomGenerator;


    /**
     * Constructor
     * @param g graph
     */
    public VertexCover(Graph g){
        this.g = g;
    }


    /**
     * Function that finds the optimal vertex cover
     */
    public void optimalVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();
        /* number of vertices of the optimal cover */
        int numberOfVertices = this.g.getV() + 1;

        /* create a list of the vertices */
        ArrayList<Integer> vertices = new ArrayList();
        for(int i = 0; i < this.g.getV(); i++){
            vertices.add(i);
        }

        /* use boolean logic to create all combinations */
        long combinations = 1 << this.g.getV();
        for (int i = 0; i < combinations; i++) {
            ArrayList<Integer> comb = new ArrayList();
            for (int digit = 0; digit < this.g.getV(); digit++) {
                if ((i & (1 << digit)) > 0) {
                    comb.add(vertices.get(digit));
                }
            }
            /* check if combination is a cover and the optimal one until now */
            if(isCover(comb) && comb.size() < numberOfVertices){
                cover = comb;
                numberOfVertices = comb.size();
            }
        }

        /* print results */
        if(cover.isEmpty()){
            System.out.println("OPTIMAL\nNo cover found!");
        }
        else{
            System.out.print("OPTIMAL\nCover: ");
            Iterator<Integer> i;
            i = cover.iterator();
            while (i.hasNext())
            {
                System.out.print(i.next() + " ");
            }
            System.out.println();
        }
    }


    /**
     * Function that finds a 2-approximation vertex cover
     */
    void approximateVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();

        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* create a copy of the edges list */
        ArrayList<Edge> edgesCopy = new ArrayList<>(this.g.getEdges());

        /* remove all edges and check if the nodes should be inserted to the cover */
        while(!edgesCopy.isEmpty()){
            Edge e = edgesCopy.remove(0);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(!visited[u] && !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                cover.add(u);
                cover.add(v);
            }
        }

        /* mark the visited edges */
        for(int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(visited[u] || visited[v]) {
                visited[u] = true;
                visited[v] = true;
            }
        }

        /* print results */
        for (int j = 0; j < this.g.getV(); j++)
            if(visited[j] == false) {
                System.out.println("APPROXIMATE\nNo cover found!");
                return;
            }

        System.out.print("APPROXIMATE\nCover: ");
        Iterator<Integer> i;
        i = cover.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }


    /**
     * Function that finds a 2-approximation vertex cover
     * Random edge for each loop
     */
    void approximateRandomVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();

        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* create a copy of the edges list */
        ArrayList<Edge> edgesCopy = new ArrayList<>(this.g.getEdges());
        randomGenerator = new Random();

        /* remove all edges and check if the nodes should be inserted to the cover */
        while(!edgesCopy.isEmpty()){
            int randIndex = randomGenerator.nextInt(edgesCopy.size());
            Edge e = edgesCopy.remove(randIndex);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(!visited[u] && !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                cover.add(u);
                cover.add(v);
            }
        }

        /* mark the visited edges */
        for(int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(visited[u] || visited[v]) {
                visited[u] = true;
                visited[v] = true;
            }
        }

        /* print results */
        for (int j = 0; j < this.g.getV(); j++)
            if(visited[j] == false) {
                System.out.println("APPROXIMATE - RANDOM\nNo cover found!");
                return;
            }

        System.out.print("APPROXIMATE - RANDOM\nCover: ");
        Iterator<Integer> i;
        i = cover.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }


    /**
     * Function that finds a 2-approximation vertex cover
     * Edge removed each loop connects the highest degree vertex
     * In case of ties, randomly chosen between the highest
     */
    void approximateHighDegreeVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();

        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* create a copy of the edges list */
        ArrayList<Edge> edgesCopy = new ArrayList<>(this.g.getEdges());

        /* remove all edges and check if the nodes should be inserted to the cover */
        while (!edgesCopy.isEmpty()) {
            int chosenEdge = findEdgeMaxDegreeEdge(edgesCopy);
            Edge e = edgesCopy.remove(chosenEdge);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if (!visited[u] && !visited[v]) {
                visited[u] = true;
                visited[v] = true;
                cover.add(u);
                cover.add(v);
            }
        }

        /* mark the visited edges */
        for (int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if (visited[u] || visited[v]) {
                visited[u] = true;
                visited[v] = true;
            }
        }

        /* print results */
        for (int j = 0; j < this.g.getV(); j++)
            if (visited[j] == false) {
                System.out.println("APPROXIMATE - HIGHEST DEGREE VERTEX\nNo cover found!");
                return;
            }

        System.out.print("APPROXIMATE - HIGHEST DEGREE VERTEX\nCover: ");
        Iterator<Integer> i;
        i = cover.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

    }


    /**
     * Function that implements a greedy algorithm for the vertex cover
     */
    void greedyVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();

        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* create a copy of the edges list */
        ArrayList<Edge> edgesCopy = new ArrayList<>(this.g.getEdges());
        /* shuffle edges (probabilistic algorithm) */
        Collections.shuffle(edgesCopy);

        /* remove all edges and check if the nodes should be inserted to the
        cover
        */
        while(!edgesCopy.isEmpty()){
            Edge e = edgesCopy.remove(0);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(!visited[u] && !visited[v]) {
                /* select randomly one of the nodes */
                int r = (int)(Math.random() * 2);
                if(r == 1) {
                    visited[u] = true;
                    cover.add(u);
                }
                else {
                    visited[v] = true;
                    cover.add(v);
                }
            }
        }

        /* mark the visited edges */
        for(int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(visited[u] || visited[v]) {
                visited[u] = true;
                visited[v] = true;
            }
        }

        /* print results */
        for (int j = 0; j < this.g.getV(); j++)
            if(visited[j] == false) {
                System.out.println("GREEDY\nNo cover found!");
                return;
            }

        System.out.print("GREEDY\nCover: ");
        Collections.sort(cover);
        Iterator<Integer> i;
        i = cover.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }


    /**
     * Function that implements a greedy algorithm for the vertex cover
     * Edge removed each loop connects the highest degree vertex
     * In case of ties, randomly chosen between the highest
     */
    void greedyHighDegreeVertexCover() {
        /* variable to hold the cover */
        ArrayList<Integer> cover = new ArrayList();

        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* create a copy of the edges list */
        ArrayList<Edge> edgesCopy = new ArrayList<>(this.g.getEdges());
        /* shuffle edges (probabilistic algorithm) */
        Collections.shuffle(edgesCopy);

        /* remove all edges and check if the nodes should be inserted to the cover */
        while(!edgesCopy.isEmpty()){
            int chosenEdge = findEdgeMaxDegreeEdge(edgesCopy);
            Edge e = edgesCopy.remove(chosenEdge);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(!visited[u] && !visited[v]) {
                /* select randomly one of the nodes */
                int r = (int)(Math.random() * 2);
                if(r == 1) {
                    visited[u] = true;
                    cover.add(u);
                }
                else {
                    visited[v] = true;
                    cover.add(v);
                }
            }
        }

        /* mark the visited edges */
        for(int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            if(visited[u] || visited[v]) {
                visited[u] = true;
                visited[v] = true;
            }
        }

        /* print results */
        for (int j = 0; j < this.g.getV(); j++)
            if(visited[j] == false) {
                System.out.println("GREEDY - HIGHEST DEGREE VERTEX\nNo cover found!");
                return;
            }

        System.out.print("GREEDY - HIGHEST DEGREE VERTEX\nCover: ");
        Collections.sort(cover);
        Iterator<Integer> i;
        i = cover.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }


    void heuristicToBeNamed() {

        return;

    }


    /**
     * Function that checks if a set of vertices is a cover
     */
    public boolean isCover(ArrayList<Integer> comb){
        /* initialize all vertices as not visited */
        boolean visited[] = new boolean[this.g.getV()];
        for (int i = 0; i < this.g.getV(); i++)
            visited[i] = false;

        /* Consider all edges one by one */
        for (int i = 0; i < this.g.getEdges().size(); i++) {
            Edge e = this.g.getEdges().get(i);
            int u = e.getStartVertex();
            int v = e.getEndVertex();
            /* check if one of the vertices is in the set */
            if(comb.contains(u) || comb.contains(v)){
                visited[u] = true;
                visited[v] = true;
            }
            else{
                return false;
            }
        }

        /* check if all vertices were visited */
        for (int j = 0; j < this.g.getV(); j++)
            if(visited[j] == false)
                return false;

        return true;
    }


    /**
     * Function that finds the edge of the highest degree vertex
     * In case of ties, randomly chosen between the highest
     */
    public int findEdgeMaxDegreeEdge(ArrayList<Edge> edgesArr){

        randomGenerator = new Random();

        /* array storing degree for each vertex */
        int verticesDeg[] = new int[this.g.getV()];

        /* finding degree for each vertex */
        for (Edge edg : edgesArr) {
            verticesDeg[edg.getStartVertex()]++;
            verticesDeg[edg.getEndVertex()]++;
        }

        /* stores all possible vertices in case of tie */
        ArrayList<Integer> possibleVertices = new ArrayList<Integer>();

        /* finds the maximum degree vertices */
        int maxVertexDegree = -1;
        for(int k = 0; k < verticesDeg.length; k++){
            if (verticesDeg[k] > maxVertexDegree){
                maxVertexDegree = verticesDeg[k];
                possibleVertices.clear();
                possibleVertices.add(k);
            }
            else if (verticesDeg[k] == maxVertexDegree) {
                possibleVertices.add(k);
            }
        }

        /* randomly chosen vertex of the possible vertices */
        int randIndex = randomGenerator.nextInt(possibleVertices.size());
        int chosenVertex = possibleVertices.get(randIndex);

        /* stores all edges of the chosen vertex in case of tie */
        ArrayList<Edge> possibleEdges = new ArrayList<Edge>();

        /* finds edges of the chosen vertex */
        for(Edge edg : edgesArr) {
            if ((edg.getStartVertex() == chosenVertex) || (edg.getEndVertex() == chosenVertex))
                possibleEdges.add(edg);
        }

        /* randomly chosen edge of the possible vertices */
        randIndex = randomGenerator.nextInt(possibleEdges.size());
        Edge chosenEdge = possibleEdges.get(randIndex);

        /* converts edge to index of edgesArr, so it can be used at the main method */
        int chosenIndex = 0;
        for (int w = 0; w < edgesArr.size(); w++) {
            if ((edgesArr.get(w).getStartVertex() == chosenEdge.getStartVertex()) && (edgesArr.get(w).getEndVertex() == chosenEdge.getEndVertex()))
                chosenIndex = w;
        }

        return chosenIndex;

    }


}
