# hash-table

Hash Table Implementation

This project explores the implementation and performance analysis of hash tables, data structures designed for efficient insertion, search, and deletion (often with an average-case time complexity of O(1)).

Problem

Hash tables excel at these operations due to their use of a hash function, which maps keys to unique indexes in a fixed-size table. However, collisions occur when multiple keys map to the same index. Resolving collisions effectively is crucial for maintaining the O(1) average-case performance.

This project focuses on evaluating two common collision resolution strategies:

1) Quadratic Probing: When a collision occurs, this approach searches for an empty slot in the hash table by probing subsequent positions that follow a quadratic formula.

2) Separate Chaining: Instead of searching within the table itself, separate chaining uses linked lists at each index. Keys colliding at the same index are stored in the corresponding linked list.
You'll need to choose one of these strategies for your hash table implementation. Be prepared to analyze and justify your choice in a separate document.

Requirements

The project involves implementing several classes:

1) Provided Interfaces and Classes:

- Map<K, V> interface: Defines the operations for a key-value mapping, which your HashTable class will implement.
- MapEntry<K, V> class: Represents a key-value pair entry within the map.

2) HashTable<K, V> Class:

- Create a HashTable class within the assign09 package that implements the Map interface.
- This class will represent a hash table with either quadratic probing or separate chaining for collision resolution.
- The provided code snippet offers a starting point:

public class HashTable<K, V> implements Map<K, V> {
    // ... (Your implementation goes here)
}

3) StudentHash Classes:

implement three classes for testing hash functions with student objects:
- StudentBadHash: Create a correct but poor hash function for student objects.
- StudentMediumHash: Create a correct hash function that performs better than StudentBadHash.
- StudentGoodHash: Create a correct hash function that performs best among the three.

4) StudentHashDemo Class:

This provided class demonstrates how to use a hash table to store key-value pairs. Use it for reference, but create your own tests with different key types beyond StudentXHash.
