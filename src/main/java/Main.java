import dao.Form103Dao;
import qr_code.QRGenerator;
import titles.notice.CriminalRefusalNoticeTitle;
import titles.povestka.rus.CriminalPovestkaRusTitle;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new CriminalRefusalNoticeTitle().createTitle(dao.getForm103());
        QRGenerator qrGenerator = new QRGenerator();



}

}


