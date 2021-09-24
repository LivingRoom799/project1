import java.util.Iterator;


/*
   Implementation of the Set ADT that uses a BasicLinkedList private variable to store data.
*/
public class BasicSet<E> implements BasicSetInterface<E> {

  private BasicLinkedList<E> list;

  /*  Provide code for the following methods:
  -------------------------------------------------------------------------------
  Constructors:
  - a default constructor,
  - a constructor that takes a single argument of type E and
  initializing the set to contain that object, and
  - a copy constructor.

  Methods:
  - add: a method that takes an element of type E and adds it into the set,
  - addAll: a method that takes a BasicListInterface of elements of type
  E and inserts them into the set,
  - difference: a method that takes a Set as an argument and
  returns a new Set that is the difference of the current set and the argument,
  - equals: a method that takes a Set as an argument and returns true if both
  Sets contain the same elements and false otherwise,
  - in: a method that takes an element of type E and returns true if the
  given element is contained in the current Set or false otherwise,
  - intersection: a method that takes a Set as an argument and
  returns a new Set that is the intersection of the current set and the argument,
  - isEmpty: a method that returns true if the Set contains no elements and
  false otherwise,
  - size: a method that returns the number of elements in the set as an int value,
  - toString: a method that returns the String representation of the Set,
  - union: a method that takes a Set as an argument and returns a
  new Set that is the union of the current set and the argument.
  -------------------------------------------------------------------------------
  */
  //Default Constructor
  public BasicSet(){
    list = new BasicLinkedList<E>();
  }

  //Constructor for one element
  public BasicSet(E elt){
    list = new BasicLinkedList<E>(elt);
  }

  //Copy Constructor
  public BasicSet(BasicSetInterface<E> other) {
    // needs check for duplicate
    //list = new BasicLinkedList<E>(other);
    
    
  }

  //add method using list add
  public void add(E elt){
    if(in(elt)){
      list.add(0, elt);
    }
  }

  public void addAll(BasicListInterface<E> elt){
    
  }

  public BasicSetInterface<E> differenece(BasicSetInterface<E> other){
    //BasicSetInterface<E> result = list - other;
    //same size
    return other;
  }

  public boolean equals(BasicSetInterface<E> other){
    //sets can only have unique data, so if every item in set1 is in set2 then they are equal
    //same suze ,,, uses difference to find equality 
    return true;
  }

  public boolean in(E elt){
    return list.indexOf(elt) > -1;
  }

  public BasicSetInterface<E> intersection(BasicSetInterface<E> other){
    //
    return other;
  }

  public boolean isEmpty(){
    return list.size() == 0;
  }
  
  public int size(){
    return list.size();
  }

  public String toString(){
    return list.toString();
  }

  public BasicSetInterface<E> union(BasicSetInterface<E> other){
    return other;
  }

  /**
   * This method implements the iterator required by the Iterable interface,
   * with SetInterface inherits from. It enables the list to be iterable,
   * which allows the use of enhanced for loops.
   * @return an iterator.
   */
  public Iterator<E> iterator() {
    return (list.iterator());
  }

  /*private class BasicSetIterator implements Iterator<E> {
    private Node<E> cursor;

    public BasicSetIterator(Node <E> head){
      cursor = head;
    }
  }
  public boolean hasNext() {
      return cursor != null;
    }

    /**
     
  
    public E next() {
      if (! hasNext()) {
        return null;
      }
      E item = cursor.getItem();
      cursor = cursor.getNext();
      return item;
    }
  }
  */
}
