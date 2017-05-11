package com.bhacking;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class HotelsEvaluation {
	

	public static void main(String args[]) throws Exception {

		Map<Integer, Integer> hotels = new HashMap<Integer, Integer>();

		Scanner scan = new Scanner(System.in);

		String words = scan.nextLine();

		int reviews = new Integer(scan.nextLine()).intValue();

		while (scan.hasNextLine()) {
			String next = scan.nextLine();
			if(next.equals("end"))
				break;
			
			int id = new Integer(next).intValue();

			if (scan.hasNextLine()) {
				String line = scan.nextLine();

				line = line.replace(".", "");
				line = line.replace(",", "");

				StringTokenizer stringTokenizer = new StringTokenizer(line, " ");

				while (stringTokenizer.hasMoreElements()) {
					String word = (String) stringTokenizer.nextElement();

					if (words.contains(word)) {
						int atual = 0;
						if (hotels.containsKey(id)) {
							atual = hotels.get(id);
							hotels.replace(id, ++atual);
						} else {
							hotels.put(id, 1);
						}

					}

				}

			}

		}
		
		Map<Integer, Integer> hotelsSortByValue = sortByValue(hotels);
		
//		System.out.println(hotels.toString());
//		System.out.println(hotelsSortByValue.toString());

		for (Map.Entry<Integer, Integer> e : hotelsSortByValue.entrySet()) {
		   System.out.print(e.getKey() + " ");
		}    
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		return map.entrySet().stream().sorted(Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
