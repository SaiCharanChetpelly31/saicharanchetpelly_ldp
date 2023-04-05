package assignment2;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String homeDir = System.getProperty("user.home");
//        File directoryPath = new File("Z:");
//        System.out.println(directoryPath);
//        //List of all files and directories
//        String contents[] = directoryPath.list();
        System.out.println("Searching files in " + homeDir);

        while(true){
            System.out.print("Enter a regular expression to search for files or 'quit' to exit: ");
            String regex = scanner.next();
            if (regex.equals("quit")) {
                break;
            }


            try {
                Pattern pattern = Pattern.compile(regex);
                searchFiles(homeDir, pattern);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
        private static void searchFiles(String dir, Pattern pattern) {
            File file = new File(dir);
            File[] files = file.listFiles(); //TC-O(N)
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        searchFiles(f.getAbsolutePath(), pattern);
                    } else {
                        Matcher matcher = pattern.matcher(f.getName());
                        if (matcher.matches()) {
                            System.out.println(f.getAbsolutePath());
                        }
                    }
                }
            }
    }
}

//Time complexity - O(N)
//Space complexity - O(N)
