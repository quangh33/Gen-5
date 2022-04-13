package HomeWorkLesson7;

import java.util.List;

public class KeyAndRooms {
    int[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new int[rooms.size()];
        dfs(0,rooms);
        for (int i = 0 ; i < rooms.size() ; i++){
            if (visited[i] == 0) return false;
        }
        return true;

    }
    void dfs(int currentNode, List<List<Integer>> rooms){
        visited[currentNode] = 1;
        for (int next: rooms.get(currentNode)){
            if (visited[next] == 0) {
                dfs(next, rooms);
            }

        }
    }
}
