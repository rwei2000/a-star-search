/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.assignment.pkg4;

/**
 *
 * @author forbe
 */
public class node {
    
    //true means yea, false means nah
    private boolean blocked;
    private boolean start;
    private boolean end;
    private boolean path;
    
    //for location x is row y is column
    private int x;
    private int y;
    
    //distance
    private int distance = 9999;
    
    private String state;
    
    public node(){
        this.blocked = false;
        this.state = "[ ]";
    }
    
    public String getBlock(){
        return state;
    }
    
    public void setBlock(boolean blocked){
        this.blocked = blocked;
        
        if(blocked = true){
            state = "[x]";
        }
        else{
            state = "[ ]";
        }
    }
    
    public void setStart(boolean start){
        this.start = start;
        
        state = "[S]";
    }
    
    public void setEnd(boolean end){
        this.end = end;
        
        state = "[E]";
    }
    
    public boolean getStart(){
        return this.start;
    }
    
    public boolean getEnd(){
        return this.end;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public void setPath(){
        state = "[-]";
    }

    @Override
    public String toString() {
        return "node{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
