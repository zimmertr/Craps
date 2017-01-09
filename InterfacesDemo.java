import java.util.*;

public class InterfacesDemo {

	public static void main(String[] args) {

		Task t1 = new Task(5, 1, "Go to mall");
		Task t2 = new Task(1, 4, "Work on Project 2");
		Task t3 = new Task(2, 3, "See dentist");
		Task t4 = new Task(3, 5, "Study for exam");
		Task t5 = new Task(5, 2, "Get sleep");

		Task[] tasks = {t1, t2, t3, t4, t5};

		// print the Task objects in the array
		for (Task t : tasks) {
			System.out.println(t);
		}
		System.out.println("=========================================");

		// let's compare some Task objects using compareTo()
		System.out.println(t1.compareTo(t2));
		System.out.println(t3.compareTo(t2));
		System.out.println(t1.compareTo(t5));
		System.out.println(t2.compareTo(t4));
		System.out.println("=========================================");

		// Comparable objects can be sorted using the sort() of Arrays class
		Arrays.sort(tasks);
		for (Task t : tasks) {
			System.out.println(t);
		}
		System.out.println("=========================================");

		// Comparable objects can be sorted using the sort() of Arrays class
		// using a custom comparator class
		Arrays.sort(tasks, new TaskComplexityComparator());
		for (Task t : tasks) {
			System.out.println(t);
		}		
		System.out.println("=========================================");

		// Comparable objects can be sorted using the sort() of Arrays class
		// using a custom comparator class
		Arrays.sort(tasks, new TaskDescComparator());
		for (Task t : tasks) {
			System.out.println(t);
		}
		System.out.println("=========================================");

		// Comparable objects can be sorted using the sort() of Arrays class
		// using a custom comparator class
		Arrays.sort(tasks, new TaskPriorityComplexityComparator());
		for (Task t : tasks) {
			System.out.println(t);
		}
		System.out.println("=========================================");

		// An object of class is associated with a type for each interface 
		// that this class implements
		System.out.println("Are you an Object type object? " + (t1 instanceof Object));
		System.out.println("Are you an Task type object? " + (t1 instanceof Task));
		System.out.println("Are you an Priority type object? " + (t1 instanceof Priority));
		System.out.println("Are you an Complexity type object? " + (t1 instanceof Complexity));
		System.out.println("Are you an Comparable type object? " + (t1 instanceof Comparable));
	}
}
