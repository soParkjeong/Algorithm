import java.util.Scanner;

class SWEA_서브트리 {
    static int[][] tree; 
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int E = sc.nextInt();
            int N = sc.nextInt();

            tree = new int[E + 2][2]; // [왼쪽 자식, 오른쪽 자식]
            cnt = 0;

            for (int i = 0; i < E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();

                if (tree[p][0] == 0) tree[p][0] = c; // 왼쪽 자식 저장
                else tree[p][1] = c; // 오른쪽 자식 저장
            }

            countSubtree(N);
            System.out.println("#" + t + " " + cnt);
        }
        sc.close();
    }

    static void countSubtree(int node) {
        if (node == 0) return; // 존재하지 않는 노드면 종료

        cnt++; // 현재 노드 포함
        countSubtree(tree[node][0]); // 왼쪽 자식 방문
        countSubtree(tree[node][1]); // 오른쪽 자식 방문
    }
}