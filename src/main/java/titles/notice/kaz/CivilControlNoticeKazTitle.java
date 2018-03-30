package titles.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

//id 6
public class CivilControlNoticeKazTitle extends AbstractNoticeKazTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Азаматтық іс бойынша қадағалау сот сатысының отырысына шақырту)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(35f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String demandTwoStr = String.format("      Қазақстан Республикасының Жоғарғы Соты Сізге Қазақстан Республикасы Азаматтық процестік кодексінің 445-бабына сәйкес, %s өтінішхаты (Бас Прокурордың наразылығы, Жоғарғы Сот Төрағасының ұсынуы) бойынша талапкер %s жауапкер %s туралы талап арызына орай қозғалған азаматтық іс бойынша кассациялық сатыдағы сот отырысы Астана қаласы, Есіл өзенінің сол жақ жағалауы, Д. Қонаев көшесі, 39-үй мекенжайы бойынша %s тағайындалғанын хабарлайды.", form103.getF9(), form103.getF6(), form103.getF7(), form103.getF10());
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(9));
        addCell(table, demandTwo, 1);

        String demandOneStr = String.format("      ҚР АПК-нің 58, 60-баптарына сәйкес, іске қатысушы адамдардың өкілдері: 1) заңға сәйкес берілген және ресімделген сенімхатты, адвокаттар – қосымша ордерді; 2) өкілдікті жүзеге асыруға арналған тапсырманы куәландыратын құжаттарды; 3) жоғары заңгерлік білімі бар екенін растайтын құжатты (дипломның көшірмесін) ұсынулары қажет.");
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(9));
        addCell(table, demandOne, 1);

        String demandFourStr = String.format("     Іс бойынша тараптарды тіркеу сағат %s %s дейін жүргізіледі.", form103.getF7(), form103.getF8());
        Phrase demandFour = new Phrase(demandFourStr, FontUtil.openSansRegular(9));
        addCell(table, demandFour, 1);

        String demandFiveStr = String.format("     ҚР АПК-нің 446-бабына сәйкес, іске қатысатын адам қайта қарауға қатысты қарсылықты растайтын құжаттарды қоса тіркей отырып, сот актісін кассациялық тәртібімен қайта қарау туралы өтінішхатқа, ұсынуға немесе наразылыққа пікірді іске қатысатын басқа адамдарға және Қазақстан Республикасының Жоғарғы Сотына %s дейінгі мерзімде жібереді.", form103.getF13());
        Phrase demandFive = new Phrase(demandFiveStr, FontUtil.openSansRegular(9));
        addCell(table, demandFive, 1);

        String demandSixStr = String.format("     Пікірге іске қатысушы адам немесе оның өкілі қол қояды. Өкілдің қолы қойылған пікірге оның өкілеттігін растайтын сенімхат немесе өзге құжат қоса тіркеледі.");
        Phrase demandSix = new Phrase(demandSixStr, FontUtil.openSansRegular(9));
        addCell(table, demandSix, 1);

        String demandSevenStr = String.format("       ҚР АПК-нің 450-бабының 2-бөлігіне сәйкес, істің қаралатын уақыты мен орны туралы тиісінше хабардар етілген, өтінішхат (наразылық) берген адамның болмауы сот отырысын жалғастыру мүмкіндігін жоққа шығармайды");
        Phrase demandSeven = new Phrase(demandSevenStr, FontUtil.openSansRegular(9));
        addCell(table, demandSeven, 1);

        String demandEightStr = String.format("      Осыған орай іс бойынша тараптар кассациялық өндіріс жүргізу нөміріне (№%s) сілтеме жасап, Жоғарғы Сотқа 8-(7172)-710133, 8-(7172)-710105 телефондары немесе 707-0133@sud.kz электрондық адресі бойынша касациялық сатыдағы сот отырысына өздерінің қатысатыны туралы хабарлаулары қажет.", form103.getF14());
        Phrase demandEight = new Phrase(demandEightStr, FontUtil.openSansRegular(9));
        addCell(table, demandEight, 1);

        String demandNineStr = String.format("      Электрондық құжаттармен  (өтінішхаттың көшірмесімен, кассациялық сатыдағы сот отырысында қарау үшін өтінішхатты беру туралы туралы қаулының көшірмесімен) танысу үшін Жоғарғы Сот сайтындағы «Сот құжаттарын қарау» модулінде Штрихті Почталық Идентификатордың (ШПИ) сәйкестендіру нөмірін (оң жақ жоғарғы бұрышта) және сот хабарламасында көрсетілген сот отырысының белгіленген күнін енгізу қажет."
                , form103.getF14());
        Phrase demandNine = new Phrase(demandNineStr, FontUtil.openSansRegular(9));
        addCell(table, demandNine, 1);

        String demandTenStr = String.format("      Азаматтық және әкімшілік істер жөніндегі қадағалаушы сот алқасының хатшылығы."
                , form103.getF14());
        Phrase demandTen = new Phrase(demandTenStr, FontUtil.openSansRegular(9));
        addCell(table, demandTen, 2);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103.getF15());

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        createFooterAdditionalInfo(table, form103);

        setTablePosition(writer, table, 64f, 210f);
        gepContacts(writer);
        gepCopyright(writer);
    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String descriptionStr = String.format("          Егер Сіз «Сот кабинеті» электрондық сервисін пайдаланушы болып табылсаңыз\n" +
                "              www.oficce.sud.kz сайтында қаулымен онлайн режимінде таныса аласыз.\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан \n" +
                "  1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға\n" +
                "                                                                                  болады.");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
