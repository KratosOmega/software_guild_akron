/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceexample;

/**
 *
 * @author apprentice
 */
public class InheritanceExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This code doesn't work because Employee is an abstract object
        // and you cannot instantiate an abstract object
        //        System.out.println("Constructing Employee Object:");
//        Employee emp = new Employee("John Doe", "444-44-4444");
//        emp.doWork();
//        emp.createObjectives();
//        System.out.println(emp.getName() + " " + emp.getSsn());
        
        System.out.println("Constructing Manager Object:");
        Manager mgr = new Manager("Super Manager", "333-33-3333");
        mgr.doWork();
        mgr.createObjectives();
        mgr.hire();
        mgr.fire();
        
        System.out.println("Constructing SummerIntern Object:");
        SummerIntern intern = new SummerIntern("Sally Smith", "111-22-3333", "UT");
        intern.requestPerformanceReview();
        
        System.out.println("Constructing Ceo Object:");
        Ceo ceo = new Ceo("Super CEO", "444-22-1111");
        ceo.acquireCompany();
        ceo.hire();
        ceo.doWork();
        ceo.createObjectives();
    }
}
