import dao.Form103Dao;
import dto.Form103;
import single_title_gen.SingleGenerator;
import titles.single.notice.rus.CivilPreviouslyNoticeRusTitle;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();
        List<Form103> form103s = new ArrayList<>();
        for (int i = 0; i <10 ; i++){
            form103s.add(dao.getForm103());
        }

        new SingleGenerator().generate(form103s);
        }

}


