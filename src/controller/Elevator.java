package controller;

import static java.lang.Math.*;
import java.util.*;

/**
 *
 * @author BRUNO
 */
public class Elevator implements Runnable {
    int minFloor;
    int maxFloor;
    int state = 0; // 0 for stoped, -1 for going downwards and 1 for going upwards, 2 for stoped by emeergency button.
    ArrayList destination = new ArrayList();
    //int lastDestination = 0;
    //long lastTime;
    private Thread t;
    private String threadName;
    int position;
    boolean emergency = false;
    
    Elevator(int minFloor, int maxFloor, String name){
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
        threadName = name;
    }
    
    public void run() {
        try {
         for(int i = 0; i < destination.size(); ) {
            if((int)destination.get(i) > position){
                this.position++;
                System.out.println("Elevator " + this.threadName + " move to " + position );
                Thread.sleep(1000);
                
            }
            if((int)destination.get(i) < position){
                this.position--;
                System.out.println("Elevator " + this.threadName + " move to " + position);
                Thread.sleep(1000);
                
            }
            if((int)destination.get(i) == position){
                this.destination.remove(i);
                this.handleArraval();
                
            }
         }
      } catch (InterruptedException e) {}
        this.state = 0;
    }
    
    public void handleEmergency(boolean signal){
        this.emergency = signal;
        if (signal == true){
            this.destination.clear();
            this.destination.add(this.position);
            this.state = 2;
        }
    }
    
    public void handleArraval(){
        int doorsOpen = 1500;
        System.out.println("Open "+this.threadName+" doors.");
        if ( !this.emergency){
            try{
                Thread.sleep(doorsOpen);
                System.out.println("Close " + this.threadName + " doors.");
            } catch(InterruptedException ex){}
        }
    }
    
    public void addDestination(int floor){
        if(!this.destination.contains(floor)){
            this.destination.add(floor);
            this.sort();
        }
    }
    
   public void sort(){
       for (int i = 0; i < destination.size();i++){
           int distance1 = (int)sqrt(pow((position - (int)destination.get(i)), 2));
           for (int j = i; j < destination.size();j++){
               int distance2 = (int)sqrt(pow((position - (int)destination.get(j)), 2));
               if(distance2 < distance1){
                   int temp = (int)destination.get(j);
                   destination.set(j, destination.get(i));
                   destination.set(i, temp);
               }
           }
       }
   }
    
    public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
