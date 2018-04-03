package titles.common;


import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import utils.FontUtil;

//id_type_doc = 19
public class DVDAstanaPostTitle extends AbstractPostTitle {

    @Override
    void setPresentation(PdfWriter writer, PdfPTable table, Form103 form103) {
        Phrase prescription = new Phrase("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением", FontUtil.openSansRegular(7));
        PdfPCell prescriptionCell = getPdfPCell(prescription);
        prescriptionCell.setPaddingTop(1);
        table.addCell(prescriptionCell);
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
    }
}
