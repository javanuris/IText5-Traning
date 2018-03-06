import dao.Form103Dao;
import dto.Form103;
import f119.F119GenerateOnePage;
import titles.postkz.DVDAstanaPostTitle;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Form103Dao form103Dao = new Form103Dao();
        List<Form103> form103s = new ArrayList<>();

        form103s.add(form103Dao.getForm103());
        form103s.add(form103Dao.getForm103());
        form103s.add(form103Dao.getForm103());
        form103s.add(form103Dao.getForm103());

        new F119GenerateOnePage().generate(form103s);
    }


}

