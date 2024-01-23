package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Word_Ladder_II {

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		Collections.addAll(wordList, "hot", "dot", "dog", "lot", "log", "cog");
		List<List<String>> result = findLadders(beginWord, endWord, wordList);
		System.out.println(result);
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if(!wordList.contains(endWord))
			return result;
		Map<String, Boolean> visited = new HashMap<>();
		for(String word : wordList) {
			visited.put(word, false);
		}
		Queue<String> queue = new LinkedList<String>();
		List<String> list = new ArrayList<>();
		queue.add(beginWord);
		list.add(beginWord);
		visited.put(beginWord, true);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String word = queue.poll();
				list.add(word);
				if(word.equals(endWord)) {
					result.add(new ArrayList<String>(list));
					
				}
			}
			
		}
		return null;
	}

}
