import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Binod Bhandari on 9/8/17.
 */
public class DepthFirstSearch {

    private int vertices;
    private LinkedList<Integer> adj_list[];

    DepthFirstSearch(int v){
        vertices = v;
        adj_list = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj_list[i] = new LinkedList();
        }
    }

    void add_edge(int v, int w){
        adj_list[v].add(w);
    }

    void lookUp(int v, boolean visited_vertices[]){
        visited_vertices[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj_list[v].listIterator();
        while(i.hasNext()){
            int remaining_vertices = i.next();
            if(!visited_vertices[remaining_vertices]){
                lookUp(remaining_vertices, visited_vertices);
            }
        }
    }

    void DFS(int v){

        boolean visited_vertices[] = new boolean[vertices];
        lookUp(v, visited_vertices);
    }


    public static void main(String[] args){

        DepthFirstSearch graph = new DepthFirstSearch(5);
        graph.add_edge(1,3);
        graph.add_edge(0,1);
        graph.add_edge(2,0);
        graph.add_edge(3,2);
        graph.add_edge(4,1);
        graph.add_edge(3,1);
        graph.add_edge(1,4);
        graph.add_edge(2,2);


        graph.DFS(1);
    }
}
