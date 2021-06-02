/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.assignment.pkg4;

import java.util.ArrayList;

/**
 *
 * @author forbe
 */
public class aStar {
    
    public aStar(){
        
    }
    
    //generates and returns all nodes the current node is able to travel to
    public static ArrayList<node> generateSuccessors(world w, int x, int y){
        
        ArrayList<node> temp = new ArrayList<node>();
        
        //added checks to make sure doesnt add successors outside of box
        //also makes sure the block isn't blocked
        //top
        if(!(x == 0) && !(w.getWorld(x-1, y).getBlock().equals("[x]")))
        temp.add(w.getWorld(x-1, y));
        //left
        if(!(y == 0) && !(w.getWorld(x, y-1).getBlock().equals("[x]")))
        temp.add(w.getWorld(x, y-1));
        //right
        if(!(y == 14) && !(w.getWorld(x, y+1).getBlock().equals("[x]")))
        temp.add(w.getWorld(x, y+1));
        //bottom
        if(!(x == 14) && !(w.getWorld(x+1, y).getBlock().equals("[x]")))
        temp.add(w.getWorld(x+1, y));
        
        System.out.println(temp);
        
        return temp;
    }
}
