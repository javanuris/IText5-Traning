package titles.notice.rus;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.notice.AbstractNoticeRusTitle;
import utils.FontUtil;

// id 9
public class CriminalFilingCaseNoticeRusTitle extends AbstractNoticeRusTitle {
    private static final String QR_CODE_VALUE = "http://eaias.supcourt.kz/QRP.nsf/QR.xsp?id=46257D470044C9D646257DA00003001A";

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(по результатам предварительного рассмотрения по уголовному делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(20f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {

        String demandTwoStr = String.format("      Надзорная судебная коллегия Верховного Суда Республики Казахстан в соответствии с ч. 4 ст. 491 УПК РК извещает Вас о том, что по результатам предварительного рассмотрения ходатайства вынесено постановление о возбуждении надзорного производства по пересмотру обжалуемого судебного акта и рассмотрении ходатайства в надзорной инстанции.");
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
        String descriptionStr = String.format("                         Список слушаний дел Вы можете просмотреть на www.sud.gov.kz\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов - с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
