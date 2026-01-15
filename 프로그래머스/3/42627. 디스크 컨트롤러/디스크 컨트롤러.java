import java.util.*;

class Solution {
    static class Job {
        int idx;   // 작업 번호
        int s;     // 요청 시각
        int l;     // 소요 시간
        Job(int idx, int s, int l) {
            this.idx = idx;
            this.s = s;
            this.l = l;
        }
    }

    public int solution(int[][] jobs) {
        int n = jobs.length;

        // 1) jobs를 Job 리스트로 만들고, 요청 시각(s) 기준 정렬 (동률이면 idx)
        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                if (a.s != b.s) return a.s - b.s;
                return a.idx - b.idx;
            }
        });

        // 2) 우선순위 큐: 소요시간(l) -> 요청시각(s) -> 작업번호(idx)
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            public int compare(Job a, Job b) {
                if (a.l != b.l) return a.l - b.l;
                if (a.s != b.s) return a.s - b.s;
                return a.idx - b.idx;
            }
        });

        long totalTurnaround = 0; // 반환시간 합
        int time = 0;             // 현재 시간
        int i = 0;                // arr에서 아직 pq에 안 넣은 다음 작업 인덱스
        int done = 0;             // 처리 완료 개수

        while (done < n) {
            // 현재 time까지 요청된 작업들을 pq에 넣기
            while (i < n && arr[i].s <= time) {
                pq.offer(arr[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                // 가장 우선순위 높은 작업 처리
                Job cur = pq.poll();
                time += cur.l; // 작업 수행 (선점 없음)
                totalTurnaround += (time - cur.s); // 종료시각 - 요청시각
                done++;
            } else {
                // 대기큐가 비었으면 다음 요청 시각으로 점프
                time = arr[i].s;
            }
        }

        return (int)(totalTurnaround / n);
    }
}
