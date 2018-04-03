package titles.single.povestka.kaz;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.povestka.AbstractPovestkaKazTitle;

//id_type_doc = 1, id_subtype_doc = 3, lang = 1;
public class CriminalPovestkaKazTitle extends AbstractPovestkaKazTitle {
    @Override
    protected void setDemandThree(PdfPTable table) {

    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103.getF16());
    }
}
