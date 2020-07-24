package intro.queue;



import java.util.*;

public class OpenLock {
    private static int[][] DIRECTIONS = new int[][]{{0,-1},{0,1},{1,-1},{1,1},{2,-1},{2,1},{3,-1},{3,1}};

    private static final char value = '0';

    private static final List<Character> thumbwheel = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) {
        String[] deadends1  = {"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";
        System.out.println(openLock(deadends1,target1));
        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println(openLock(deadends2,target2));
        String[] deadnends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        System.out.println(openLock(deadnends3,target3));
        String[] deadend4 = {"0000"};
        String target4 = "8888";
        System.out.println(openLock(deadend4,target4));
    }

    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        String step_separator = "aaaa";

        Map<String,Object> deadendMap = new HashMap<String, Object>();
        for (String deadend : deadends) {
            deadendMap.put(deadend,value);
        }
        Map<String,Object> usednodes = new HashMap<String, Object>();
        if (deadendMap.containsKey(start)){
            return -1;
        }

        int step = 0;
        Queue<String> node_queue = new LinkedList<>();
        node_queue.add(start);
        node_queue.add(step_separator);
        usednodes.put(start,value);
        while (!node_queue.isEmpty()){
            String node = node_queue.poll();
            if (step_separator.equals(node)){
                step++;
                if (step > 10000){
                    System.out.println(step);
                }

                if (!step_separator.equals(node_queue.peek()) && node_queue.peek() != null){
                    node_queue.add(step_separator);
                }
                continue;
            }
            if (node.equals(target)){
                return step;
            }
            List<String> neighbors = getneighbors(node);
            for (String neighbor : neighbors) {
                if (usednodes.containsKey(neighbor) || deadendMap.containsKey(neighbor)){
                    continue;
                }
                node_queue.add(neighbor);
                usednodes.put(neighbor,value);
            }
        }
        return -1;
    }

    private static List<String> getneighbors(String node){
        List<String> list = new ArrayList<String>();
        for (int[] direction : DIRECTIONS) {
            char[] neighbor = getNeighbor(node.toCharArray(), direction[0], direction[1]);
            list.add(String.valueOf(neighbor));
        }
        return list;
    }

    private static char[] getNeighbor(char[] node, int index, int diff) {
        char[] clone = node.clone();
        char c = clone[index];
        int c_index = thumbwheel.indexOf(c);
        Character c_new = thumbwheel.get((c_index + diff + thumbwheel.size()) % thumbwheel.size());
        clone[index]=c_new;
        return clone;
    }

}
