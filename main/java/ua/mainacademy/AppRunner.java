package ua.mainacademy;

import java.util.*;
import java.util.logging.Logger;

public class AppRunner {
	public static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare =
						map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
	
	public static void main(String[] args) {
		String text = "Charlie Jennifer Charlie Bob Charlie Charlie Bob Jennifer Alice Alice";
		String[] words = text.split(" ");
		Map<String, Integer> result = new TreeMap<>();
		for (String word : words) {
			if (result.containsKey(word)) {
				result.put(word, result.get(word) + 1);
			} else {
				result.put(word, 1);
			}
		}
		LOG.info(String.format("Sorted by name: %s", result.toString()));
		LOG.info("Sorted by quantity: ");
		Map sortedMap = sortByValues(result);
		Set set = sortedMap.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			LOG.info(me.getKey() + " - " + me.getValue());
		}
	}
}
