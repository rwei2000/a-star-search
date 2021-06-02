/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.assignment.pkg4;
import java.util.*;

/**
 *
 * @author forbe
 */
public class NodeComparator implements Comparator<node>{
    
    public int compare(node n1, node n2){
        if (n1.getDistance() > n2.getDistance())
            return 1;
        else if (n1.getDistance() < n2.getDistance())
            return -1;
        return 0;
    }
}
