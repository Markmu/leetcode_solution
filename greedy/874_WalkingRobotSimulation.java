package greedy;

import java.util.HashSet;
import java.util.Set;

class WalkingRobotSimulation {

    

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int x = 0, y = 0, direct = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] pos: obstacles) {
            obstacleSet.add(pos[0] + " " + pos[1]);
        }
        int res = 0;
        for (int cmd: commands) {
            if (cmd == -1) {
                direct = (direct + 1) % 4;
            } else if (cmd == -2) {
                direct = (direct + 3) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[direct];
                    int ny = y + dy[direct];
                    if (obstacleSet.contains(nx + " " + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }
}