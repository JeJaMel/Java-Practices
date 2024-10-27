# linked list
### linked list is not indexed at all, there is no array storing the addresses in a neat, ordered way, as we saw wit the arraylist
### each element that's added to a linked list forms a chain and the chain has links to the previous element and the next element

***
### This architecture is called doubly linked list

* the beginning of the chain is called head
* the end of the chain is called tail

***

### finding an element is more expensive on LinkedList because you need to start at the head or tail and check if the element marches
 
### but inserting and removing an element, is much simpler for this type of collection

***

### to insert or remove an item in a LinkedList is just a matter of breaking two links in the chain, and re-establishing two different links

*** 

### so, if you know the maximum number of possible items, then it's probably better to use an ArrayList, but set it;s capacity like this:
``` 
int capacity = 500_000;
ArrayList<String> stringArray = new ArrayList<>(capacity);
 ```

### else if we are processing large amount of elements, or the number of elements exceed integer.MAX_VALUE, a LinkedList can be more efficient.