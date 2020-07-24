package intro.queue;


import java.util.*;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 示例：
 *
 * 给定二维网格：
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * 运行完你的函数后，该网格应该变成：
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 *   答题思路：
 *   https://leetcode-cn.com/problems/walls-and-gates/solution/qiang-yu-men-by-leetcode/
 *   主要思路：从 门 作为出发点广度优先遍历
 */
public class WallAndDoor {

    public static final int INF = 2147483647;
    public static final int DOOR = 0;
    public static final int WALL = -1;

    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public static void main(String[] args) {
        int[][] rooms = {{INF, WALL, DOOR, INF}, {INF, INF, INF, WALL}, {INF, WALL, INF, WALL}, {DOOR, WALL, INF, INF}};
        wallsAndGates(rooms);
        print(rooms);
    }

    private static void print(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            int[] room = rooms[i];
            for (int j = 0; j < room.length; j++) {
                System.out.print(room[j]+",");
            }
            System.out.println("");
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        int xlength = rooms.length;
        if (xlength == 0){
            return;
        }
        int ylength = rooms[0].length;
        Queue<int[]> queue = new LinkedList();


        for (int i = 0; i < rooms.length; i++) {
            int[] room = rooms[i];
            for (int j = 0; j < room.length; j++) {
                if (rooms[i][j] == DOOR){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] head = queue.poll();
            int x = head[0];
            int y = head[1];
            for (int[] direction : DIRECTIONS) {
                int x_n = x+direction[0];
                int y_n = y+direction[1];
                if (x_n <0 || x_n >= xlength || y_n < 0 || y_n >= ylength){
                    continue;
                }
                int e = rooms[x_n][y_n];
                if (e == DOOR || e == WALL){
                    continue;
                }
                if (e != INF){
                    continue;
                }
                rooms[x_n][y_n] = rooms[x][y]+1;
                queue.add(new int[]{x_n,y_n});
            }
        }
    }
}
