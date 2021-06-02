/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.assignment.pkg4;

import java.util.Scanner;

/**
 *
 * @author forbe
 */
public class ProgrammingAssignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //worldRunning temp = new worldRunning();
        //world temp = new world();
        
        boolean running = true;
        String input = "";
        
        Scanner in = new Scanner(System.in);
        /*
        temp.visualize(temp);
        temp.randomize(temp);
        temp.noPath();
        temp.visualize(temp);
        temp.defineEnds(temp);
        temp.visualize(temp);
        temp.newPath();
        temp.visualize(temp);
        temp.viewPath();
        temp.visualize(temp);
        */

        while(running = true){
            
            System.out.println("Would you like make a new world? (Y/N) \n"
                    + "Type 'F' to create a world where a path cannot be found");
            input = in.nextLine();
            
            if (input.equals("y") || input.equals("Y")){
                
                world temp = new world();
                
                input = "";
                
                temp.visualize(temp);
                System.out.println("Randomizing");
                temp.randomize(temp);
                temp.visualize(temp);
                temp.defineEnds(temp);
                temp.visualize(temp);
                temp.newPath();
                temp.visualize(temp);
                temp.viewPath();
            }
            else if (input.equals("n") || input.equals("N")){
                
                input = "";
                
                System.out.println("Do you wish to quit? (Y/N)");
                input = in.nextLine();
                
                if (input.equals("y") || input.equals("Y")){
                    
                    input = "";
                    
                    running = false;
                    return;
                }
                else if (input.equals("n") || input.equals("N")){
                    
                    input = "";
                }
                else{
                    System.out.println("Invalid input");
                }
            }
            else if (input.equals("f") || input.equals("F")){
                
                world temp = new world();
                
                input = "";
                
                temp.visualize(temp);
                temp.noPath();
                temp.visualize(temp);
                temp.defineEnds(temp);
                temp.visualize(temp);
                temp.newPath();
                temp.visualize(temp);
                temp.viewPath();
                
            }
            else{
                
                input = "";
                
                System.out.println("Invalid input");
            }
            
        }
    }
    
}
