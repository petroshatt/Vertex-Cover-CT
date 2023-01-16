
//package vertexcover;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to test the Vertex Cover algorithms
 */
public class TestVertexCover {

    /**
     * main function
     * @param args
     */
    public static void main(String args[]) {

        Graph g1 = createRandomGraph(5);
        System.out.println("-----First example-----\n");
        VertexCover vc1 = new VertexCover(g1);
        measureElapsedTime(vc1, "o");
        measureElapsedTime(vc1, "a1");
        measureElapsedTime(vc1, "a2");
        measureElapsedTime(vc1, "a3");
        measureElapsedTime(vc1, "h1");
        measureElapsedTime(vc1, "h2");
        measureElapsedTime(vc1, "h3");

        /* Second example */
        Graph g2 = new Graph(2);
        System.out.println("\n-----Second example-----\n");
        VertexCover vc2 = new VertexCover(g2);
        measureElapsedTime(vc2, "o");
        measureElapsedTime(vc2, "a1");
        measureElapsedTime(vc2, "a2");
        measureElapsedTime(vc2, "a3");
        measureElapsedTime(vc2, "h1");
        measureElapsedTime(vc2, "h2");
        measureElapsedTime(vc2, "h3");

        /* Third example */
        Graph g3 = createRandomGraph(15);
        System.out.println("\n-----Third example-----\n");
        VertexCover vc3 = new VertexCover(g3);
        measureElapsedTime(vc3, "o");
        measureElapsedTime(vc3, "a1");
        measureElapsedTime(vc3, "a2");
        measureElapsedTime(vc3, "a3");
        measureElapsedTime(vc3, "h1");
        measureElapsedTime(vc3, "h2");
        measureElapsedTime(vc3, "h3");

        /* Fourth example */
        Graph g4 = createRandomGraph(20);
        System.out.println("\n-----Fourth example-----\n");
        VertexCover vc4 = new VertexCover(g4);
        measureElapsedTime(vc4, "o");
        measureElapsedTime(vc4, "a1");
        measureElapsedTime(vc4, "a2");
        measureElapsedTime(vc4, "a3");
        measureElapsedTime(vc4, "h1");
        measureElapsedTime(vc4, "h2");
        measureElapsedTime(vc4, "h3");

        /* Fifth example */
        Graph g5 = createRandomGraph(50);
        System.out.println("\n-----Fifth example-----\n");
        VertexCover vc5 = new VertexCover(g5);
        measureElapsedTime(vc5, "a1");
        measureElapsedTime(vc5, "a2");
        measureElapsedTime(vc5, "a3");
        measureElapsedTime(vc5, "h1");
        measureElapsedTime(vc5, "h2");
        measureElapsedTime(vc5, "h3");

        /* Sixth example */
        Graph g6 = createRandomGraph(80);
        System.out.println("\n-----Sixth example-----\n");
        VertexCover vc6 = new VertexCover(g6);
        measureElapsedTime(vc6, "a1");
        measureElapsedTime(vc6, "a2");
        measureElapsedTime(vc6, "a3");
        measureElapsedTime(vc6, "h1");
        measureElapsedTime(vc6, "h2");
        measureElapsedTime(vc6, "h3");

    }


    public static void measureElapsedTime(VertexCover v, String alg) {

        long start = System.nanoTime();

        if (alg.equals("o"))
            v.optimalVertexCover();
        else if (alg.equals("a1"))
            v.approximateVertexCover();
        else if (alg.equals("a2"))
            v.approximateRandomVertexCover();
        else if (alg.equals("a3"))
            v.approximateMaxDegreeVertexCover();
        else if (alg.equals("h1"))
            v.greedyVertexCover();
        else if (alg.equals("h2"))
            v.greedyMaxDegreeVertexCover();
        else if (alg.equals("h3"))
            v.heuristicMinDegreeVertex();

        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time Elapsed: " + timeElapsed + " ns\n");

    }

    public static Graph createRandomGraph (int vnum) {

        Graph g = new Graph(vnum);

        int maxEdgesForVertex = 5;

        /* makes sure each vertex is at least once in the graph */
        for (int edgS = 0; edgS < vnum; edgS++) {
            int vertexEdgesNum = ThreadLocalRandom.current().nextInt(1, maxEdgesForVertex + 1);
            boolean unlinkedVertex = true;
            while (unlinkedVertex) {
                for (int j = 0; j < vertexEdgesNum; j++) {
                    int edgE = ThreadLocalRandom.current().nextInt(0, vnum);
                    if ((edgS != edgE) && !g.edgeExists(edgS, edgE) && !g.edgeExists(edgE, edgS)) {
                        g.addEdge(edgS, edgE);
                        unlinkedVertex = false;
                    }
                }
            }
        }

        return g;

    }


}
