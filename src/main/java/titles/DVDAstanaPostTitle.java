package titles;


import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import utils.FontUtil;

//Id type doc 19
public class DVDAstanaPostTitle extends AbstractPostTitle {

    @Override
    void sendInformation(PdfWriter writer, PdfPTable table, Form103 form103) {
        Phrase prescription = new Phrase("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением", FontUtil.openSansRegular(7));
        PdfPCell prescriptionCell = getConstruct().getPdfPCell(prescription);
        prescriptionCell.setPaddingTop(1);
        table.addCell(prescriptionCell);
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
    }
}
