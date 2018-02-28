import dao.Form103Dao;
import titles.DVDAstanaTitle;


public class Main {

    public static void main(String[] args) {
        Form103Dao form103Dao = new Form103Dao();
        new DVDAstanaTitle().createTitle(form103Dao.getForm103());

    }


}

