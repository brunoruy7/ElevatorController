package controller;

import static java.lang.Math.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author BRUNO
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = 0;
        long startTime = System.nanoTime();
        long diference = 0;
        long testTime;
        int dir, floorDest;
        Building build1 = new Building(3);
        
        Elevator e1 = new Elevator(-1,9, "Elevator 01");
        Elevator e2 = new Elevator(0,10, "Elevator 02");
        
        build1.AddElevator(e1);
        build1.AddElevator(e2);
        
        while(c < 100 && diference < 180){
            if(((int)random()*10)%2 == 0){
                dir = 1;
            }else { 
                dir = -1;
            }
            int floor = (int)(random()*11 + 0.5) -1;
            if (dir == 1){
                floorDest = (int)(random()*(10-floor) + 1.5) + floor;
            }else{
                floorDest = (int)(random()*10-floor) - (10-floor);
            }
            
            try{build1.RequestElevator(floor, dir, floorDest);            
            TimeUnit.MILLISECONDS.sleep((long)(random()*2000));} catch(InterruptedException e){}
            testTime = System.nanoTime();
            diference = (testTime - startTime)/(long)pow(10,9);
                        
            }
        
        /*e1.addDestination(2);
        e1.addDestination(5);
        e1.addDestination(9);
        e2.position = 7;
        e2.addDestination(5);
        e2.addDestination(3);
        e2.addDestination(0);
        e1.start();
        e2.start();*/
        
    }
    
}
