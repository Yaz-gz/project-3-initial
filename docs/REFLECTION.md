Questions to consider before implementing each method: thoughts and considerations. 

What happens if we try to get the first 2 elements from a list with only 1 element?

There is 2 ways that we could go about this; the first way is to return whatever elements are available without throwing an exception. So if there is only 1 element in the list
we would just return that 1 element. If we absolutely need 2 elements, we could throw an exception that tells the user there is not enough elements in the list to perform the operation.
The approach we go with depends on what the requirements are for the project. For this project we returned an exception since that was the point of the exercise.

How should we handle the case where no odd numbers exist in topTenUniqueOdd()?

In the case where no odd numbers exist in the collection for the topTenUniqueOdd() method, we have a few options to consider. 
The first way we could deal with this is to return an empty list; that would indicate that there are no odd numbers. The other way would be to throw an 
exception to let the user know that there is no odd numbers in the collection. This project uses the exception approach again to showcase exception handling.

What's the best way to handle null elements within a collection?

There are a few ways to deal with null elements within a collection. The first way is to just take them out or filter them out with the filter() method in streams.
This way would just ignore the null elements and continue with the rest of the collection. I am not sure if this would be the best way though since first there would be no
way in letting the user know that there were null elements in the collection or if filtering them out would affect the results of the other methods like methods that
maybe deal with indexing. The other way again is to just throw an exception which is what we did for this project. 

Should average() return null, throw an exception, or return a special value for empty collections?

For the average() method, we could do either of the 3 options mentioned. Returning a null would indicate that there is no average calculated since it is an empty collection.
Throwing an exception would tell the user that the collection is empty. We could use 0 as the special value to show that the collection is empty since 0 + 0 / 2 = 0. 

How can we make our exception messages more informative for debugging?

To make our exception messages more informative for debugging, we should include specific details about what caused the exception. We could include the name of the 
method and what it was expected to do. We could include the parameters that were used and what the output should have been based on those parameters. We could also 
include the location in the code (like it does when one of our test fails) so the user could easily find where the issue is at. We cant always think of everything that could
go wrong but the more details we can include in the exception message the better off we will be when debugging. 

What performance considerations should we have for large collections?

When dealing with large collections, we should consider the order in which we do operations. For example, we could use the filter() method before doing any other operations. 
If you know you are only going to use the odd numbers from a collection, filter out the even numbers so the rest of the operations don't have to deal with the extra
elements. We could also consider parallel streaming to help with performance on large collections.

How can we make our methods more testable and maintainable?

The best way to make our methods more testable and maintainable is to keep their purpose single and focused. When we name methods we usually translate their purpose into
the method name so if the purpose starts to stray away from the name it could be hard to test and maintain later on since it is not clear when exactly the method is supposed
be doing. 

AI reflection:

Using AI to analyze my code is always fun and interesting because it always gives ideas I didn't think of. For this project, Claude gave me a list of edge cases and exceptions
that I wouldn't have thought of on my own. After the first couple methods I did catch on to the patterns, but it would have taken longer to think of all the edge cases 
myself. AI is also a very good tool when it comes to answering questions. You could ask it simple or complex questions, and it always gives you a well-thought-out answer.
Sometimes it even shows your different ways to fix your problems. I also like that it remembers the context of our previous conversations, so I don't have to keep re-explaining everything. 
I think using AI also makes the code more direct and efficient, there isn't any extra stuff that isn't needed, it gets straight to the point. Overall I hope to keep learning
how to use AI as a tool. 
