package intro.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NumIsland {
    private static final char LAND = '1';
    private static final char WATER = '0';
    private static final char FOUND_MARK = 'a';
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public static void main(String[] args) {
        char[][] case1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] case2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(case1));
        System.out.println(numIslands(case2));
    }


    /**
     * 解题步骤：
     * 1、找到陆地则 岛屿数 + 1
     * 2、将所有与该陆地相连接的陆地全部标记为 FOUND_MARK
     * 3、继续遍历下一个元素，如果是已被标记或者是水，则不作处理。如果是陆地，则跳转到步骤1
     */
    public static int numIslands(char[][] grid) {
        int landNum = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] grid_cols = grid[i];
            for (int j = 0; j < grid_cols.length; j++) {
                char e = grid_cols[j];
                if (e == LAND){
                    landNum ++;
                    grid_cols[j] = FOUND_MARK;
                    markJoinLands(i,j,grid);
                }
            }
        }
        return landNum;
    }

    /**
     * 将相连的陆地全部标记
     */
    private static void markJoinLands(int i, int j, char[][] grid) {
        int length_x = grid.length;
        int length_y = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] head = queue.poll();
            int x = head[0];
            int y = head[1];
            for (int[] direction : DIRECTIONS) {
                int x_n = x + direction[0];
                int y_n = y + direction[1];
                if (x_n <0 || x_n >= length_x || y_n < 0 || y_n >= length_y){
                    continue;
                }
                char e = grid[x_n][y_n];
                if (e == LAND){
                    grid[x_n][y_n] = FOUND_MARK;
                    queue.add(new int[]{x_n,y_n});
                }
            }
        }

    }
}
