/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceexample;

/**
 *
 * @author apprentice
 */
public abstract class Employee {
    // protected means these are visible in derived classes
    protected String name;
    protected String ssn;
    
    public Employee(String nameIn, String ssnIn) {
        // initialize fields in our object
        this.name = nameIn;
        this.ssn = ssnIn;
        // print out so we know when this constructor runs
        System.out.println("Employee: Constructor(String String");
    }
    
    // provide default constructor for this class in case any of our derived clases
    // don't provide constructors
//    public Employee() {
//        System.out.println("Employee: Constructor()");
//    }

    public void doWork() {
        System.out.println("Employee: doWork()");
    }
    
    // abstract means that all derived classes MUST provide an implementation for
    // this method
    public abstract void createObjectives();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    
    
}
