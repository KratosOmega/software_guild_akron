/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceexample;

/**
 *
 * @author apprentice
 */
public class SummerIntern extends Employee {
    private String school;
    
    public SummerIntern(String nameIn, String ssnIn) {
        // calls Employee constructor
        super(nameIn, ssnIn);
        System.out.println("SummerIntern: Constructor(String, String)");
    }
    
    public SummerIntern(String nameIn, String ssnIn, String schoolIn) {
        // calls the Employee constructor
        super(nameIn, ssnIn);
        this.school = schoolIn;
        System.out.println("SummerIntern: Constuctor(String, String, String");
    }

    public void requestPerformanceReview() {
        System.out.println("SummerIntern: requestPerformanceReview()");
    }
    
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    // we MUST implement this method b/c it was declared as abstract in employee
    @Override
    public void createObjectives() {
        System.out.println("SummerIntern: createObjectives");
    }
    
    
}
