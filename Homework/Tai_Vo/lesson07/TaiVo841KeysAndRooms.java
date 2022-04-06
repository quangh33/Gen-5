package lesson07;

import java.util.List;

/**
 * @author taivt
 * @link https://leetcode.com/problems/keys-and-rooms/
 * @since 2022/04/06 20:51:24
 */
public class TaiVo841KeysAndRooms {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(solution.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of())));
    }

    private static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];
            dfs(rooms, visited, 0);
            for (int i = 0; i < rooms.size(); i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(List<List<Integer>> rooms, boolean[] visited, int cur) {
            visited[cur] = true;
            for (Integer roomKey : rooms.get(cur)) {
                if (!visited[roomKey]) {
                    dfs(rooms, visited, roomKey);
                }
            }
        }
    }
}
