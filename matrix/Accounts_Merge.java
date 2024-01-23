package com.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {

	public static void main(String[] args) {

		List<String> list1 = new ArrayList<>();
		Collections.addAll(list1, "John", "johnsmith@mail.com", "john_newyork@mail.com");
		List<String> list2 = new ArrayList<>();
		Collections.addAll(list2, "John", "johnsmith@mail.com", "john00@mail.com");
		List<String> list3 = new ArrayList<>();
		Collections.addAll(list3, "Mary", "mary@mail.com");
		List<String> list4 = new ArrayList<>();
		Collections.addAll(list4, "John", "johnnybravo@mail.com");

		List<List<String>> accounts = new ArrayList<>();
		Collections.addAll(accounts, list1, list2, list3, list4);
		List<List<String>> result = accountsMerge(accounts);
		System.out.println(result);

	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> result = new ArrayList<>();
		int nodes = accounts.size();
		DisjointSet_By_Size ds = new DisjointSet_By_Size(nodes);
		Map<String, Integer> mapMailNode = new HashMap<>();
		for (int i = 0; i < nodes; i++) {
			for (int j = 1; j < accounts.get(i).size(); j++) {
				String mail = accounts.get(i).get(j);
				if (!mapMailNode.containsKey(mail)) {
					mapMailNode.put(mail, i);
				} else {
					ds.unionBySize(i, mapMailNode.get(mail));
				}
			}
		}
		List<String>[] mergedMail = new ArrayList[nodes];
		for (int i = 0; i < nodes; i++)
			mergedMail[i] = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
			String mail = entry.getKey();
			int parentNode = ds.findUPar(entry.getValue());
			mergedMail[parentNode].add(mail);
		}
		for (int i = 0; i < nodes; i++) {
			if (mergedMail[i].isEmpty())
				continue;
			Collections.sort(mergedMail[i]);
			List<String> list = new ArrayList<>();
			list.add(accounts.get(i).get(0));
			list.addAll(mergedMail[i]);
			result.add(list);
		}
		return result;
	}

}
