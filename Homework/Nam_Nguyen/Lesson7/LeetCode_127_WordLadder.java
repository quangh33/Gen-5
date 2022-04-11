package Homework.Nam_Nguyen.Lesson7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_127_WordLadder {

    public static class Node {
        String val;
        Node next;

        Node() {
        }

        Node(String val) {
            this.val = val;
        }
    }

    public static boolean isAdjacentStrings(String string1, String string2) {
        int lengthDiff = Math.abs(string1.length() - string2.length());
        boolean isTransform = false;
        if(lengthDiff > 1)  return false;
        int minLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLength; i++) {
            if(string1.charAt(i) != string2.charAt(i)){
                if(lengthDiff > 0)  return false;
                else {
                    if(isTransform)
                        return false;
                    isTransform = true;
                }
            }
        }
        return true;
    }

    static Map<String, Node> listNodes = new HashMap<String, Node>();

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        Node head = new Node(beginWord);
        Node tail = head;
        for (String string : wordList) {
            if(isAdjacentStrings(beginWord, string)){
                Node adjacentNode = new Node(string);
                tail.next = adjacentNode;
                tail = tail.next;
            }
        }
        listNodes.put(head.val, head);

        for (String string1 : wordList) {
            Node h = new Node(string1);
            Node t = h;
            for (String string2 : wordList) {
                if(!string1.equals(string2) && isAdjacentStrings(string1, string2)){
                    Node adjacentNode = new Node(string2);
                    t.next = adjacentNode;
                    t = t.next;
                }
            }
            listNodes.put(h.val, h);
        }

        queue.add(beginWord);
        visited.put(beginWord, true);
        while(!queue.isEmpty()) {
            String word = queue.poll();
            Node h = listNodes.get(word);
            int previous = distances.getOrDefault(h.val, 0);
            h = h.next;
            while(h != null) {
                if(visited.get(h.val) == null) {
                    queue.add(h.val);
                    visited.put(h.val, true);
                    distances.put(h.val, previous + 1);
                }
                h = h.next;
            }
        }
        
        if(distances.get(endWord) != null) 
            return distances.get(endWord);
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        String beginWord = "hit", endWord = "cog";
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    
}
