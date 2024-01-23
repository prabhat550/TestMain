
package comparator.functional.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorFunctionalImplementation {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Akhil", 25, 4);
		Employee e2 = new Employee("Amitesh", 22, 2);
		Employee e3 = new Employee("Amitesh", 25, 2);
		Employee e4 = new Employee("Akshay", 25, 4);
		Employee e5 = new Employee("Anirudh", 27, 7);
		Employee e6 = new Employee("Milind", 27, 7);
		Employee e7 = new Employee("Ashutosh", 27, 7);
		Employee e8 = new Employee("Ashish", 27, 7);
		Employee e9 = new Employee("Akhil", 27, 4);
		List<Employee> employeeList = new ArrayList<>();
		Collections.addAll(employeeList, e1, e2, e3, e4, e5, e6, e7, e8, e9);

		Comparator<Employee> c1 = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)
				.thenComparing(Employee::getExperience);
		Collections.sort(employeeList, c1);
		employeeList.forEach(System.out::println);
		
		Employee youngestEmployee = employeeList.stream().min(Comparator.comparing(Employee::getAge)).get();
		System.out.println(youngestEmployee);

		Employee oldestEmployee = employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println(oldestEmployee);

	}

}

class Employee {

	private String name;
	private int age;
	private int experience;

	public Employee(String name, int age, int experience) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
	}

	public Employee() {
		super();
	}

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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", experience=" + experience + "]";
	}
}
