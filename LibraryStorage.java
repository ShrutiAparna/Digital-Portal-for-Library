import java.util.*;

import Includes.*;

public class LibraryStorage {
    // HashMap
    // process return
    private HashMap<Integer, BookData> storage;
    private RequestQueue rqQueue;
    private PendingRequests prLinkedList;

    public LibraryStorage() {
        storage = new HashMap<Integer, BookData>();
        for (int i=100001; i<100011; i++) {
            BookData book = new BookData();
            MyDate dateor = new MyDate();
            dateor.month = 0;
            dateor.year = 0;
            book.BorrowedStatus = false;
            book.BorrowedByUserID = 0;
            book.ISBN = i;
            book.Publisher = "publisher";
            book.Author = "author";
            book.DateOfReturn = dateor;
            storage.put(i, book);
        }

        rqQueue = new RequestQueue();
        prLinkedList = new PendingRequests();
    }

    public void push(int ISBN, int UserID) {
        rqQueue.push(ISBN, UserID);
        return;
    }

    public boolean processQueue() {
        /*
         * Your code here.
         */
        if(rqQueue.front() == null){
            return false;
        }
        RequestData fronData = rqQueue.getFront();
        if(fronData == null){
            return false;
        }
        BookData requestedBook = storage.get(fronData.ISBN);
        if (requestedBook == null){
            rqQueue.pop();
            return false;
        }
        if(requestedBook.BorrowedStatus == false){
            // BookData tempBook = new BookData();
            requestedBook.BorrowedStatus = true;
            requestedBook.BorrowedByUserID = fronData.UserID;
            // tempBook.ISBN = fronData.ISBN;
            // tempBook.Author = "";
            // tempBook.Publisher = "";
            // tempBook.DateOfReturn = null;
            storage.put(fronData.ISBN, requestedBook);
            rqQueue.pop();
            return true;
        }else{
            boolean st;
            st = prLinkedList.insert(new Node<RequestData>(fronData));
            rqQueue.pop();
            return !st;
        }
        
    }

    public boolean processReturn(BookData book) {          // I have assumed this takes BookData object as argument, can also work with ISBN perhaps
        /*
         * Your code here.
         */
        Node<RequestData> requestedNode = prLinkedList.find(book.ISBN);
        if(requestedNode != null){
            BookData tempBook = new BookData();
            tempBook.BorrowedStatus = false;
            tempBook.BorrowedByUserID = -1;
            tempBook.ISBN = book.ISBN;
            tempBook.Author = "";
            tempBook.Publisher = "";
            tempBook.DateOfReturn = null;
            storage.put(book.ISBN, tempBook);
            
            prLinkedList.delete(requestedNode);
            return true;
        }
        return false;
    }

    public String rqQueueToString(){
        return rqQueue.toString();
    }

    public String prLinkedListToString(){
        return prLinkedList.toString();
    }
    
}
