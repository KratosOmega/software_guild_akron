/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceexample;

/**
 *
 * @author apprentice
 */
public class Manager extends Employee {
    
    // Since Imployee does not have a default constructor
    // we must implement a String,String constructor
    public Manager(String nameIn, String ssnIn) {
        // call the Employee constructor and have it set name and ssn
        // Remember that the super call must the first non-comment line
        // in the constructor
        super(nameIn, ssnIn);
        System.out.println("Manager: Constructor(String,String)");
    }
    
    public void hire() {
        System.out.println("Manager: hire()");
    }
    
    public void fire() {
        System.out.println("Manager: fire()");
    }
    
    @Override
    public void createObjectives() {
        System.out.println(name);
        System.out.println("Manager: createObjectives()");
    }
}
