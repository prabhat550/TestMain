package com.backtracking.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Word_Ladder_I {

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		Collections.addAll(wordList, "hot", "dot", "dog", "lot", "log", "cog");
		int result = ladderLength(beginWord, endWord, wordList);
		System.out.println(result);

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		Map<String, Boolean> visited = new HashMap<>();
		for (String word : wordList) {
			visited.put(word, false);
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		visited.put(beginWord, true);
		int result = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(endWord))
					return result;
				wordMatch(word, visited, queue);
			}
			result++;
		}
		return 0;
	}	

	private static void wordMatch(String word, Map<String, Boolean> visited, Queue<String> queue) {
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				wordArray[i] = c;
				String s = String.valueOf(wordArray);
				if (visited.containsKey(s) && visited.get(s) == false) {
					queue.add(s);
					visited.put(s, true);
				}
			}
		}
	}

}
