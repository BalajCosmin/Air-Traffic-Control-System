package Traffic_Control.Main;

public class TakeoffCommand extends AtcCommand {
    private int altitude;



    public TakeoffCommand(int altitude,String ID) {
        super(ID);
        this.altitude = altitude;
    }


    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }


}
