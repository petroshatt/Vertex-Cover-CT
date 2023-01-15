
//package vertexcover;

/**
 * Class to test the Vertex Cover algorithms
 * @author ploskasn
 */
public class TestVertexCover {

    /**
     * main function
     * @param args
     */
    public static void main(String args[]){
        /* First example */
        Graph g1 = new Graph(7);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(3, 5);
        g1.addEdge(1, 6);
        g1.addEdge(4, 5);

        System.out.println("-----First example-----\n");
        VertexCover vc1 = new VertexCover(g1);
        measureElapsedTime(vc1, "o");
        measureElapsedTime(vc1, "a1");
        measureElapsedTime(vc1, "a2");
        measureElapsedTime(vc1, "a3");
        measureElapsedTime(vc1, "h1");
        measureElapsedTime(vc1, "h2");

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
            v.approximateHighDegreeVertexCover();
        else if (alg.equals("h1"))
            v.greedyVertexCover();
        else if (alg.equals("h2"))
            v.greedyHighDegreeVertexCover();
//        else if (alg.equals("h3"))
//            v.approximateHighDegreeVertexCover();

        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time Elapsed: " + timeElapsed + " ns\n");

    }

}
