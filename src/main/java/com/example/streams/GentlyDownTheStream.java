package com.example.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Enhanced coding kata on the Stream API with exception handling, generics, and advanced concepts.
 * All methods include proper validation and can be completed with a single return statement plus validation.
 */
public class GentlyDownTheStream {

    protected List<String> fruits;
    protected List<String> veggies;
    protected List<Integer> integerValues;

    public GentlyDownTheStream() {
        fruits = Arrays.asList("Apple", "Orange", "Banana", "Pear", "Peach", "Tomato");
        veggies = Arrays.asList("Corn", "Potato", "Carrot", "Pea", "Tomato");
        integerValues = new Random().ints(0, 1001)
                .boxed()
                .limit(1000)
                .collect(Collectors.toList());
    }

    /**
     * Example method showing proper exception handling and validation
     * Returns a sorted list of fruits with comprehensive error checking
     */
    public List<String> sortedFruits() throws InvalidDataException {
        // Check 1: Null validation - throw IllegalArgumentException
        if (fruits == null) {
            throw new IllegalArgumentException("Fruits collection cannot be null");
        }

        // Check 2: Empty validation - throw EmptyCollectionException
        if (fruits.isEmpty()) {
            throw new EmptyCollectionException("Fruits collection cannot be empty");
        }

        // Process stream with error handling
        try {
            return fruits.stream()
                    .filter(Objects::nonNull)  // Handle potential null elements
                    .sorted()                  // Sort alphabetically
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // Wrap any unexpected exceptions
            throw new InvalidDataException("Failed to sort fruits: " + e.getMessage(), e);
        }
    }

    /**
     * Enhanced version with custom predicate and exception handling
     */
    public List<String> sortedFruitsException() throws InvalidDataException {
        return sortedFruitsWithFilter(fruit -> !fruit.startsWith("A"));
    }

    // TODO - return a list with the first 2 elements of a sorted list of fruits
    // Add proper validation and exception handling
    public List<String> sortedFruitsFirstTwo() throws InvalidDataException {
        // Validate source list exists
        if (fruits == null) {
            throw new InvalidDataException("Fruit list cannot be null");
        }

        // Validate not empty
        if (fruits.isEmpty()) {
            throw new InvalidDataException("Fruit list cannot be empty");
        }

        // Validate no null elements
        if (fruits.stream().anyMatch(Objects::isNull)) {
            throw new InvalidDataException("Fruit list contains null elements");
        }

        // Validate no empty strings
        if (fruits.stream().anyMatch(String::isEmpty)) {
            throw new InvalidDataException("Fruit list contains empty strings");
        }

        // Process and return
        return fruits.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .limit(2)
                .collect(Collectors.toList());
    }

    // TODO - return a comma separated String of sorted fruits
    // Handle null values and empty results gracefully
    public String commaSeparatedListOfFruits() throws InvalidDataException {
        // Validate source exists
        if (fruits == null) {
            throw new InvalidDataException("Fruit list cannot be null");
        }

        // Validate not empty
        if (fruits.isEmpty()) {
            throw new InvalidDataException("Fruit list cannot be empty");
        }

        // Validate no null elements
        if (fruits.stream().anyMatch(Objects::isNull)) {
            throw new InvalidDataException("Fruit list contains null elements");
        }

        // Validate no empty strings
        if (fruits.stream().anyMatch(String::isEmpty)) {
            throw new InvalidDataException("Fruit list contains empty strings");
        }

        // Validate no whitespace-only strings
        if (fruits.stream().anyMatch(s -> s.trim().isEmpty())) {
            throw new InvalidDataException("Fruit list contains whitespace-only strings");
        }

        // Check for commas in fruit names (optional business rule)
        Optional<String> fruitWithComma = fruits.stream()
                .filter(f -> f.contains(","))
                .findFirst();
        if (fruitWithComma.isPresent()) {
            throw new InvalidDataException(
                    "Fruit names cannot contain commas: " + fruitWithComma.get()
            );
        }

        // Sort alphabetically and join with comma separator
        return fruits.stream()
                .sorted()  // Natural alphabetical order (case-sensitive)
                .collect(Collectors.joining(", "));
    }

    // TODO - return a list of veggies sorted in reverse (descending) order
    // Use Comparator.reverseOrder() and handle edge cases
    public List<String> reverseSortedVeggies() throws InvalidDataException {
        // Validate source exists
        if (veggies == null) {
            throw new InvalidDataException("Veggie list cannot be null");
        }

        // Validate not empty
        if (veggies.isEmpty()) {
            throw new InvalidDataException("Veggie list cannot be empty");
        }

        // Validate no null elements
        if (veggies.stream().anyMatch(Objects::isNull)) {
            throw new InvalidDataException("Veggie list contains null elements");
        }

        // Validate no empty strings
        if (veggies.stream().anyMatch(String::isEmpty)) {
            throw new InvalidDataException("Veggie list contains empty strings");
        }

        // Validate no whitespace-only strings
        if (veggies.stream().anyMatch(s -> s.trim().isEmpty())) {
            throw new InvalidDataException("Veggie list contains whitespace-only strings");
        }

        // Return reverse sorted list (Z to A, case-insensitive)
        return veggies.stream()
                .sorted(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    // TODO - return a list of veggies sorted in reverse order, all in upper case
    // Chain multiple stream operations with proper exception handling
    public List<String> reverseSortedVeggiesInUpperCase() throws InvalidDataException {
        // Validate source exists
        if (veggies == null) {
            throw new InvalidDataException("Veggie list cannot be null");
        }

        // Validate not empty
        if (veggies.isEmpty()) {
            throw new InvalidDataException("Veggie list cannot be empty");
        }

        // Validate no null elements
        if (veggies.stream().anyMatch(Objects::isNull)) {
            throw new InvalidDataException("Veggie list contains null elements");
        }

        // Validate no empty strings
        if (veggies.stream().anyMatch(String::isEmpty)) {
            throw new InvalidDataException("Veggie list contains empty strings");
        }

        // Validate no whitespace-only strings
        if (veggies.stream().anyMatch(s -> s.trim().isEmpty())) {
            throw new InvalidDataException("Veggie list contains whitespace-only strings");
        }

        // Chain operations: reverse sort → uppercase
        return veggies.stream()
                .sorted(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER))
                .map(String::toUpperCase)              // Convert to uppercase
                .collect(Collectors.toList());
    }

    // TODO - return a list of the top 10 values in the list of random integers
    // Handle cases where list has fewer than 10 elements
    public List<Integer> topTen() throws InvalidDataException {
        // Validate source exists
        if (integerValues == null) {  // Changed from veggies
            throw new InvalidDataException("Number list cannot be null");
        }

        // Validate not empty
        if (integerValues.isEmpty()) {  // Changed from veggies
            throw new InvalidDataException("Number list cannot be empty");
        }

        // Validate no null elements
        if (integerValues.stream().anyMatch(Objects::isNull)) {  // Changed from veggies
            throw new InvalidDataException("Number list contains null elements");
        }

        // Return top 10 largest values in descending order
        return integerValues.stream()  // Changed from veggies
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    // TODO - return a list of the top 10 unique values in the list of random integers
    // Use distinct() operation and handle empty results
    public List<Integer> topTenUnique() throws InvalidDataException {
        // Validate source exists
        if (integerValues == null) {
            throw new InvalidDataException("Integer list cannot be null");
        }

        // Validate not empty
        if (integerValues.isEmpty()) {
            throw new InvalidDataException("Integer list cannot be empty");
        }

        // Get unique values, sort descending, take top 10
        List<Integer> result = integerValues.stream()
                .filter(Objects::nonNull)              // Remove nulls first
                .distinct()                            // Remove duplicates
                .sorted(Comparator.reverseOrder())     // Sort largest first
                .limit(10)                             // Take up to 10
                .collect(Collectors.toList());

        // Validate we have data after filtering
        if (result.isEmpty()) {
            throw new InvalidDataException("No valid data available after filtering");
        }

        return result;
    }

    // TODO - return a list of the top 10 unique values that are odd
    // Combine filtering, distinct, and limiting operations
    public List<Integer> topTenUniqueOdd() throws InvalidDataException {
        // Validate source exists
        if (integerValues == null) {
            throw new InvalidDataException("Integer list cannot be null");
        }

        // Validate not empty
        if (integerValues.isEmpty()) {
            throw new InvalidDataException("Integer list cannot be empty");
        }

        // Filter odd, remove duplicates, sort descending, take top 10
        List<Integer> result = integerValues.stream()
                .filter(Objects::nonNull)              // 1. Remove nulls
                .filter(n -> n % 2 != 0)               // 2. Keep only odd numbers
                .distinct()                            // 3. Remove duplicates
                .sorted(Comparator.reverseOrder())     // 4. Sort largest first
                .limit(10)                             // 5. Take up to 10
                .collect(Collectors.toList());

        // Validate we have data after filtering
        if (result.isEmpty()) {
            throw new InvalidDataException("No odd values available in the list");
        }

        return result;
    }

    // TODO - return the average of all random numbers
    // Handle potential OptionalDouble and division by zero scenarios
    public Double average() throws InvalidDataException {
        // Validate source exists
        if (integerValues == null) {
            throw new InvalidDataException("Integer list cannot be null");
        }

        // Validate not empty
        if (integerValues.isEmpty()) {
            throw new InvalidDataException("Cannot calculate average of empty list");
        }

        // Calculate average using OptionalDouble
        OptionalDouble optionalAvg = integerValues.stream()
                .filter(Objects::nonNull)              // Remove nulls
                .mapToInt(Integer::intValue)           // Convert to IntStream
                .average();                            // Returns OptionalDouble

        // Handle OptionalDouble - throw if no valid data
        if (!optionalAvg.isPresent()) {
            throw new InvalidDataException("No valid data available to calculate average");
        }

        return optionalAvg.getAsDouble();
    }

    // Generic method for safe collection operations
    private <T> void validateCollection(Collection<T> collection, String collectionName) throws EmptyCollectionException {
        if (collection == null) {
            throw new IllegalArgumentException(collectionName + " cannot be null");
        }
        if (collection.isEmpty()) {
            throw new EmptyCollectionException(collectionName + " cannot be empty");
        }
    }

    // Helper method demonstrating advanced generics and functional programming
    private <T> List<T> sortedWithFilter(Collection<T> collection,
                                         Predicate<T> filter,
                                         Comparator<T> comparator) throws InvalidDataException {
        try {
            validateCollection(collection, "Input collection");

            return collection.stream()
                    .filter(Objects::nonNull)
                    .filter(filter)
                    .sorted(comparator)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new InvalidDataException("Failed to sort and filter collection: " + e.getMessage());
        }
    }

    // Specialized method using the generic helper
    private List<String> sortedFruitsWithFilter(Predicate<String> filter) throws InvalidDataException {
        return sortedWithFilter(fruits, filter, String::compareTo);
    }

    // Utility method for safe integer operations
    private OptionalDouble safeAverage(Collection<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average();
    }
}