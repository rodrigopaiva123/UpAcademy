package pt.upacademy.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {

		List<Employee> eList = new ArrayList<Employee>();

		long t1, t2;
		for (int i = 0; i < 100; i++) {
			eList.add(new Employee("A", 20000));
			eList.add(new Employee("B", 3000));
			eList.add(new Employee("C", 15002));
			eList.add(new Employee("D", 7856));
			eList.add(new Employee("E", 200));
			eList.add(new Employee("F", 50000));
		}

		List<String> list = Arrays.asList("DC", "CD", "AD");

		List<String> list1 = Arrays.asList("AA", "AA", "BB");
		
		t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream Count?=" + eList.stream().filter(e -> e.getSalary() > 15000).count());
		t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time Taken?=" + (t2- t1));
		System.out.println();
		
		t1 = System.currentTimeMillis();
		System.out.println("Parallel Stream Count?=" + eList.parallelStream().filter(e -> e.getSalary() > 15000).count());
		t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time Taken?=" + (t2- t1));
		System.out.println();
		
		list.stream().sorted().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Number of distinct element:" + list1.stream().distinct().count());
		System.out.println();
	}

}
