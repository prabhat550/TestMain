package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamJAVA8 {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = new ArrayList<>();
		Collections.addAll(listOfIntegers, 11, 3, 5, 20, 4, 3, 21, 45, 98, 21, 98);

		// Find out sum of all integers greater than 10
		int sumOfAllIntegersGreaterThan10 = listOfIntegers.stream().filter(i -> i > 10).mapToInt(i -> i)
				.sum();
		System.out.println(sumOfAllIntegersGreaterThan10);

		// Find duplicate elements in a list using stream functions
		Set<Integer> set = new HashSet<>();
		List<Integer> dublicateElements = listOfIntegers.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println(dublicateElements);

		// Find the total number of all the elements
		long countOfElements = listOfIntegers.stream().count();
		System.out.println(countOfElements);

		// Find first non-repeated character in the string
		String input = "Java Hungry Blog Alive is Awesome";
		Character resultNonRepeatedCharacter = input.chars()
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		
		 Map<Character, Long> a = input.chars()
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		 System.out.println(a);
				a.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(resultNonRepeatedCharacter);

		// Find first repeated character in the string
		Character resultFirstRepeatedCharacter = input.chars()
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(resultFirstRepeatedCharacter);

		// Find the names from a list of names having length more than 3
		List<String> listOfNames = new ArrayList<>();
		Collections.addAll(listOfNames, "Akhil", "Amitesh", "Akshay", "Anirudh", "Milind");
		List<String> filteredListOfNames = listOfNames.stream().filter(s -> s.length() > 3)
				.collect(Collectors.toList());
		System.out.println(filteredListOfNames);

		
		List<Individual> listOfIndividuals = new ArrayList<>();

		Individual i1 = new Individual("Akhil", 25);
		Individual i2 = new Individual("Amitesh", 23);
		Individual i3 = new Individual("Akshay", 25);
		Individual i4 = new Individual("Anirudh", 27);
		Individual i5 = new Individual("Milind", 21);

		Collections.addAll(listOfIndividuals, i1, i2, i3, i4, i5);

		// Find the youngest individual from a group of people
		Individual youngestPerson = listOfIndividuals. stream().min(Comparator.comparing(Individual::getAge)).get();
		System.out.println(youngestPerson);

		// Find the oldest individual from a group of people
		Individual oldestPerson = listOfIndividuals.stream().max(Comparator.comparing(Individual::getAge)).get();
		System.out.println(oldestPerson);

	}

}

class Individual {

	public Individual(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Individual [name=" + name + ", age=" + age + "]";
	}

}
