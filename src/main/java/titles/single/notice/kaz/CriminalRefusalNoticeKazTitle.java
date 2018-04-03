package titles.single.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

//id 8
public class CriminalRefusalNoticeKazTitle extends AbstractNoticeKazTitle {
    private static final String QR_CODE_VALUE = "http://eaias.supcourt.kz/QRP.nsf/QR.xsp?id=46257D470044C9D646257DA00003001A";

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Қылмыстық іс бойынша алдын ала қараудың нәтижелері бойынша)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(63f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("     Қазақстан Республикасының Жоғарғы Соты  Сізге ҚР ҚПК-нің 491-бабы 1-бөлігінің 1-тармағына  сәйкес, өтінішхатты  алдын ала қарау нәтижесі бойынша %s %s қатысты өтінішхатты іспен бірге кассациялық сатыдағы сот отырысының қарауына беру туралы қаулы шығарылғанын хабарлайды.", form103.getF6(), form103.getF7());
        addTextToPart(table, text1, 15);

        String text2 = String.format("     ҚР ҚПК-нің 492-бабына сәйкес қылмыстық істі қарау Астана қаласы  \n" +
                "     Д. Қонаев көшесі, 39-үй мекенжайы бойынша %s тағайындалды.", form103.getF8());
        addTextToPart(table, text2, 1);

        String text3 = String.format("    ҚР ҚПК-нің 494-бабының 1-бөлігіне сәйкес, тиісінше хабардар етілген тараптар келмеген не олардан тиісті арыз келіп түскен жағдайда, іс олардың қатысуынсыз қаралуы мүмкін.", form103.getF8());
        addTextToPart(table, text3, 1);

        String text4 = String.format("    Электрондық құжаттармен (өтінішхаттың көшірмесімен) танысу үшін Жоғарғы Сот сайтындағы «Сот құжаттарын қарау» модулінде Штрихті Почталық Идентификатордың (ШПИ) сәйкестендіру нөмірін (оң жақ жоғарғы бұрышта) және сот хабарламасында көрсетілген сот отырысы белгіленген күнді енгізу қажет.");
        addTextToPart(table, text4, 1);
    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("          Егер Сіз «Сот кабинеті» электрондық сервисін пайдаланушы болып табылсаңыз\n" +
                "              www.oficce.sud.kz сайтында қаулымен онлайн режимінде таныса аласыз.\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан \n" +
                "  1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға\n" +
                "                                                                                  болады.");
        addTextToPart(table, text1, 1);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, QR_CODE_VALUE);
    }

}
