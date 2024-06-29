package Includes;

public class Response {
    public int WaitingTime;
    public boolean Available;
    public int PositionInQueue;     //removable

    //constructor
    public Response(int WaitingTime, boolean Available, int PositionInQueue){
        this.WaitingTime = WaitingTime;
        this.Available = Available;
        this.PositionInQueue = PositionInQueue;
    }
}
