package titles.povestka.rus;


import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.povestka.AbstractPovestkaRusTitle;

//id_type_doc = 1, id_subtype_doc = 3, lang = 1;
public class CriminalPovestkaRusTitle extends AbstractPovestkaRusTitle {

    @Override
    protected void setDemandThree(PdfPTable table) {

    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103.getF16());
    }


}
