package titles.povestka;


import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;

public class CriminalPovestkaTitle extends AbstractPovestkaTitle {

    @Override
    protected void setDemandThree(PdfPTable table) {

    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103);
    }
}
