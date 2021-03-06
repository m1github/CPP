import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr,0,0,"");
    }

    public static void floodfill(int[][] maze, int sr, int sc, String asf) {
        if(sr==maze.length-1 && sc == maze[0].length-1){
            System.out.println(asf);
            return;
        }
        int rdir[] = {-1,0,1,0};
        int cdir[] = {0,-1,0,1};
        char dirArr[] = {'t','l','d','r'};
        //mark
        maze[sr][sc] = 1;
        for(int d=0; d<rdir.length; d++){
            int rr = sr + rdir[d];
            int cc = sc + cdir[d];
            if(rr >= 0 && rr<maze.length && cc >= 0 && cc<maze[0].length && maze[rr][cc] != 1){
                char dir = dirArr[d];
                floodfill(maze, rr, cc, asf+dir);
            }
        }
        //unmark
        maze[sr][sc] = 0;
    }
}