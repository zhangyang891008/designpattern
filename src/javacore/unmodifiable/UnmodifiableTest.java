package javacore.unmodifiable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


//不可修改视图不能调用更改器
public class UnmodifiableTest {
	public static void main(String[] args) {
		Map<Integer, String> persons = new HashMap<>();
		persons.put(1, "zhangyangt");
		persons.put(2, "maguangle");
		Map<Integer, String> unmodifiablemap = Collections.unmodifiableMap(persons);
		unmodifiablemap.put(1, "change");
	}

}
