package Algorithm.Strings;

import java.io.*;

public class RemoveComments {
    private static final char ASTERISK = '*';
    private static final char SLASH = '/';
    private static final char ANY_CHAR = 'c';

    public static String remove(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder newContent = new StringBuilder();
        String line;
        boolean openComment = false;

        while ((line = reader.readLine() )!= null){
            char previous = ANY_CHAR;
            int openIndex = -1;

            char[] arr = line.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if(openComment){
                    if(c == SLASH && previous == ASTERISK && openIndex < i -2){
                        openComment = false;
                    }
                }else{
                    if(c == ASTERISK && previous == SLASH){
                        openIndex = i -1;
                        openComment = true;
                        newContent.deleteCharAt(newContent.length() -1);
                    }else {
                        newContent.append(c);
                    }
                }
                previous = c;
            }

        }
        return newContent.toString();

    }

}
