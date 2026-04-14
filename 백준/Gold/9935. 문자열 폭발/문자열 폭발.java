import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            // 끝부분 검사
            if (sb.length() >= bombLen) {
                boolean isMatch = true;

                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                // 폭발
                if (isMatch) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}