# SortedLinkedList Implementation

## Overview

This repository contains my implementation of the `SortedLinkedList` class. The primary goal of this project was to implement a singly linked list from scratch using recursion, understand recursion better, and gain insights into the `Comparable` interface and `compareTo` method in Java.

## Description

The `SortedLinkedList` class is a custom implementation of a singly linked list that maintains its elements in ascending order. This project aims to achieve similar functionality to a previous project but using a different data structure. The list ensures no duplicates are allowed and is implemented using recursion without any loops.

## Features

- **Singly Linked List**: The list is a linked structure of nodes, where each node's data type is `String`.
- **Sorted Order**: The list maintains its elements in ascending order at all times.
- **No Duplicates**: The list does not allow any duplicate entries.
- **Recursive Implementation**: All methods in the `SortedLinkedList` class are implemented using recursion, without any loops.
- **No External Libraries**: The implementation does not use any classes from the Java Collections framework or any other imports.

## Methods

- **Constructors**:
  - `SortedLinkedList()`: Initializes an empty linked list.
  - `SortedLinkedList(String[] unsortedArray)`: Initializes the list with elements from an unsorted array, adding them in sorted order without using any sorting algorithms.

- **Interface Methods** (from `MyListInterface`):
  - `void add(String value)`: Adds a new word to the list in the correct sorted position.
  - `boolean contains(String key)`: Checks if the list contains the specified word.
  - `boolean remove(String key)`: Removes the specified word from the list.
  - `int size()`: Returns the number of elements in the list.
  - `void display()`: Displays all words in the list, comma-separated.

## Implementation Details

To deepen my understanding of data structures, I implemented this project with specific constraints and rules:

- **Recursive Methods**: All methods are implemented using recursion, emphasizing the base and recursive cases.
- **Single Node Reference**: The list uses a single `Node` reference (`head`) to manage the linked structure.
- **Efficient Display**: The `display()` method is optimized to print all values in one line, comma-separated.
- **No Loops or Imports**: The implementation strictly avoids loops and does not use any imports or the Collections framework.

## Usage

To use the `SortedLinkedList` class, create an instance and call its methods, or run the provided driver program in the repository.

## Learnings

- **Recursion**: I deepened my understanding of recursion by implementing all list operations recursively, identifying base and recursive cases.
- **Linked List Manipulation**: I learned how to manipulate singly linked lists to maintain sorted order and handle duplicates.
- **Comparable Interface**: I gained insights into using the `Comparable` interface and the `compareTo` method for sorting and comparison.
- **Problem-Solving**: I developed problem-solving skills by addressing edge cases and ensuring the robustness of the implementation.

## Conclusion

This project was a valuable experience in understanding the intricacies of implementing a singly linked list using recursion. The `SortedLinkedList` class provides an efficient way to manage a dynamic list of strings in sorted order, without relying on external libraries or sorting algorithms.
