package Traffic_Control.Main  ;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {



        ATC atc = new ATC();
        atc.addAircraft("1234");
        atc.addAircraft("1235");
        ;
        atc.showAircrafts();
        Scanner s= new Scanner(System.in);
        String a = s.nextLine();

        String[] stringSplit = a.split(" ");
        int[] nums = new int[stringSplit.length];
        for(int i = 1; i < stringSplit.length; i++){
            nums[i] = Integer.parseInt(stringSplit[i]);
        }


        if(stringSplit[0].equals("TAKEOFF")) {
            atc.sendCommand("1234", new TakeoffCommand(Integer.parseInt(stringSplit[2]),stringSplit[1]));

        }

       String aLand=s.nextLine();
        String[] stringSplitLand = aLand.split(" ");
        int[] numsLand = new int[stringSplitLand.length];

        for(int i = 1; i < stringSplitLand.length; i++){
            numsLand[i] = Integer.parseInt(stringSplitLand[i]);
        }
        if(stringSplitLand[0].equals("LAND")) {
            atc.sendCommand("1234", new LandCommand((stringSplitLand[1])));

        }


    }
}

