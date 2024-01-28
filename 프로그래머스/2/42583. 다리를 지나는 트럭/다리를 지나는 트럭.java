import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> onBridge = new LinkedList<>();
        Queue<Truck> waiting = new LinkedList<>();

        int time = 0;
        int currentWeight = 0;
        int truckIdx = 0;

        while (true) {
            time++;

            // 다리를 다 건넌 트럭을 큐에서 제거하고 현재 다리에 있는 트럭 무게 업데이트
            if (!onBridge.isEmpty() && time - onBridge.peek().time == bridge_length) {
                currentWeight -= onBridge.poll().weight;
            }

            // 새로운 트럭이 진입하면서 현재 다리에 있는 트럭 무게와 새로운 트럭의 무게를 더한 값이 weight를 초과하지 않는지 확인
            if (truckIdx < truck_weights.length && currentWeight + truck_weights[truckIdx] <= weight) {
                Truck newTruck = new Truck(truck_weights[truckIdx], time);
                onBridge.add(newTruck);
                currentWeight += newTruck.weight;
                truckIdx++;
            }

            // 종료 조건: 대기 중인 트럭이 없고 다리 위에도 트럭이 없으면 종료
            if (truckIdx == truck_weights.length && onBridge.isEmpty()) {
                break;
            }
        }

        return time;
    }
}

