import dao.Form103Dao;
import dto.Form103;
import f119.F119GenerateOnePage;
import titles.postkz.DVDAstanaPostTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {



public static void main(String[] args) {
        List<Form103> form103s = new ArrayList<>();
        Form103Dao dao = new Form103Dao();

        String str = "12346798";
        String [] arr = str.split("");

        for(int i = 0; i < str.length(); i++){
            System.out.println(arr[i]);
        }


         for (int i = 0; i < 7; i++) {
            form103s.add(dao.getForm103());
        }

        new F119GenerateOnePage().generate(form103s);


}

}


