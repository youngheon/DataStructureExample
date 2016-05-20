package com.youngheon.grape;

import java.util.Queue;

/**
 * Created by Young-heon on 2016. 5. 8..
 */


public class GraphBFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue theQueue;
    public GraphBFS(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int y=0; y<maxVertices; y++)
            for(int x=0; x<maxVertices; x++)
                adjMatrix[x][y] = 0;
        theQueue = new Queue();

    }
    public void addVertex(char lab){
        vertexList[vertexCount++] = new Vertex(lab);
    }
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while(!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisted = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for(int j=0; j<nVerts; j++){
            vertexList[j].wasVisited = false;

        }

    }
    public int getAdjUnvisitedVertex(int v){
        for(int j=0; j<vertexCount;j++){
            if(adjMatrix[v][j]==1 && vertexList[j].visited ==false)
                return j;
        }
        return -1;
    }



}
