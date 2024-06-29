package Includes;

public class Node<T> {
    public T data;
    public Node<T> previous = null;
    public Node<T> next = null;

    //constructor
    public Node(T data){
        this.data = data;
        // this.previous = null;
        // this.next = null;
    }
}
