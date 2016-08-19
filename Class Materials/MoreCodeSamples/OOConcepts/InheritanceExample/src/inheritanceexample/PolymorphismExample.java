/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceexample;

/**
 *
 * @author apprentice
 */
public class PolymorphismExample {
    
    public static void main (String[] args) {
        Employee emp = new Manager("John Doe", "111-33-5555");
        emp.doWork();
        emp.createObjectives();
        
        Manager mgr = (Manager)emp;
        mgr.createObjectives();
        mgr.fire();
        
        Employee emp2 = new SummerIntern("Sally Smith", "111-22-3333");
        emp2.doWork();
        emp2.createObjectives();
        
        Employee emp3 = new Ceo("Ceo Jones", "222-11-3333");
        emp3.createObjectives();
    }
    
}
