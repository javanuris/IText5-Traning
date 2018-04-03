package titles.single.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

//id 7
public class CriminalPreviouslyNoticeKazTitle extends AbstractNoticeKazTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Қылмыстық іс бойынша өтінішхатты алдын ала қарауға тағайындау)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(40f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("     Қазақстан Республикасының Жоғарғы Соты ҚР ҚПК-нің 492-бабына сәйкес, Сізге %s %s қатысты наразылығы, облыстық төрағасының ұсынуы бойынша) қылмыстық істі қарау Астана қаласы, Д. Қонаев көшесі, 39-үй мекенжайы бойынша %s тағайындалғанын хабарлайды.", form103.getF6(), form103.getF7(), form103.getF10());
        addTextToPart(table, text1, 1);

        String text2 = String.format("      ҚР ҚПК-нің 494-бабының 1-бөлігіне сәйкес, тиісінше хабардар етілген тараптар келмеген не олардан тиісті арыз келіп түскен жағдайда, іс олардың қатысуынсыз қаралуы мүмкін.");
        addTextToPart(table, text2, 15);

        String text3 = String.format("     Электрондық құжаттармен (өтінішхаттың көшірмесімен, наразылықпен, ұсынумен) танысу үшін Жоғарғы Сот сайтындағы «Сот құжаттарын қарау» модулінде Штрихті Почталық Идентификатордың (ШПИ) сәйкестендіру нөмірін (оң жақ жоғарғы бұрышта) және сот хабарламасында көрсетілген сот отырысы белгіленген күнді енгізу қажет.");
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
        String text1 = String.format("                         www.sud.gov.kz сайты арқылы істерді қарау мүмкіндігіңіз бар.\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан 1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға болады.");
        addTextToPart(table, text1, 1);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
