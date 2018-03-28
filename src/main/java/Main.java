import dao.Form103Dao;
import qr_code.QRGenerator;
import titles.povestka.AbstractPovestkaTitle;
import titles.povestka.AdministrativePovestkaTitle;
import titles.povestka.CriminalPovestkaTitle;


public class Main {



public static void main(String[] args) {
        Form103Dao dao = new Form103Dao();

        new AdministrativePovestkaTitle().createTitle(dao.getForm103());
        QRGenerator qrGenerator = new QRGenerator();



}

}


