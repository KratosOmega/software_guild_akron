/*
 * Question 1:
 *  - "else if" is triggered if its previous "if" statement is false, then it will do another decision of either execute its following codes or ignore them base on the "true" or "false" values which are passed into it parentheses.
 *  - "else" is triggered and execute its code block, if its previous "if" statement is false. It is different from the "else if" since it will not make any further decision.
 * Question 2:
 *  - First of all, by removing the "else" in "else if" will break the "if" & "else if" structure, thus the second "if" make decision that is not base on the first "if".
 *  - This is because "if" is used as a beginnig signal of the decision making process, and "else" is used as a continuing signal of the decision making process.
 *  - Thus, in this case, if we remove the "else" from the "else if", it will  make  differences to the displayed result, since the logic had been change.
 */

public class ElseAndIf {

    public static void main(String[] args) {
        int people = 30;
        int cars = 40;
        int buses = 15;

        if (cars > people) {
            System.out.println("We should take the cars.");
        } //else if (cars < people) {
          if (cars < people) { // This line has the "else" removed
            System.out.println("We should not take the cars.");
        } else {
            System.out.println("We can't decide.");
        }

        if (buses > cars) {
            System.out.println("That's too many buses.");
        } else if (buses < cars) {
            System.out.println("Maybe we could take the buses.");
        } else {
            System.out.println("We still can't decide.");
        }

        if (people > buses) {
            System.out.println("All right, let's just take the buses.");
        } else {
            System.out.println("Fine, let's stay home then.");
        }

    }
}
