/*
 * Question 1: It is not necessary, since "carpool_capacity" is a double variable, the value assignment to it will automatically converted to floating point number. Thus, if change 4.0 to 4, the result will be the same
 *
 * Question 2: The term floating point is derived from the fact that there is no fixed number of digits before and after the decimal point; that is, the decimal point can float. There are also representations in which the number of digits before and after the decimal point is set, called fixed-pointrepresentations.
 *
 * Question 3: The comments are added in the source code.
 *
 * Question 4: "=" is called "equals" sign, it is used to assign value to variable.
 *
 * Question 5: "_" is "underscore" character, it is used to put an imaginary space between words in variable names, so that the variable names can be more readable.
 *
 */

public class VariablesAndNames
{
    public static void main( String[] args )
    {
        int cars, drivers, passengers, cars_not_driven, cars_driven;
        double space_in_a_car, carpool_capacity, average_passengers_per_car;

        // whole number "100" is assigned to int variable "cars"
        cars = 100;
        // Floating point number "4.0" is assigned to double variable "space_in_a_car" (althought 4 can also be used to assign to double variable)
        space_in_a_car = 4.0;
        // whole number "30" is assigned to int variable "drivers"
        drivers = 30;
        // whole number "90" is assigned to int variable "passengers"
        passengers = 90;
        // The result of calculation of (100 - 30) which is whole number "70" is assigned to int variable "cars_not_driven"
        cars_not_driven = cars - drivers;
        // int variable "drivers"'s whole number value "30" is assigned to int variable "cars_driven"
        cars_driven = drivers;
        // The result of calculation of (30 * 4.0) which is floating point number "120.0" is assigned to double variable "carpool_capacity"
        carpool_capacity = cars_driven * space_in_a_car;
        // The result of calculation of (90 / 30) which is whole number "7" is assigned to double variable "average_passengers_per_car". Notice that "7" is automatically converted into floating point number when it is assigned to a double variable
        average_passengers_per_car = passengers / cars_driven;


        System.out.println( "There are " + cars + " cars available." );
        System.out.println( "There are only " + drivers + " drivers available." );
        System.out.println( "There will be " + cars_not_driven + " empty cars today." );
        System.out.println( "We can transport " + carpool_capacity + " people today." );
        System.out.println( "We have " + passengers + " to carpool today." );
        System.out.println( "We need to put about " + average_passengers_per_car + " in each car." );
    }
}
