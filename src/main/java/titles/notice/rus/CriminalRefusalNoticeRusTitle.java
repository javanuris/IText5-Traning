package titles.notice.rus;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.notice.AbstractNoticeRusTitle;
import utils.FontUtil;

//id 8
public class CriminalRefusalNoticeRusTitle extends AbstractNoticeRusTitle {

    private static final String QR_CODE_VALUE = "http://eaias.supcourt.kz/QRP.nsf/QR.xsp?id=46257D470044C9D646257DA00003001A";

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(по результатам предварительного рассмотрения по уголовному делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(63f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {

        String demandOneStr = String.format("     Верховный Суд Республики Казахстан извещает Вас о том, что в соответствии с п.1 ч.1 ст.491 УПК РК по результатам предварительного рассмотрения ходатайства %s в отношении %s вынесено постановление о передаче ходатайства с делом для рассмотрения в судебном заседании кассационной инстанции. ", form103.getF6(), form103.getF7());
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandOne, 15);

        String demandTwoStr = String.format("     В соответствии со ст.492 УПК РК рассмотрение уголовного дела назначено на %s год по адресу: г. Астана, ул. Д. Кунаева, д.39 (Левый берег р.Ишим).", form103.getF8());
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandTwo, 1);

        String demandThreeStr = String.format("    На основании ч.1 ст.494 УПК РК, дело может быть рассмотрено без участия надлежаще извещенных сторон в случае их неявки либо поступления от них соответствующего заявления.", form103.getF8());
        Phrase demandThree = new Phrase(demandThreeStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandThree, 1);

        String demandFourStr = String.format("    Для ознакомления с электронной копией ходатайства необходимо на сайте Верховного Суда в модуле «Просмотр судебных документов» ввести идентификационный номер ШПИ (в правом верхнем углу) и дату назначения судебного заседания, указанные в судебном извещении.");
        Phrase demandFour = new Phrase(demandFourStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandFour, 1);

    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String descriptionStr = String.format("              Если Вы являетесь пользователем электронного сервиса «Судебный кабинет»,\n" +
                "      Вы можете ознакомиться с постановлением в онлайн-режиме на www.oficce.sud.kz.\n" +
                "             По возникшим вопросам звонить в Сall-центр судебных органов - с городских\n" +
                "                                                    телефонов на номер 1401(бесплатно),\n" +
                "                                  с мобильных телефонов на номер 8-7172-710000 (платно).");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

    }

    protected void setQRCode(PdfWriter writer , String text) {
        getQRCode(writer, QR_CODE_VALUE);
    }


}
