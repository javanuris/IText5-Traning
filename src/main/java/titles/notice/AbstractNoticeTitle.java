package titles.notice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import titles.notice.lang.AbstractLangTemplate;
import utils.FontUtil;
import utils.ImageUtil;

public abstract class AbstractNoticeTitle extends AbstractTitle {
    protected abstract AbstractLangTemplate templ();

    @Override
    protected void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        Image image = createSudImage();
        try {
            writer.getDirectContent().addImage(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        String sudPovestkaStr = String.format(templ().getSudPovestka());
        Phrase sudPovestka = new Phrase(sudPovestkaStr, FontUtil.openSansBold(7));
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

        setBodyDescriptionBeforePovestka(table);

        String povestkaStr = String.format(templ().getPovestka());
        Phrase povestka = new Phrase(povestkaStr, FontUtil.openSansBold(15));
        PdfPCell povestkaCell = getPdfPCell(povestka);
        povestkaCell.setPaddingLeft(152f);
        table.addCell(povestkaCell);

        String receiverStr = String.format(templ().getReceiver(), form103.getF1());
        Phrase receiver = new Phrase(receiverStr, FontUtil.openSansLight(10));
        addCell(table, receiver, 32);

        String addressStr = String.format(templ().getAddress(), form103.getF2(), form103.getF3(), form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansLight(10));
        addCell(table, address, 2);

        setBodyAdditionalInfo(table, form103);

        setTablePosition(writer, table, 57f, 594f);
    }

    protected abstract void setBodyDescriptionBeforePovestka(PdfPTable table);

    protected abstract void setBodyAdditionalInfo(PdfPTable table, Form103 form103);

    private Image createSudImage() {
        Image image = ImageUtil.getLogoSud();
        image.setAbsolutePosition(44f, 720f);
        image.scaleAbsolute(151f, 100f);
        return image;
    }

    protected abstract void setQRCode(PdfWriter writer, String text);

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

    protected void gepContacts(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(150);

        String text1Str = String.format(templ().getText1());
        Phrase text1 = new Phrase(text1Str, FontUtil.openSansLight(8));
        addCell(table, text1, 1);

        String text2Str = String.format(templ().getText2());
        Phrase text2 = new Phrase(text2Str, FontUtil.openSansLight(8));
        addCell(table, text2, 2);

        String text3Str = String.format(templ().getText3());
        Phrase text3 = new Phrase(text3Str, FontUtil.openSansLight(8));
        addCell(table, text3, 2);

        setTablePosition(writer, table, 110f, 79f);
    }

    protected void gepCopyright(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Font font = FontUtil.openSansLight(6);
        font.setColor(BaseColor.GRAY);

        Phrase text = new Phrase("© 2014 Copyright АО Казпочта. Распечатано в ИС ГЭП™ - Гибридная Электронная Почта. http://gep.kazpost.kz/", font);
        PdfPCell textCell = getPdfPCell(text);
        table.addCell(textCell);

        setTablePosition(writer, table, 165f, 32f);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103.getF16());

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        createFooterAdditionalInfo(table, form103);

        setTablePosition(writer, table, 64f, 210f);
        gepContacts(writer);
        gepCopyright(writer);
    }

    protected abstract void createFooterAdditionalInfo(PdfPTable table, Form103 form103);

}
