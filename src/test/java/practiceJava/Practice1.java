package practiceJava;

import java.util.ArrayList;
import java.util.List;

public class Practice1 {

    public int countYZ(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == 'y' && !Character.isLetter(str.charAt(i - 1))) || (str.charAt(i) == 'z' && !Character.isLetter(str.charAt(i - 1)))) {
                count++;
            }
            if ((str.indexOf('y') == str.length() - 1) || (str.indexOf('z') == str.length() - 1)) {
                count++;
            }
        }
        return count;
    }

    public String withoutX2(String str) {
        for (int i = 0; i < 2; i++){
            if(str.charAt(i) == 'x'){
                str.replace('x',' ');
            }
        }
        String withoutSpaces = str.replace(" ", "");
        return withoutSpaces;

    }

    public static void main(String[] args) {
        String str = "Hello,   World!";
        String withoutSpaces = str.replace(" ", "");
        System.out.println(withoutSpaces);

        List<String> asd = new ArrayList<>();
        asd.add("asd");
        asd.add("qwe");
        asd.add("tre");
        for(String s : asd){
            if(s.equals("qwe")){
                asd.remove(s);
            }
        }
        for(String s : asd){
            System.out.println(s);
        }
    }
}
