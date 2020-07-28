package intro.queue;

/**
 * 完全背包问题
 * i : 表示前 i 个数
 * j ：最大容量
 * 值：最大权重和
 *
 * 朴素推导：
 * p[i,j] = max( p[i-1,j] , p[i-1,j-v[i]*k1]+w[i]*k1), k1 ∈ [1,k]
 * p[i,j-v[i]] = max( p[i-1,j-v[i]] , p[i-1,j-v[i]*(k2+1)]+w[i]*k2), k2 ∈ [1,k-1]
 * =>
 * 降为二维：
 * p[i,j] = max( p[i-1,j] , p[i,j-v[i]]+w[i])
 * =>
 * 优化为滚动数组.
 *
 * 完全平方问题：
 * i : 表示前 i 个数
 * j : 容量
 * 值：最小权重和
 *
 * 朴素推导公式：
 * p[i,j] = min( p[i-1,j] , p[i-1,j-(i*i)*k1]+k1 ),k1 ∈ [1,k]
 * p[i,j-i*i] = min( p[i-1,j-i*i] , p[i-1,j-(i*i)*(k2+1)+k2] ),k2 ∈ [1,k-1]
 * =>
 * 降为二维：
 * p[i,j] = min( p[i-1,j] , p[i,j-i*i]+1 )
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(twoDimensional(12));
        System.out.println(scrollingArray(12));
    }


    public static int numSquares(int n) {
        return naive(n);
    }

    /**
     * 朴素推导
     * p[i,j] = min( p[i-1,j] , p[i-1,j-(i*i)*k1]+k1 ),k1 ∈ [1,k]
     */
    private static int naive(int n) {
        int[][] p = new int[n+1][n+1];
        //给简单情况赋值
        for (int j = 0; j <= n; j++) {
            p[1][j] = j;
        }
        //根据简单情况递推
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = p[i-1][j];
                for (int k = 1; k <= n; k++) {
                    if (j >= (i*i)*k){
                        //递推公式
                        p[i][j] = Math.min(p[i-1][j],p[i-1][j-(i*i)*k]+k);
                    }
                }
            }
        }
        return p[n][n];
    }

    /**
     * 将朴素推导降为二维
     * p[i,j] = min( p[i-1,j] , p[i,j-i*i]+1 )
     */
    private static int twoDimensional(int n){
        int[][] p = new int[n+1][n+1];
        //给简单情况赋值
        for (int j = 0; j <= n; j++) {
            p[1][j] = j;
        }
        //根据简单情况递推
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                p[i][j] = p[i-1][j];
                if (j >= i*i){
                    p[i][j] = Math.min(p[i-1][j],p[i][j-i*i]+1);
                }
            }
        }
        return p[n][n];
    }

    /**
     * 将二维数组的算法使用滚动数组优化
     * 推导公式于二维数组算法一致：p[i,j] = min( p[i-1,j] , p[i,j-i*i]+1 )
     */
    private static int scrollingArray(int n){
        int[] p = new int[n+1];
        //给简单情况赋值
        for (int j = 0; j <= n; j++) {
            p[j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                if (j >= i*i){
                    p[j] = Math.min(p[j],p[j-i*i]+1);
                }
            }
        }
        return p[n];
    }

}
