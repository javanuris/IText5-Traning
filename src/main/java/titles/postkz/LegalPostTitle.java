package titles.postkz;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;

//id_type_doc = 18
public class LegalPostTitle extends AbstractPostTitle {

    @Override
    void setPresentation(PdfWriter writer, PdfPTable table, Form103 form103) {
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {

    }
}
