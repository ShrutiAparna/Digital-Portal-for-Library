import Includes.*;

public class PendingRequests {
    private int length = 0;
    private Node<RequestData> front;
    private Node<RequestData> back;

    //constructor
    public PendingRequests(){
        this.front = null;
        this.back = null;
    }

    public boolean insert(Node<RequestData> insnode) {
        /*
         * Your code here.
         */
        if(back == null){
            front = insnode;
            back = insnode;
            length++;
        }else{
            back.next = insnode;
            insnode.previous = back;
            back = insnode;
            length++;
        }
        return true;
    }

    public boolean delete(Node<RequestData> delnode) {
        /*
         * Your code here.
         */
        if (delnode == null || front == null || back == null)
        return false;

        if (delnode == front && delnode == back) {
            front = null;
            back = null;
        } else if (delnode == back) {
            back = back.previous;
        } else if(delnode == front){
            front = front.next;
        }
        else {
            if (delnode.previous != null)
                delnode.previous.next = delnode.next;
            if (delnode.next != null)
                delnode.next.previous = delnode.previous;
        }
    
        // Adjust references and decrement length
        if (front != null && front.previous != null)
            front.previous = null;
        if (back != null && back.next != null)
            back.next = null;
    
        length--;
        return true;
    }

    public Node<RequestData> find(int ISBN) {
        /*
         * Your code here.
         */

        Node<RequestData> nrd = front;
        while (nrd != null) {
            if(nrd.data.ISBN == ISBN){
                return nrd;
            }
            nrd = nrd.next;
            
        }
        return null;
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
