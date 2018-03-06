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

        int ic = 0;
        for (int i = 0; i < 17; i++) {
            Form103 form103 =  new Form103();
            form103.setF1(ic++ + "");
            form103s.add(form103);

        }

        new F119GenerateOnePage().generate(form103s);
    }


}

