package titles.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

// id 9
public class CriminalFilingCaseNoticeKazTitle extends AbstractNoticeKazTitle{
    private static final String QR_CODE_VALUE = "http://eaias.supcourt.kz/QRP.nsf/QR.xsp?id=46257D470044C9D646257DA00003001A";

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Қылмыстық іс бойынша алдын ала қараудың нәтижелері бойынша)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(55f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {

        String demandTwoStr = String.format("      Қазақстан Республикасы Жоғарғы Сотының қылмыстық істер жөніндегі қадағалаушы сот алқасы Сізге ҚР ҚПК-нің 491-бабының 4-бөлігіне сәйкес, өтінішхатты алдын ала қараудың нәтижелері бойынша шағым жасалып отырған сот актiсiн қайта қарау бойынша қадағалау iс жүргiзуiн қозғау және өтінішхатты қадағалау сатысында қарау туралы қаулы шығарылғанын хабарлайды.");
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandTwo, 1);

    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, QR_CODE_VALUE);

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        createFooterAdditionalInfo(table, form103);

        setTablePosition(writer, table, 64f, 210f);
        gepContacts(writer);
        gepCopyright(writer);
    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String descriptionStr = String.format("                         www.sud.gov.kz сайты арқылы істерді қарау мүмкіндігіңіз бар.\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан 1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға болады.");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
