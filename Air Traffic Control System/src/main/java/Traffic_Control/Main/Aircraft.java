package Traffic_Control.Main;

public class Aircraft extends Thread {
    private String id;
    private int altitude;
    private String message = "On stand";
    private boolean cruising=false;
    int cruisingTime=0;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlane() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Aircraft(String id) {
        this.id = id;
    }

    public void run() {
        System.out.println(this.id+" On stand");

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Taxing");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Taking off");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ascending");
        for (int i = 1; i <= this.altitude; i++) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Altitude in meters:" + i * 1000);

        }
        System.out.println("Cruising at:" + this.altitude + "km");
        this.cruising=true;
        while(cruising)
        {
            try {
                Thread.sleep(1000);
                cruisingTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Descending");
        System.out.println("Altitude in meters:"+this.altitude*1000);
        for (int i = this.altitude-1; i>=0; i--) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Altitude in meters:" + i * 1000);

        }
        System.out.println("Landed");
        System.out.println("Time cruising:"+cruisingTime);




    }

    public boolean isCruising() {
        return cruising;
    }

    public void setCruising(boolean cruising) {
        this.cruising = cruising;
    }

    public int getCruisingTime() {
        return cruisingTime;
    }

    public void setCruisingTime(int cruisingTime) {
        this.cruisingTime = cruisingTime;
    }

    public void receiveAtcMessage(String msg) {
        this.message = msg;
    }


    public void setId(String id) {
        this.id = id;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
