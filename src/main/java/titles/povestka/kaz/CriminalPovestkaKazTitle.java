package titles.povestka.kaz;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.povestka.AbstractPovestkaKazTitle;

public class CriminalPovestkaKazTitle extends AbstractPovestkaKazTitle {
    @Override
    protected void setDemandThree(PdfPTable table) {

    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103);
    }
}
