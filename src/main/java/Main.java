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


        for (int i = 0; i < 6; i++) {
            Form103 form103 = new Form103();
            form103.setF6("" + i);
            form103s.add(form103);
        }

        new F119GenerateOnePage().generate(form103s);
    }

}


