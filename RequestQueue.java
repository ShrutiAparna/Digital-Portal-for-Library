import Includes.*;

public class RequestQueue {
    private Node<RequestData> front;
    private Node<RequestData> back;
    private int length;

    //constructor
    public RequestQueue(){
        this.front = null;
        this.back = null;
        this.length = 0;
    }

    public RequestData getFront() {
        return this.front.data;
    }

    public Node<RequestData> front(){
        return front;
    }

    public int getLength() {
        /*
         * Your code here.
         */

        return this.length;
    }

    public void push(int ISBN, int UserID) {
        /*
         * Your code here.
         */
        RequestData curr = new RequestData(ISBN, UserID, null);
        Node<RequestData> tm = new Node<>(curr);
        if(back == null){
            front = tm;
            back = tm;
            length++;
        }else{
            back.next = tm;
            tm.previous = back;
            back = tm;
            length++;
        }
        return;
    }

    public void pop() {      // processing needs to be done before popping, 
        /*
         * Your code here.
         */
        if (front == null)
            return;
        if (front == back) {
            front = null;
            back = null;
            return;
        } else {
            front = front.next;
            if (front != null){
                front.previous = null;}
        }
        length--;
        return;
    }

    public String toString(){
        Node<RequestData> temp = front;
        String s = "Length: " + length + "\n";
        while(temp != null){
            s+=temp.data.toString();
            temp = temp.next;
        }
        return s;
    }
}
