package Includes;

public class BookData {
    public boolean BorrowedStatus;
    public int BorrowedByUserID;
    public int ISBN;
    public String Publisher;
    public String Author;
    public MyDate DateOfReturn;        // can be replaced with Time to Return

    //constructor
    public BookData(){
        BorrowedStatus = false;
        BorrowedByUserID = -1;
        ISBN = 0;
        Publisher = null;
        Author = null;
        DateOfReturn = null;
    }
}
