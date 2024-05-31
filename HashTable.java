import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @author Sarthak Goyal
 * 
 */

import java.util.List;

public class HashTable<K, V> implements Map<K, V> {
	
	int capacity = 10; //size variable
	int number_of_items = 0;     // keeps count of the elements in the LinkedList.
	
	private ArrayList<LinkedList<MapEntry<K, V>>> table;

	/**
	 * A constructor that that stores the baking array of linked lists.
	 */
	public HashTable(){ 
		table = new ArrayList<LinkedList<MapEntry<K,V>>>();
		for(int i = 0; i < capacity; i++) {
			table.add(new LinkedList<MapEntry<K,V>>());
		}
	}
	
	/**
	 * Removes all key to value mappings from this map.
	 * 
	 * O(table length)
	 */
	@Override
	public void clear() { 
		for(int i = 0; i < capacity; i++) {
			table.set(i, null);
		}
		capacity = 0;
		number_of_items = 0;
	}
	
	/**
	 * Determines whether this map contains the specified key.
	 * O(1)
	 * @param key
	 * @return true if this map contains the key, false otherwise
	 */
	@Override
	public boolean containsKey(K key) {
		int i = Math.abs(key.hashCode() % capacity);
		LinkedList<MapEntry<K, V>> a = table.get(i);

		for(int j = 0; j < a.size(); j++) {
			if(a.get(j).getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines whether this map contains the specified value.
	 * 
	 * O(table length)
	 * 
	 * @param value
	 * @return true if this map contains one or more keys to the specified value,
	 *         false otherwise
	 */
	@Override
	public boolean containsValue(V value) { 
		for(int i = 0; i < table.size(); i++) {
			LinkedList<MapEntry<K, V>> a = table.get(i);
			for(int j = 0; j < a.size(); j++) {
				if(a.get(j).getValue().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns a List view of the mappings contained in this map, where the ordering of 
	 * mapping in the list is insignificant.
	 * 
	 * O(table length)
	 * 
	 * @return a List object containing all mapping (i.e., entries) in this map
	 */
	@Override
	public List<MapEntry<K, V>> entries() { 
		List<MapEntry<K,V>> list = new ArrayList<>();
		for(int i = 0; i < table.size(); i++) {
			LinkedList<MapEntry<K, V>> a = table.get(i);
			for(int j = 0; j < a.size(); j++) {
				MapEntry<K,V> b = new MapEntry<K, V>(a.get(j).getKey(), a.get(j).getValue());
				list.add(b);
			}
		}
	return list;
	}

	/**
	 * Gets the value to which the specified key is mapped.
	 * O(1)
	 * @param key
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 */
	@Override
	public V get(K key) {
		
		int i = Math.abs(key.hashCode() % capacity);
		LinkedList<MapEntry<K, V>> a = table.get(i);

		for(int j = 0; j < a.size(); j++) {
			if(a.get(j).getKey().equals(key)) {
				V newValue = a.get(j).getValue();
				return newValue;
			}
		}
		return null;
	}

	/**
	 * Determines whether this map contains any mappings.
	 * O(1)
	 * @return true if this map contains no mappings, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(number_of_items == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * (I.e., if the key already exists in this map, resets the value; 
	 * otherwise adds the specified key-value pair.)
	 * O(1)
	 * @param key
	 * @param value
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V put(K key, V value) {
		int i = Math.abs(key.hashCode() % capacity);
		LinkedList<MapEntry<K, V>> a = table.get(i);
		if(a.size() > 10) {
			rehash(key, value);
			i = Math.abs(key.hashCode() % capacity);
			a = table.get(i);
		}
			for(int j = 0; j < a.size(); j++) {
				V oldValue = a.get(j).getValue();
				if(a.get(j).getKey().equals(key)) {
					a.get(j).setValue(value);
					return oldValue;
			    }
			}
		MapEntry<K,V> b = new MapEntry<K, V>(key, value);
		a.addFirst(b);
		number_of_items++;
		return a.getFirst().getValue();	
	}
	
	public ArrayList<LinkedList<MapEntry<K, V>>> rehash(K key, V value) {
		ArrayList<LinkedList<MapEntry<K, V>>> rehashedTable;
		capacity = 2 * capacity;
		rehashedTable = new ArrayList<LinkedList<MapEntry<K,V>>>();
		for(int j = 0; j < capacity; j++) {
			rehashedTable.add(new LinkedList<MapEntry<K,V>>());
		}
		for(int i = 0; i < table.size(); i++) {
			LinkedList<MapEntry<K, V>> a = table.get(i);
			LinkedList<MapEntry<K, V>> ab = rehashedTable.get(i);
			for(int k = 0; k < a.size(); k++) {
				ab.addFirst(a.get(k));
			}
		}
		table = rehashedTable;
		return table;
	}

	/**
	 * Removes the mapping for a key from this map if it is present.
	 * 
	 * O(1)
	 *
	 * @param key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V remove(K key) { 
		int i = Math.abs(key.hashCode() % capacity);
		LinkedList<MapEntry<K, V>> a = table.get(i);

		for(int j = 0; j < a.size(); j++) {
			if(a.get(j).getKey().equals(key)) {
				V oldValue = a.get(j).getValue();
				a.remove(j);
				number_of_items--;
				return oldValue;
			}
		}
		return null;
	}

	/**
	 * Determines the number of mappings in this map.
	 * O(1)
	 * @return the number of mappings in this map
	 */
	@Override
	public int size() {           
		return number_of_items;
	}

}
