package titles.single.notice.rus;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeRusTitle;
import utils.FontUtil;

//id 7
public class CriminalPreviouslyNoticeRusTitle extends AbstractNoticeRusTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(назначение предварительного рассмотрения ходатайства по уголовному делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(35f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("      Верховный Суд Республики Казахстан извещает Вас о том, что в соответствии со ст.492 УПК РК рассмотрение уголовного дела в отношении %s %s назначено на %s по адресу: г. Астана, ул. Д. Кунаева, д.39 (Левый берег р. Ишим).", form103.getF6(), form103.getF7(), form103.getF10());
        addTextToPart(table, text1, 1);

        String text2 = String.format("     На основании ч.1 ст.494 УПК РК, дело может быть рассмотрено без участия надлежаще извещенных сторон в случае их неявки либо поступления от них соответствующего заявления.");
        addTextToPart(table, text2, 15);

        String text3 = String.format("     Для ознакомления с электронным документом (копия протеста, представления) необходимо на сайте Верховного Суда в модуле «Просмотр судебных документов» ввести идентификационный номер ШПИ (в правом верхнем углу) и дату назначения судебного заседания, указанные в судебном извещении.");
        addTextToPart(table, text3, 1);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103.getF12());

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        createFooterAdditionalInfo(table, form103);

        setTablePosition(writer, table, 64f, 210f);
        gepContacts(writer);
        gepCopyright(writer);
    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("                         Список слушаний дел Вы можете просмотреть на www.sud.gov.kz\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов - с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).");
        addTextToPart(table, text1, 1);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
