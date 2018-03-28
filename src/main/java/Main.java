import dao.Form103Dao;
import qr_code.QRGenerator;
import titles.povestka.rus.AdministrativePovestkaRusTitle;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new AdministrativePovestkaRusTitle().createTitle(dao.getForm103());
        QRGenerator qrGenerator = new QRGenerator();



}

}


