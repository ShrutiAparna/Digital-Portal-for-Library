package Includes;

public class RequestData {
	public int ISBN;
	public int UserID;
	public MyDate RequestDate;

	//constructor
	public RequestData(int ISBN, int UserID, MyDate RequestDate){
		this.ISBN = ISBN;
		this.UserID = UserID;
		this.RequestDate = RequestDate;
		// ISBN = 0;
		// UserID = -1;
		// RequestDate = null;
	}

	public String toString() {
        return "ISBN: " + ISBN + "\nUserID: " + UserID + "\n";
    }
}
