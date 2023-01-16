
//package vertexcover;

/**
 * Class to test the Vertex Cover algorithms
 */
public class TestVertexCover {

    /**
     * main function
     * @param args
     */
    public static void main(String args[]){
        /* First example */
        Graph g1 = new Graph(15);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(3, 5);
        g1.addEdge(1, 6);
        g1.addEdge(4, 5);
        g1.addEdge(1, 7);
        g1.addEdge(1, 8);
        g1.addEdge(2, 8);
        g1.addEdge(5, 9);
        g1.addEdge(4, 10);
        g1.addEdge(7, 10);
        g1.addEdge(3, 11);
        g1.addEdge(6, 11);
        g1.addEdge(1, 12);
        g1.addEdge(2, 13);
        g1.addEdge(5, 14);
        g1.addEdge(9, 14);
        g1.addEdge(10, 11);
        g1.addEdge(11, 12);
        g1.addEdge(4, 13);
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
        Graph g3 = new Graph(4);
        g3.addEdge(0, 3);
        g3.addEdge(1, 3);
        g3.addEdge(2, 3);
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
        Graph g4 = new Graph(5);
        g4.addEdge(0, 2);
        g4.addEdge(1, 4);
        g4.addEdge(2, 4);
        g4.addEdge(3, 4);
        System.out.println("\n-----Fourth example-----\n");
        VertexCover vc4 = new VertexCover(g4);
        measureElapsedTime(vc4, "o");
        measureElapsedTime(vc4, "a1");
        measureElapsedTime(vc4, "a2");
        measureElapsedTime(vc4, "a3");
        measureElapsedTime(vc4, "h1");
        measureElapsedTime(vc4, "h2");
        measureElapsedTime(vc4, "h3");
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

}
