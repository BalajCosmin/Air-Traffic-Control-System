package Traffic_Control.Main;

import java.util.ArrayList;
import java.util.List;

public class ATC {
    private List<Aircraft> AircraftList = new ArrayList<>();

    public void addAircraft(String id) {
        AircraftList.add(new Aircraft(id));
        AircraftList.get(AircraftList.size()-1).start();
    }

    public void sendCommand(String aircraftId, AtcCommand cmd) {


        for (Aircraft a : AircraftList)
            if (aircraftId.equals(a.getPlane()))
                if (cmd instanceof TakeoffCommand) {
                    synchronized (a) {
                        a.setAltitude(((TakeoffCommand) cmd).getAltitude());
                        a.notify();
                    }
                } else {
                    a.setCruising(false);
                }


    }

    public void showAircrafts() {
        for (Aircraft a : AircraftList)
            System.out.println(a.getPlane() + " " + "\n");
    }


}
