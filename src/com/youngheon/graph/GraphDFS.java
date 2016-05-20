package com.youngheon.grape;

import java.util.Stack;

/**
 * Created by Young-heon on 2016. 5. 8..
 */
class Vertex {
    public char label;
    public boolean visited;

    public Vertex(char lab) {
        label = lab;
        visited = false;
    }

}

public class GraphDFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack theStack;

    public GraphDFS() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack();
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            //방문하지 않은 인접한 접점을 얻어와 스택 상단에 쌓는다
            int v = getAdjUniverstedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < vertexCount; j++) {
            vertexList[j].visited = false;
        }

    }

    public int getAdjUniverstedVertex(int v) {
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[v][j] == 1 && vertexList[j].visited == false)
                return j;
        }
        return -1;
    }


}

