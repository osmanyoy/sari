package com.training.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapMain {
	public static void main(final String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>(1_000_000,
		                                                  0.9f,
		                                                  10_000);

		map.put("osman1",
		        UUID.randomUUID()
		            .toString());

		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			String string2 = map.get(string);
		}

		Collection<String> values = map.values();
		for (String string : values) {

		}

		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {

		}
	}
}
