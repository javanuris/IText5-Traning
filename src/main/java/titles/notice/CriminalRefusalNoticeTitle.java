package titles.notice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import utils.FontUtil;
import utils.ImageUtil;

public class CriminalRefusalNoticeTitle extends AbstractTitle {

    private static final String QR_CODE_VALUE = "http://eaias.supcourt.kz/QRP.nsf/QR.xsp?id=46257D470044C9D646257DA00003001A";

    @Override
    protected void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        Image image = createSudImage();
        try {
            writer.getDirectContent().addImage(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase sudPovestka = new Phrase("Судебное извещение", FontUtil.openSansBold(7));
        addCell(table, sudPovestka, 10);

        Phrase f1 = new Phrase(form103.getF1().toUpperCase(), FontUtil.openSansBold(8));
        addCell(table, f1, 3);

        Phrase f2 = new Phrase(form103.getF2(), FontUtil.openSansBold(8));
        addCell(table, f2, 1);

        Phrase f3 = new Phrase(form103.getF3(), FontUtil.openSansBold(8));
        addCell(table, f3, 1);

        String addressStr = String.format("%s, %s", form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansBold(8));
        addCell(table, address, 2);

        if (form103.getResipientPhone() != null) {
            String recipientPhoneStr = String.format("тел: %s", form103.getResipientPhone());
            Phrase recipientPhone = new Phrase(recipientPhoneStr, FontUtil.openSansBold(8));
            addCell(table, recipientPhone, 2);
        }
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(470);

        String additionalTextStr = String.format("(по результатам предварительного рассмотрения по уголовному делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(63f);
        table.addCell(additionalTextCell);

        String povestkaStr = String.format("СУДЕБНОЕ ИЗВЕЩЕНИЕ");
        Phrase povestka = new Phrase(povestkaStr, FontUtil.openSansBold(15));
        PdfPCell povestkaCell = getPdfPCell(povestka);
        povestkaCell.setPaddingLeft(152f);
        table.addCell(povestkaCell);

        String receiverStr = String.format("     Кому: %s", form103.getF1());
        Phrase receiver = new Phrase(receiverStr, FontUtil.openSansLight(10));
        addCell(table, receiver, 32);

        String addressStr = String.format("     Куда: %s %s %s %s", form103.getF2(), form103.getF3(), form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansLight(10));
        addCell(table, address, 2);

        setDemandThree(table, form103);


        setTablePosition(writer, table, 57f, 594f);
    }

    protected void setDemandThree(PdfPTable table, Form103 form103) {

        String demandOneStr = String.format("     Верховный Суд Республики Казахстан извещает Вас о том, что в соответствии с п.1 ч.1 ст.491 УПК РК по результатам предварительного рассмотрения ходатайства %s в отношении %s вынесено постановление о передаче ходатайства с делом для рассмотрения в судебном заседании кассационной инстанции. ", form103.getF6(), form103.getF7());
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandOne, 15);

        String demandTwoStr = String.format("     В соответствии со ст.492 УПК РК рассмотрение уголовного дела назначено на %s год по адресу: г. Астана, ул. Д. Кунаева, д.39 (Левый берег р.Ишим).", form103.getF8());
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandTwo, 1);

        String demandThreeStr = String.format("    На основании ч.1 ст.494 УПК РК, дело может быть рассмотрено без участия надлежаще извещенных сторон в случае их неявки либо поступления от них соответствующего заявления.", form103.getF8());
        Phrase demandThree = new Phrase(demandThreeStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandThree, 1);

        String demandFourStr = String.format("    Для ознакомления с электронной копией ходатайства необходимо на сайте Верховного Суда в модуле «Просмотр судебных документов» ввести идентификационный номер ШПИ (в правом верхнем углу) и дату назначения судебного заседания, указанные в судебном извещении.", form103.getF8());
        Phrase demandFour = new Phrase(demandFourStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandFour, 1);

    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer);

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        String descriptionStr = String.format("        Если Вы являетесь пользователем электронного сервиса «Судебный кабинет»,\n" +
                "Вы можете ознакомиться с постановлением в онлайн-режиме на www.oficce.sud.kz.\n" +
                "       По возникшим вопросам звонить в Сall-центр судебных органов - с городских\n" +
                "                                              телефонов на номер 1401(бесплатно),\n" +
                "                            с мобильных телефонов на номер 8-7172-710000 (платно).");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

        setTablePosition(writer, table, 82f, 210f);


        gepContacts(writer);
        gepCopyright(writer);

    }

    protected void setQRCode(PdfWriter writer) {
        getQRCode(writer, QR_CODE_VALUE);
    }

    protected void getQRCode(PdfWriter writer, String text) {
        if (text != null) {
            Image image = createQRCode(text, 30f, 32f, 85f, 85f);
            try {
                writer.getDirectContent().addImage(image);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

    }

    private Image createQRCode(String text, float xPos, float yPos, float width, float height) {
        BarcodeQRCode barcodeQRCode = new BarcodeQRCode(text, (int) width, (int) height, null);
        Image codeQrImage = null;
        try {
            codeQrImage = barcodeQRCode.getImage();
            codeQrImage.setAbsolutePosition(xPos, yPos);
            codeQrImage.scaleAbsolute(width, height);
        } catch (BadElementException e) {
            e.printStackTrace();
        }
        return codeQrImage;
    }

    private void gepContacts(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(150);

        String text1Str = String.format("Контакт-Центр ВС: ");
        Phrase text1 = new Phrase(text1Str, FontUtil.openSansLight(8));
        addCell(table, text1, 1);

        String text2Str = String.format("1401 ( бесплатно по всему РК )");
        Phrase text2 = new Phrase(text2Str, FontUtil.openSansLight(8));
        addCell(table, text2, 2);

        String text3Str = String.format("8 (7172) 710 000");
        Phrase text3 = new Phrase(text3Str, FontUtil.openSansLight(8));
        addCell(table, text3, 2);

        setTablePosition(writer, table, 110f, 79f);
    }

    private void gepCopyright(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Font font = FontUtil.openSansLight(6);
        font.setColor(BaseColor.GRAY);

        Phrase text = new Phrase("© 2014 Copyright АО Казпочта. Распечатано в ИС ГЭП™ - Гибридная Электронная Почта. http://gep.kazpost.kz/", font);
        PdfPCell textCell = getPdfPCell(text);
        table.addCell(textCell);

        setTablePosition(writer, table, 165f, 32f);
    }


    private Image createSudImage() {
        Image image = ImageUtil.getLogoSud();
        image.setAbsolutePosition(44f, 720f);
        image.scaleAbsolute(151f, 100f);
        return image;
    }


    protected void addCell(PdfPTable table, Phrase phrase, float paddingTop) {
        PdfPCell toCell = getPdfPCell(phrase);
        toCell.setPaddingTop(paddingTop);
        table.addCell(toCell);
    }

    protected void addCellParagraph(PdfPTable table, Phrase text, float paddingTop) {
        Paragraph paragraph = new Paragraph(text);
        paragraph.setLeading(12);
        PdfPCell toCell = getPdfPCellParagraph(paragraph);
        toCell.setPaddingTop(paddingTop);
        table.addCell(toCell);
    }
}
