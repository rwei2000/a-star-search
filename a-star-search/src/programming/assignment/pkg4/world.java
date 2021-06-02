/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.assignment.pkg4;

import java.util.Random;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author forbe
 */
public class world extends Thread{
    
    //2d array of nodes
    private node[][] world = new node[15][15];
    
    private int check = 0;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    
    private boolean find;
    
    private ArrayList<node> path = new ArrayList<>();
    
    public world(){
        
        for(int x = 0; x < 15; x++){

            for (int y = 0; y < 15; y++){
                this.world[x][y] = new node();
                this.world[x][y].setX(x);
                this.world[x][y].setY(y);
                //debug
                //System.out.println(x + " " + y);
            }
        }
        
    }
    
    public void randomize(world w){
        //10% of 15*15 (its 22.5 but rounded up to 23)
        int temp = 23;
        
        Random r = new Random();
        
        ArrayList<Integer> randXs = new ArrayList<Integer>();
        ArrayList<Integer> randYs = new ArrayList<Integer>();
        
        //if the x and y arent contained at the same index 
        //check to see if the list contains x and y (with both x and y having the same index)
        boolean loop;
        for (int x = 0; x < 23; x++){
                loop = true;
                
                int randX = r.nextInt((15 - 0));
                int randY = r.nextInt((15 - 0));
                
                for(int y = 0; y < randXs.size(); y++){
                    if (randXs.get(y) == randX && randYs.get(y) == randY){
                        loop = false;
                    }
                }
                if (loop == true){
                    randXs.add(randX);
                    randYs.add(randY);
                }
                else{
                    x--;
                }

        }
        
        //debug
        /*
        System.out.println(randXs);
        System.out.println(randYs);
        System.out.println(randXs.size());
        System.out.println(randYs.size());
        */
        
        for (int z = 0; z < 23; z++){
            this.world[randXs.get(z)][randYs.get(z)].setBlock(true);
        }
        
    }
    
    public void visualize(world w){
        
        for(int x = 0; x < 15; x++){
            //for spacing
            System.out.println();
            for (int y = 0; y < 15; y++){
                System.out.print(this.world[x][y].getBlock());
                check++;
            }
        }
        
        System.out.println();
        //debug
        //System.out.println(check);
        
    }
    
    public void defineEnds(world w){
        
        Scanner in = new Scanner(System.in);
        
        //does not have checks for blocked spaces, nor non-existent spaces
        System.out.println("Please define start and end points. "
                + "\nPlease enter the coordinates (ONE AT A TIME) for the start row&column coordinates (respectively)"
                + "\nDo not use spaces that are currently X'd nor spaces that don't exist. "
                + "\nPlease stay within the 15x15 matrix (be mindful of the matrix being 0-14):");
        startX = in.nextInt();
        startY = in.nextInt();
        System.out.println("Please enter the coordinates for the end row&column corrdinates (respectively):"
                + "\nMake sure the coordinates are not the same as the starting points'");
        endX = in.nextInt();
        endY = in.nextInt();
        
        this.world[startX][startY].setStart(true);
        this.world[endX][endY].setEnd(true);
    }
    
    /*
    estimation function:
    distance from the end ex: 14 -14
    if at 13 - 8
    u are 7 distance away (14-13, 14-8)
    */
    public void newPath(){
        PriorityQueue<node> children = new PriorityQueue<>(1, new NodeComparator());
        ArrayList<node> tempList = new ArrayList<>();
        ArrayList<node> visited = new ArrayList<>();
        
        node tempQ = new node();
        
        int counter = 0;
        
        node starting = this.world[startX][startY];
        
        starting.setDistance(Math.abs(endX - starting.getX()) + Math.abs(endY - starting.getY()));
        
        //add start to children first
        children.add(starting);
        
        while (!(children.isEmpty())){
            //test
        //while(counter < 10){
            
            //find smallest child and remove it
            tempQ = children.poll();
            
            //add to path
            path.add(tempQ);
            
            //generate list of all steps w/ child
            tempList = GenerateSuc(tempQ, this);
            
            //sets templist nodes' distances
            for (node n: tempList){
                n.setDistance(Math.abs(endX - n.getX()) + Math.abs(endY - n.getY()));
            }
            
            //debug
            /*
            System.out.println("generated children + distance");
            for (int x = 0; x < tempList.size(); x++){
                System.out.println(tempList.get(x).getBlock() + tempList.get(x).getDistance());
            }
            */
            
            //sets templist nodes' distances
            for (node n: tempList){
                n.setDistance(Math.abs(endX - n.getX()) + Math.abs(endY - n.getY()));
            }
            
            //store these children in prio queue
            for (node n: tempList){
                //if u find the exit EXIT 
                if (n.getX() == endX && n.getY() == endY){
                    System.out.println("Found exit");
                    find = true;
                    return;
                }
                
                if (!(visited.contains(n))){
                    children.add(n);
                    visited.add(n);
                }
            }
            //debug
            //counter++;
        }
        
        if(children.isEmpty()){
            System.out.println("Can't find path");
            find = false;
        }
        
    }
    
    public void viewPath(){
        for(node n: path){
            try{
                this.sleep(500);
            } catch (InterruptedException x){
            }
            n.setPath();
            this.visualize(this);
        }
        
        if (find == true){
            System.out.println("Path found by A*");
        }
        else{
            System.out.println("No path could be found");
        }
        
        
    }
    
    public void noPath(){
        this.world[0][2].setBlock(true);
        this.world[1][1].setBlock(true);
        this.world[2][0].setBlock(true);
    }
    
    
    //"new" generate successors method (post adding coordinates to the nodes themselves)
    public ArrayList<node> GenerateSuc(node n, world w){
        ArrayList<node> temp = new ArrayList<node>();
        
        //top
        //if the node at x isn't [x] (blocked) and isn't 0 (therefore breaking the matrix) add node
        if (!(n.getX() == 0)){
        if (!(w.getWorld(n.getX()-1, n.getY()).getBlock().equals("[x]"))){
                temp.add(w.getWorld(n.getX()-1, n.getY()));
            }
        }
        //right
        if (!(n.getY() == 0)){
        if (!(w.getWorld(n.getX(), n.getY()-1).getBlock().equals("[x]"))){
                temp.add(w.getWorld(n.getX(), n.getY()-1));
            }
        }
        //left
        if (!(n.getY() == 14)){
        if (!(w.getWorld(n.getX(), n.getY()+1).getBlock().equals("[x]"))){
                temp.add(w.getWorld(n.getX(), n.getY()+1));
            }
        }
        //bottom
        if (!(n.getX() == 14)){
        if (!(w.getWorld(n.getX()+1, n.getY()).getBlock().equals("[x]"))){
                temp.add(w.getWorld(n.getX()+1, n.getY()));
            }
        }
        
        return temp;
    }
    
    public node getWorld(int x, int y) {
        return world[x][y];
    }
    
    
    

}
