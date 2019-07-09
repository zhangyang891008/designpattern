package com.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap();
		map.compute("hello", (k,v)->v==null?1:v+1);
		map.compute("hello", (k,v)->v==null?1:v+1);
		System.out.println(map.toString());
		
		map.put("zhangyang", 30);
		map.put("maguangle", 29);
		String name = map.search(1, (k,v)-> k.length()>6?k:null);
		System.out.println(name);
		
		map.forEach(1, (k,v)->System.out.println(k+"->"+v));
		map.forEach(1, (k,v)->"("+k+","+v+")",System.out::println);
		
		Long count = map.reduceValues(1, v-> (v>5?1L:null), Long::sum);
		System.out.println(count);
		Integer countkeys = map.reduceKeys(1, k->k.length()>5?1:0,Integer::sum);
		System.out.println(countkeys);
	}

}
