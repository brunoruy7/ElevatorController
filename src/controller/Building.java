package controller;
/**
 *
 * @author BRUNO
 */
public class Building {
    protected int n;
    protected int counter = 0;
    protected Elevator[] elevators;
    
    Building(int n){
        this.n = n;
        this.elevators = new Elevator[this.n];
    }
    
    Building(){
        this.n = 5;
        this.elevators = new Elevator[this.n];
    }
    
    public void AddElevator(Elevator e){
        try{
        elevators[counter] = e;
        counter++;}
        catch(IndexOutOfBoundsException ex){System.out.println("Error: Maximun numbers of elevators reached for this building.");}        
    }
    
    public int searchElevador(int floor, int direction){ // direction can be only -1 for going down or 1 for going up.
        int diference;
        int index = -1;
        int minDistance = -1;
        
        while(minDistance == -1) {
            for (int e = 0; e < counter; e++){
                if (elevators[e].minFloor <= floor && elevators[e].maxFloor >= floor){
                    if (elevators[e].state == 0){
                        diference = elevators[e].position - floor;
                        diference = (int)Math.sqrt((double)(diference*diference));// Here we just make sure the diference is a positive number.
                        if (minDistance == -1){
                            minDistance = diference;
                            index = e;
                            }
                        else{if(minDistance > diference){
                            minDistance = diference;
                            index = e;
                        }                        
                        }
                    }
                    else{if(elevators[e].position > floor && elevators[e].state == direction && direction == -1){
                        diference = elevators[e].position - floor;
                        if (minDistance == -1){
                            minDistance = diference;
                            index = e;
                            }
                        else{if(minDistance > diference){
                            minDistance = diference;
                            index = e;
                        }                        
                        }
                    }
                    if(elevators[e].position < floor && elevators[e].state == direction && direction == 1){
                        diference = floor - elevators[e].position;
                        if (minDistance == -1){
                            minDistance = diference;
                            index = e;
                            }
                        else{if(minDistance > diference){
                            minDistance = diference;
                            index = e;
                        }                        
                        }
                    }
                    }
                }
            }
            if ((minDistance == -1)){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException exp){}
                }
        }
        return (index);
    }
    
    public void RequestElevator(int floorOri, int direction, int floorDest){ // direction can be only -1 for going down or 1 for going up.
        int index = this.searchElevador(floorOri, direction);               /* This method of calling RequestElevator should be used for testing purposes only,
        * since it wouln't make sense for an actual implemantation (the user only have option (buttont) to set an destination 
        * floor inside the eleator, not whe calling it)*/
        
        if (floorDest > elevators[index].maxFloor){ // this pair of ifs is just to make sure we dont pass a number of floor 
            floorDest = elevators[index].maxFloor;  // that the client culdn't possibly find the button for, insede the elevator.
        }
        if (floorDest <  elevators[index].minFloor){
            floorDest = elevators[index].minFloor;
        }
        elevators[index].destination.add(floorOri);
        if (elevators[index].state == 0){
            elevators[index].state = direction;
            elevators[index].run();
        }
        while (elevators[index].position != floorOri) {
            try{ Thread.sleep(1000);} catch(InterruptedException except){}
        }
        elevators[index].destination.add(floorDest);        
    }
    
    public void RequestElevator(int floorOri, int direction){ // direction can be only -1 for going down or 1 for going up.
        int index = this.searchElevador(floorOri, direction);   //this is the main RequestElevator function, used in normal operation.
       
        elevators[index].destination.add(floorOri);
        if (elevators[index].state == 0){
            elevators[index].state = direction;
            elevators[index].run();
        }
        }
}
