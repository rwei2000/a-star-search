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
public class worldRunning {
    
    public worldRunning(){
        
    }
    
    public void createWorld(){
        
        world temp = new world();
        
        System.out.println("[ World Created ]");
        
        temp.visualize(temp);
        
    }
    
    
    //unused code dump ALL FROM WORLD
    
        /*
    //generates and returns all nodes the current node is able to travel to
    public ArrayList<node> generateSuccessors(world w, int x, int y){
        
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
    */
    
    /*
    estimation function:
    distance from the end ex: 14 -14
    if at 13 - 8
    u are 7 distance away (14-13, 14-8)
    */
    /*
    public void testFindPath(){
        ArrayList<node> children = new ArrayList<>();
        ArrayList<node> tempList = new ArrayList<>();
        
        //add starting node as first node
        System.out.println("added first node");
        children.add(this.world[startX][startY]);
        
        while (!(children.isEmpty())){
           
            node tempQ = new node();
        
            //find node with smallest distance | should be start node first
            for (node n: children){
                System.out.println("finding smallest");
                //set nodes' distances
                n.setDistance(endX - n.getX() + endY - n.getY());
                
                //finds and sets smallest node
                if (n.getDistance() < tempQ.getDistance()){
                    System.out.println("found new smallest");
                    tempQ = n;
                    System.out.println(tempQ.getDistance());
                }
            }
            
            //remove smallest node from list
            System.out.println("removed smallest");
            children.remove(tempQ);
            
            //generate successors and set it equal to temp list
            tempList = GenerateSuc(tempQ, this);
            
            //if any of the successors are either the goal, 
            for (node n: tempList){
                if (n.getX() == endX && n.getY() == endY){
                    tempList.add(n);
                    break;
                }
                else{
                    children.add(n);
                }
            }
            
            tempList.add(tempQ);
        }
        
        
    }
    */
    
    /*
    estimation function:
    distance from the end ex: 14 -14
    if at 13 - 8
    u are 7 distance away (14-13, 14-8)
    */
    /*
    public void findPath(){
        
        ArrayList<node> children = new ArrayList<>();
        ArrayList<node> path = new ArrayList<>();
        ArrayList<node> tempList = new ArrayList<>();
        
        //add starting node as first node
        System.out.println("added first node");
        children.add(this.world[startX][startY]);
        
        int counter = 0;
        
        //generate list of all possible steps from current pos
        //select closest child and repeat until no children or find goal
        while (counter < 10){
            
            node tempQ = new node();
            
            
            for (node n: children){
                //set nodes' distances
                n.setDistance(endX - n.getX() + endY - n.getY());
         }
        
        //find node with smallest distance | should be start node first
            for (node n: children){
                System.out.println("finding smallest");
                
                //finds and sets smallest node
                if (n.getDistance() < tempQ.getDistance()){
                    System.out.println("found new smallest");
                    tempQ = n;
                    System.out.println(tempQ.getDistance());
                }
            }
            
            path.add(tempQ);
            this.world[tempQ.getX()][tempQ.getY()].setPath();
            
        System.out.println("gen'd children");
        tempList = GenerateSuc(tempQ, this);
        
         for (node n: tempList){
                //set nodes' distances
                n.setDistance(endX - n.getX() + endY - n.getY());
         }
        
        for (int x = 0; x < tempList.size(); x++){
        System.out.println(tempList.get(x).getBlock() + tempList.get(x).getDistance());
        }
        
        node temp = new node(); 
        
        System.out.println("goal?");
        for(node n: tempList){
            if (n.getBlock().equals("[E]")){
                System.out.println("FOUNDGOAL");
                System.out.println(path.toString());
                return;
            }
        }
        
        //sorts for prio queue
        System.out.println("SORTING");

        
        //PriorityQueue<node> pq = new PriorityQueue<>();
        
        //for (node n: tempList){
        //    pq.add(n);
        //}
        //System.out.println(pq.poll().getDistance());
        
        for (node n: tempList){
            for (int i = 1; i > tempList.size(); i--){
                if (tempList.get(i).getDistance() < tempList.get(i-1).getDistance()) 
                    {
                        temp = tempList.get(i);
                        tempList.get(i).equals(tempList.get(i-1));
                        tempList.get(i-1).equals(temp);
                    }
            }
        }
        
        
        System.out.println("sorted children");
        for (int x = 0; x < tempList.size(); x++){
        System.out.println(tempList.get(x).getBlock() + tempList.get(x).getDistance());
        }
        
        //store children to prio queue based on distance
        System.out.println("setting children to tempList");
        children = tempList;
        
        this.visualize(this);
        
        counter++;
        }
        
        
        
    }
    */
}
