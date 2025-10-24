1. I used the same prompt for each method: 

I have this Java Stream API method:

public List<String> specificMethodName() throws InvalidDataException {
return null;
}

What edge cases am I missing? What exceptions should I handle? Suggest improvements for robustness.

2. My test wouldn't pass because the output was not in alphabetical order like the test expected. I asked the AI:

" Using the code above, how can I make sure that it passes this test [entered test code here]. How can I make sure the output is in alphabetical order? "
 
The AI responded with explanations about:
    1. Natural ordering (case-sensitive)
    2. Case-insensitive ordering
    3. Custom comparator for specific ordering needs

It fixed the code by adding sort to it. 

3. Some of the methods had 2 functions that it needed to do. I asked the AI: "What is stream operations chaining?"

Best Practices for Chained Operations: 

Filter nulls before ANY other operation - Prevents NullPointerException
Map/transform after filtering - Don't waste operations on data you'll discard
Sort before distinct (usually) - Unless you want distinct before sorting
Document operation order - It affects the result!
Return immutable lists - Prevents accidental modification

Also gave examples of chaining operations.

4. For another method, I used AI to help me change the code to deal with integer values instead of strings. There was an error in my code so I thought I knew what was wrong
and changed the type it was dealing with. It was supposed to return integer values and the way I changed it, it was looking at the list of veggies which were strings. I 
asked the AI: " How can I change this code [pasted code here] to deal with integer values instead of strings? "

It changed the code for me and explained what it did and why mine caused an error in the test.

5. I was having trouble with the exception handling tests. I knew what was wrong but didn't know how to fix it. I asked the AI:

" How can I fix this code [pasted code here] to make sure it passes this exception handling test [pasted test code here]? Should I use checked or unchecked exceptions?
How do I implement invaliddataexception and emptycollectionexception both in the method? "

It changed my sortedFruit method to include both exceptions and explained how it did it. It also explained the difference between 
checked and unchecked exceptions and when to use each.

6. For my last AI interaction I asked it about parallel streams since I had never used them before. I asked:

" What are parallel streams in Javas stream API? When should I use them? What are the benefits and drawbacks? "

It explained what parallel streams were, when to use them, the benefits and drawbacks. It also gave examples of how to implement them in code.
It talked about how to use the Fork/Join framework and how it worked with parallel streams.