import dao.Form103Dao;
import titles.single.notice.rus.CivilPreviouslyNoticeRusTitle;


public class Main {


    public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();
        new CivilPreviouslyNoticeRusTitle().createTitle(dao.getForm103());
        }

}


