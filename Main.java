import decoders.*;
import encoders.*;
import java.util.*;

public class Main {

    public static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
    public static String pallindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input type (analog/digital): ");
        String typeOfSignal = sc.nextLine().trim().toLowerCase();

        String data = "";
        String encoded = "";
        String decoded = "";

        // ANALOG SIGNAL
        if (typeOfSignal.equals("analog")) {
            System.out.println("Choose analog encoding method :");
            System.out.println("1. PCM (Pulse Code Modulation)");
            System.out.println("2. DM (Delta Modulation)");
            int choice = sc.nextInt();

    
            System.out.println("\n[Simulating Analog-to-Digital conversion...]");
            System.out.print("Enter data stream : ");
            data = sc.nextLine();  
            System.out.println("Generated Digital Bit Stream: " + data);
        } 
        // DIGITAL SIGNAL
        else if (typeOfSignal.equals("digital")) {
            System.out.print("Enter data stream: ");
            data = sc.nextLine();
        } 
        else {
            System.out.println("Invalid input type! Please choose analog or digital.");
            return;
        }

        // pallindrome
        String palindrome = pallindrome(data);
        System.out.println("\nLongest palindrome in input data: " + palindrome);

        // LINE ENCODING PRINT
        System.out.println("\nSelect Line Encoding Scheme:");
        System.out.println("1. NRZ-L");
        System.out.println("2. NRZ-I");
        System.out.println("3. Manchester");
        System.out.println("4. Differential Manchester");
        System.out.println("5. AMI");
        int choice = sc.nextInt();
        sc.nextLine();

        // SWITCH CHOICES
        switch (choice) {
            case 1 -> encoded = new NRZL().encode(data);
            case 2 -> encoded = new NRZI().encode(data);
            case 3 -> encoded = new Manchester().encode(data);
            case 4 -> encoded = new DiffManchester().encode(data);
            case 5 -> {
                System.out.print("scrambling? (yes/no): ");
                String ans = sc.nextLine().trim().toLowerCase();
                if (ans.equals("yes")) {
                    System.out.println("Select Scrambling Type:\n1. B8ZS\n2. HDB3");
                    int scr = sc.nextInt();
                    if (scr == 1) encoded = new B8ZS().encode(data);
                    else encoded = new HDB3().encode(data);
                } else {
                    encoded = new AMI().encode(data);
                }
            }
            default -> System.out.println("Invalid choice.");
        }

        System.out.println("\nEncoded Output:");
        System.out.println(encoded);

        if (encoded.contains("B8ZS") || encoded.contains("HDB3"))
            System.out.println("\nScrambled sequence generated successfully.");

        // DECODE SECTION
        System.out.println("\nDo you want to decode the encoded signal? (yes/no): ");
        String ans = sc.nextLine().trim().toLowerCase();

        // Will read same swit
        if (ans.equals("yes")) {
            switch (choice) {
                case 1 -> decoded = new NRZLDecoder().decode(encoded);
                case 2 -> decoded = new NRZIDecoder().decode(encoded);
                case 3 -> decoded = new ManchesterDecoder().decode(encoded);
                case 4 -> decoded = new DiffManchesterDecoder().decode(encoded);
                case 5 -> {
                    if (encoded.contains("B8ZS"))
                        decoded = new B8ZSDecoder().decode(encoded);
                    else if (encoded.contains("HDB3"))
                        decoded = new HDB3Decoder().decode(encoded);
                    else
                        decoded = new AMIDecoder().decode(encoded);
                }
            }

            System.out.println("\nDecoded Output:");
            System.out.println(decoded);
        }


        sc.close();
    }
}
// This file , takes input of type of signal , 
// then input for data 
// type of encoding 
// calls the encoding function 
// and print them 