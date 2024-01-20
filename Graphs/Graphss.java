import java.util.*;

class Pair {
    int vtx;
    int parent;

    public Pair(int vtx, int parent) {
        this.vtx = vtx;
        this.parent = parent;
    }
}

public class Graphss {

    public static void main(String[] args) {

        // int n = 7;
        // ArrayList<Integer>[] graph = new ArrayList[n];

        // for (int i = 0; i < n; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // graph[0].add(1);
        // graph[1].add(0);

        // graph[0].add(2);

        // graph[2].add(3);
        // graph[3].add(2);

        // graph[3].add(4);
        // graph[4].add(3);

        // graph[5].add(6);
        // graph[6].add(5);

        // boolean[] visited = new boolean[graph.length];
        // boolean ans = false;

        // for (int i = 0; i < visited.length; i++) {
        // if (!visited[i]) {
        // //for all the components
        // if(isCyclic(graph,i,visited,-1)){
        // ans = true;
        // break;
        // }
        // }
        // }
        // System.out.println(ans);

        // int[] arr = { 2, 4, 5, 1, 3, 6, 0 };
        // System.out.println(minSwaps(arr));

        int[][] arr = {{2,3,4,3,1},{4,2,2,2,1},{1,2,2,2,1},{5,2,2,2,1},{6,7,8,1,0}};
        colorBorder(arr,1,1,3);
        for(int i =0 ; i< arr.length; i++){
            for(int j =0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean isCyclic(ArrayList<Integer>[] graph, int src, boolean[] visited, int parent) {
        if (visited[src] == true) {
            return true;
        }

        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                isCyclic(graph, nbr, visited, src);
                return true;
            }
        }
        return false;
    }

    public static int minSwaps(int[] arr) {
        int ans = 0;
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int j = i;
                int len = 1;

                while (arr[j] != i) {
                    j = arr[j];
                    visited[j] = true;
                    len++;
                }
                ans += (len - 1);
            }
        }
        return ans;
    }

    public static int[][] colorBorder(int[][] arr, int row , int col, int color){
        int oc = arr[row][col];
        dfs(arr,row,col,oc);
        for(int i =0; i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                if(arr[i][j] < 0){
                    arr[i][j] = color;
                }
            }
        }
        return arr;
    }
    public static void dfs(int[][] arr, int r, int c, int oc) {
        if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] != oc) {
            return;
        }
        arr[r][c] = -oc;

        // top
        dfs(arr, r - 1, c, oc);
        // left
        dfs(arr, r, c - 1, oc);
        // down
        dfs(arr, r + 1, c, oc);
        // right
        dfs(arr, r, c + 1, oc);

        if (r - 1 >= 0 && c - 1 >= 0 && r + 1 < arr.length && c + 1 < arr[0].length &&
                Math.abs(arr[r - 1][c]) == oc &&
                Math.abs(arr[r + 1][c]) == oc &&
                Math.abs(arr[r][c - 1]) == oc &&
                Math.abs(arr[r][c + 1]) == oc
        // this element arr[r][c] is not a boundary element
        ) {
            arr[r][c] = oc;

        }

    }
}
