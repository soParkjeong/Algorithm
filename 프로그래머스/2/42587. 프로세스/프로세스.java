import java.util.*;

class Solution {

    static class Process {
        int priority;
        int index;

        Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i));
        }

        int order = 0;

        while (!queue.isEmpty()) {
            Process cur = queue.poll();
            boolean hasHigh = false;

            for (Process p : queue) {
                if (p.priority > cur.priority) {
                    hasHigh = true;
                    break;
                }
            }

            if (hasHigh) {
                queue.offer(cur);
            } else {
                order++;

                // 내가 찾는 프로세스라면 종료
                if (cur.index == location) {
                    return order;
                }
            }
        }

        return -1; // 사실상 도달하지 않음
    }
}
