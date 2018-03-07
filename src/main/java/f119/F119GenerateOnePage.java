package f119;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import utils.FontUtil;
import utils.ImageUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class F119GenerateOnePage {

    public void generate(List<Form103> form103List) {

        form103List = sort(form103List);

        for (Form103 s : form103List) {
            System.out.println(s.getF6());
        }

        try {
            String FILE = "d:/test/F119Pdf.pdf";
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            Image image = createF119Image();
            int counter = 0;
            for (Form103 form103 : form103List) {
                Image f119Image = null;


                if (counter >= 1) {
                    if (counter >0 && counter <= form103List.size() -2) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
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
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(firstLine(form103.getF7(), 0, 42), FontUtil.openSansRegular(7)), 185, 327, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, new Phrase(secondLine(form103.getF7(), 43, 91), FontUtil.openSansRegular(7)), 108, 307, 0);
        Paragraph paragraph = new Paragraph(form103.getF5(), FontUtil.courier(12));
        paragraph.setSpacingAfter(5);
        ColumnText.showTextAligned(template, Element.ALIGN_UNDEFINED, paragraph, 300, 307, 0);


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

    private List<Form103> sort(List<Form103> listOld) {
        List<Form103> listNew = new ArrayList<>();

        for (int i = 0; i < listOld.size(); i++) {
            listNew.add(new Form103());
        }

        if (listOld.size() == 1) {
            listNew.set(0, listOld.get(0));
        } else if (listOld.size() == 2) {
            listNew.set(0, listOld.get(0));
            listNew.set(1, listOld.get(1));
        } else {
            for (int i = 0; i < listOld.size() - 2; i++) {
                i++;

                listNew.set(0, listOld.get(0));
                listNew.set(i, listOld.get(i + 1));
                listNew.set(i + 1, listOld.get(i));

                if (listOld.size() % 2 == 0) {
                    listNew.set(listNew.size() - 1, listOld.get(listOld.size() - 1));
                }
            }

        }
        return listNew;

    }

}
