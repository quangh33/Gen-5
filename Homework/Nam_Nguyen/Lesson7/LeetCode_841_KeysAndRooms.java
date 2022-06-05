package Homework.Nam_Nguyen.Lesson7;

import java.util.Arrays;
import java.util.List;

public class LeetCode_841_KeysAndRooms {

    static boolean[] visited;

    static void DFS(int room, List<List<Integer>> rooms) {
        visited[room] = true;
        for (Integer roomCanBeVisited : rooms.get(room)) {
            if(!visited[roomCanBeVisited]) {
                DFS(roomCanBeVisited, rooms);
            }
        }
    }
   
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        DFS(0, rooms);
        for (boolean roomIsVisited : visited) {
            if(!roomIsVisited)  return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
            Arrays.asList(1,3), 
            Arrays.asList(3,0,1), 
            Arrays.asList(2), 
            Arrays.asList(0)
            );
        System.out.println("canVisitAllRooms "+canVisitAllRooms(rooms));
    }
}
