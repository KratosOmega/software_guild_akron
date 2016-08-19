
public class CompareToChallenge {

    public static void main(String[] args) {
        // 5 examples return < 0
        System.out.println("*********> 5 Examples return < 0 <*********\n");
        System.out.print("Comparing \"abcde\" with \"fghij\" produces ");
        System.out.println("abcde".compareTo("fghij"));
        System.out.print("Comparing \"1\" with \"2\" produces ");
        System.out.println("1".compareTo("2"));
        System.out.print("Comparing \"12345\" with \"1235780459678\" produces ");
        System.out.println("12345".compareTo("1235780459678"));
        System.out.print("Comparing \"Kratos\" with \"Omega\" produces ");
        System.out.println("Kratos".compareTo("Omega"));
        System.out.print("Comparing \"12345\" with \"67890\" produces ");
        System.out.println("12345".compareTo("67890"));

        // 5 examples return > 0
        System.out.println("\n\n*********> 5 Examples return > 0 <*********\n");
        System.out.print("Comparing \"abcdefghijk\" with \"abcd\" produces ");
        System.out.println("abcdefghijk".compareTo("abcd"));
        System.out.print("Comparing \"kra tos\" with \"kra sott\" produces ");
        System.out.println("kra tos".compareTo("kra sott"));
        System.out.print("Comparing \"00000\" with \"0000\" produces ");
        System.out.println("00000".compareTo("0000"));
        System.out.print("Comparing \"asdfg\" with \"asdf\" produces ");
        System.out.println("asdfg".compareTo("asdf"));
        System.out.print("Comparing \"Krats\" with \"Kratos\" produces ");
        System.out.println("Krats".compareTo("Kratos"));

        // 2 examples return = 0
        System.out.println("\n\n*********> 2 Examples return = 0 <*********\n");
        System.out.print("Comparing \"1234\" with \"1234\" produces ");
        System.out.println("1234".compareTo("1234"));
        System.out.print("Comparing \"Krats\" with \"Kratos\" produces ");
        System.out.println("Kratos".compareTo("Kratos"));
    }
}
