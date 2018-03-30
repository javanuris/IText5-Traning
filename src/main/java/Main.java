import dao.Form103Dao;
import qr_code.QRGenerator;
import titles.notice.kaz.*;
import titles.notice.rus.*;
import titles.povestka.kaz.CivilPovestkaKazTitle;
import titles.povestka.kaz.CriminalPovestkaKazTitle;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new CriminalControlNoticeKazTitle().createTitle(dao.getForm103());
        QRGenerator qrGenerator = new QRGenerator();



}

}


