package titles.povestka.rus;


import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.povestka.AbstractPovestkaRusTitle;

public class CriminalPovestkaRusTitle extends AbstractPovestkaRusTitle {

    @Override
    protected void setDemandThree(PdfPTable table) {

    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103);
    }


}
