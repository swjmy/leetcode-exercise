package intro.dfs;

import java.util.*;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class FindTargetSumWays {
    private static int r = 0;

    //private static List<String> traces = new LinkedList<>();

    public static void main(String[] args) {
        int[] case1 = new int[]{1};
        System.out.println(findTargetSumWays(case1,1));
    }

    public static int findTargetSumWays(int[] nums, int s) {
        r=0;
        if (nums.length==0) return 0;
        findTargetSumWays(nums[0],0,nums,s,0);
        findTargetSumWays(-nums[0],0,nums,s,0);
        return r;
    }

    public static void findTargetSumWays(int value,int index,int[] nums, int target,int sum){
        int sum1 = sum + value;
        if (index >= nums.length-1){
            if (sum1 == target){
                //System.out.println(Arrays.toString(traces.toArray()));
                r++;
            }
            return ;
        }
        //traces.add("+");
        findTargetSumWays(nums[index+1],index+1,nums,target,sum1);
        //traces.remove(traces.size()-1);
        //traces.add("-");
        findTargetSumWays(-nums[index+1],index+1,nums,target,sum1);
        //traces.remove(traces.size()-1);
    }

}
