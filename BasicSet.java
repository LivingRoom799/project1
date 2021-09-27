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
    list = new BasicLinkedList<E>();
    for(E n: other){
      list.add(0,n);
    }
  }

  //add method using list add
  public void add(E elt){
    if(!in(elt)){
      list.add(0, elt);
    }
  }

  public void addAll(BasicListInterface<E> elt){
    for(E n: elt){
      add(n);
    }
  }

  public BasicSetInterface<E> differenece(BasicSetInterface<E> other){
  
    BasicSet<E> tempDifference = new BasicSet<E>();
    for(E n: list){
      if(!other.in(n)){
        tempDifference.add(n);
      }
    }
    return tempDifference;

     /*for(E n: list){
      boolean isIn = false;
      for(E j: other){
        if(n.equals(j)){
          isIn = true;
          break;
        }
      }   terrible code...
      if(!isIn){ 
        tempDifference.add(n);
      }
      
    }
    return tempDifference;*/
  }

  public boolean equals(BasicSetInterface<E> other){
    //sets can only have unique data, so if every item in set1 is in set2 then they are equal
    //same suze ,,, uses difference to find equality 
    // A - B = O B - A = O 
    if(this.differenece(other).isEmpty() && other.differenece(this).isEmpty()){
      return true;
    }
    return false;
  }

  public boolean in(E elt){
    return list.indexOf(elt) > -1;
  }

  public BasicSetInterface<E> intersection(BasicSetInterface<E> other){
    //new set elements only the ones in both
    BasicSetInterface<E> tempIntersection = new BasicSet<E>();
    for(E n: list){
      if(other.in(n)){
        tempIntersection.add(n);
      }
    }
    return tempIntersection;
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
    //two sets all elements that both have
    BasicSetInterface<E> tempUnion = new BasicSet<E>();
    for(E n: list){
      tempUnion.add(n);
    }
    for(E j: other){
      tempUnion.add(j);
    }
    return tempUnion;
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
  
}
