package f119;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import store.FileStoreService;
import store.FtpFileStoreServiceImpl;
import utils.FontUtil;
import utils.ImageUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F119GenerateOnePage {

    private FileStoreService fileStoreService;

    public Map<ByteArrayOutputStream, String> generate(List<Form103> form103List) {
        fileStoreService = new FtpFileStoreServiceImpl();
        ByteArrayOutputStream outputFile = new ByteArrayOutputStream();

        form103List = orderF119(form103List);

        try {
            String FILE = "d:/test/F119Pdf.pdf";
            Document document = new Document(PageSize.A4);
            PdfWriter writer = null;
            try {
                writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            document.open();
            Image image = createF119Image();
            int counter = 0;
            for (Form103 form103 : form103List) {
                Image f119Image = null;

                if (counter >= 1) {
                    if (counter <= form103List.size() - 2) {
                        f119Image = getMarkF119(writer.getDirectContentUnder(), image, form103);
                        if (counter % 2 == 0) {
                            f119Image.setAbsolutePosition(-50f, -57f);
                        } else {
                            f119Image.setAbsolutePosition(-50f, 358f);
                        }
                    } else {
                        f119Image = getMarkF119(writer.getDirectContentUnder(), image, form103);
                        f119Image.setAbsolutePosition(-50f, -57f);
                    }

                    document.add(f119Image);
                    if (counter % 2 == 0) {
                        document.newPage();
                    }
                }

                if (counter == 0) {
                    f119Image = getMarkF119(writer.getDirectContentUnder(), image, form103);
                    f119Image.setAbsolutePosition(-50f, 358f);
                    document.add(f119Image);
                    document.newPage();
                }
                counter++;
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            map.put(i + "test_f119.pdf", outputFile);
        }


        fileStoreService.saveFile(map);
        return null;
    }

    private Image createF119Image() {
        Image image = ImageUtil.getF119Template();
        image.scaleAbsolute(695f, 580f);
        return image;
    }

    private Image getMarkF119(PdfContentByte cb, Image img, Form103 form103) throws DocumentException {
        float width = img.getScaledWidth();
        float height = img.getScaledHeight();
        PdfTemplate template = cb.createTemplate(width, height);

        template.addImage(img, width, 0, 0, height, 0, 0);

        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase("*" + form103.getBarcode() + "*", FontUtil.fre3of9x(24.5f)), 110, 385, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(form103.getBarcode(), FontUtil.openSansRegular(10)), 110, 375, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(form103.getF6(), FontUtil.openSansRegular(7)), 145, 347, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(firstLine(form103.getF7(), 0, 42), FontUtil.openSansRegular(7)), 185, 325, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(secondLine(form103.getF7(), 43, 91), FontUtil.openSansRegular(7)), 108, 306, 0);

        if (form103.getF15() != null) {
            String[] everyIndexNumber = form103.getF15().split("");
            int offset = 0;
            for (int i = 0; i < everyIndexNumber.length; i++) {
                Paragraph paragraph = new Paragraph(everyIndexNumber[i], FontUtil.courier(12));
                ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, paragraph, 292 + offset, 306, 0);
                offset += 10;
            }
        }

        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(form103.getF1(), FontUtil.openSansRegular(7)), 145, 273, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(firstLine(form103.getF4(), 0, 40), FontUtil.openSansRegular(7)), 175, 253, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(secondLine(form103.getF4(), 41, 91), FontUtil.openSansRegular(7)), 108, 234, 0);


        if (form103.getF5() != null) {
            String[] everyIndexNumber = form103.getF5().split("");
            int offset = 0;
            for (int i = 0; i < everyIndexNumber.length; i++) {
                Paragraph paragraph = new Paragraph(everyIndexNumber[i], FontUtil.courier(12));
                ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, paragraph, 292 + offset, 233, 0);
                offset += 10;

            }
        }

        img.setTemplateData(template);
        return Image.getInstance(template);
    }


    private String firstLine(String text, int start, int end) {
        String line = null;
        if (text != null) {
            if (text.length() < end) {
                line = text;
            }
            if (text.length() > end) {
                line = text.substring(start, end + 1);
            }
        } else {
            line = "";
        }
        return line;
    }

    private String secondLine(String text, int start, int end) {
        String line = null;
        if (text != null) {
            if (text.length() < start) {
                line = "";
            } else if (text.length() > start && text.length() < end) {
                line = text.substring(start, text.length());
            } else {
                line = text.substring(start, end);
            }
        } else {
            line = "";
        }
        return line;
    }

    private static final int ONE_F119 = 1;
    private static final int TWO_F119 = 2;
    private static final int FIRST_F119 = 0;
    private static final int SECOND_F119 = 1;

    private List<Form103> orderF119(List<Form103> listBefore) {
        List<Form103> listAfter = new ArrayList<>();

        for (int i = 0; i < listBefore.size(); i++) {
            listAfter.add(new Form103());
        }

        if (listBefore.size() == ONE_F119) {
            listAfter.set(0, listBefore.get(FIRST_F119));
        } else if (listBefore.size() == TWO_F119) {
            listAfter.set(0, listBefore.get(FIRST_F119));
            listAfter.set(1, listBefore.get(SECOND_F119));
        } else {
            for (int i = 0; i < listBefore.size() - 2; i++) {
                i++;
                //first
                listAfter.set(0, listBefore.get(FIRST_F119));

                //to swap
                listAfter.set(i, listBefore.get(i + 1));
                listAfter.set(i + 1, listBefore.get(i));

                //last
                if (listBefore.size() % 2 == 0) {
                    listAfter.set(listAfter.size() - 1, listBefore.get(listBefore.size() - 1));
                }
            }
        }
        return listAfter;

    }

}
