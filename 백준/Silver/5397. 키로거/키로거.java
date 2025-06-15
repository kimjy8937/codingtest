import java.util.*;
import java.io.*;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            String log = br.readLine();
            LinkedList<Character> al = new LinkedList<>();
            ListIterator<Character> cursor = al.listIterator();
            char[] cArr = log.toCharArray();
            
            for (char c : cArr) {
                switch(c) {
                    case '<':
                        if(cursor.hasPrevious())
                            cursor.previous();
                        break;
                    case '>':
                        if(cursor.hasNext())
                            cursor.next();
                        break;
                    case '-':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(c);
                        break;
                }
            }
            
            for(char c : al) {
                bw.write(c);
            }
            bw.write('\n');
        }
        bw.flush();
    }
}