import dao.Form103Dao;
import titles.postkz.DVDAstanaPostTitle;
import titles.postkz.PostLegalTitle;


public class Main {

    public static void main(String[] args) {
        Form103Dao form103Dao = new Form103Dao();
        new DVDAstanaPostTitle().createTitle(form103Dao.getForm103());
    }


}

