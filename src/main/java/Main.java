import dao.Form103Dao;
import qr_code.QRGenerator;
import titles.notice.kaz.CivilControlNoticeKazTitle;
import titles.notice.kaz.CivilPreviouslyNoticeKazTitle;
import titles.notice.kaz.CriminalRefusalNoticeKazTitle;
import titles.notice.rus.CivilControlNoticeRusTitle;
import titles.notice.rus.CivilPreviouslyNoticeRusTitle;
import titles.notice.rus.CriminalRefusalNoticeRusTitle;
import titles.povestka.kaz.CivilPovestkaKazTitle;
import titles.povestka.kaz.CriminalPovestkaKazTitle;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new CivilControlNoticeKazTitle().createTitle(dao.getForm103());
        QRGenerator qrGenerator = new QRGenerator();



}

}


