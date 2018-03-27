import dao.Form103Dao;
import dto.Form103;
import f119.F119GenerateOnePage;
import titles.postkz.DVDAstanaPostTitle;
import titles.postkz.LegalPostTitle;
import titles.povestka.CriminalPovestkaTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new CriminalPovestkaTitle().createTitle(dao.getForm103());


}

}


