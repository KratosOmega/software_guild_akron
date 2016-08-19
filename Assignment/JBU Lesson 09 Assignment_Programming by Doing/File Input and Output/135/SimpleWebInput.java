import java.net.URL;
import java.util.Scanner;

public class SimpleWebInput
{
	public static void main(String[] args) throws Exception
	{
		URL mcool = new URL("https://cs.leanderisd.org/mitchellis.txt");
    URL textFiles = new URL("http://textfiles.com/computers/mrdos1.txt");
    String lines = "";
		Scanner webIn = new Scanner( mcool.openStream() );

    while(webIn.hasNextLine()){
        lines = webIn.nextLine();
        System.out.println(lines);
    }

    System.out.println("\n\n******************* Another Web TXT File *******************\n\n");

    webIn = new Scanner(textFiles.openStream());
    while(webIn.hasNextLine()){
        lines = webIn.nextLine();
        System.out.println(lines);
    }

		webIn.close();
	}
}

