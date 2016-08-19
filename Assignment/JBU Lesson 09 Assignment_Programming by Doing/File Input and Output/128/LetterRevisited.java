
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LetterRevisited{
    public static void main(String[] args) throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter("letter.txt"));
        writer.println("+----------------------------------------------------------------------------+");
        writer.println("|                                                                       #### |");
        writer.println("|                                                                       #### |");
        writer.println("|                                                                       #### |");
        writer.println("|                                                                            |");
        writer.println("|                                                                            |");
        writer.println("|                                                      Xin Li                |");
        writer.println("|                                                      123 Clifftop Drive    |");
        writer.println("|                                                      Rockville, MD 12345   |");
        writer.println("|                                                                            |");
        writer.println("+----------------------------------------------------------------------------+");
        writer.flush();
        writer.close();
    }
}
