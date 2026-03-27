import java.util.*;
import java.io.*;

public class Main{
    static class Person{
        int age;
        String name;
        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(age, name));            
        }
        
        Collections.sort(list, (a, b) -> a.age - b.age);
        for (Person p : list) {
            sb.append(p.age).append(' ').append(p.name).append('\n');
        }

        System.out.print(sb);
        
    }
}