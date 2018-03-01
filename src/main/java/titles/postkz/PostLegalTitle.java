package titles.postkz;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;

//Id type doc 18
public class PostLegalTitle extends AbstractPostTitle {

    @Override
    void sendInformation(PdfWriter writer, PdfPTable table, Form103 form103) {
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {

    }
}
