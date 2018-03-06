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
import java.util.List;

public class F119GenerateOnePage {

    public void generate(List<Form103> form103List) {
        try {
            String FILE = "d:/test/F119Pdf.pdf";
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            int counter = 0;
            for (Form103 form103 : form103List) {
                Image f119Image = null;

                if (counter == 0) {
                    f119Image = getMarkF119(writer.getDirectContentUnder(), createLogoImage(), form103);
                    f119Image.setAbsolutePosition(-50f, 358f);
                    document.add(f119Image);
                    document.newPage();
                }

                counter++;
                if (counter > 0 && counter <= form103List.size() - 1) {
                    f119Image = getMarkF119(writer.getDirectContentUnder(), createLogoImage(), form103);
                    if (counter % 2 == 0) {
                        f119Image.setAbsolutePosition(-50f, -57f);
                    } else {
                        f119Image.setAbsolutePosition(-50f, 358f);
                    }
                } else {
                    f119Image = getMarkF119(writer.getDirectContentUnder(), createLogoImage(), form103);
                    f119Image.setAbsolutePosition(-50f, -57f);
                }
                document.add(f119Image);
                if (counter % 2 == 0) {
                    document.newPage();
                }
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Image createLogoImage() {
        Image image = ImageUtil.getF119Template();
        image.scaleAbsolute(695f, 580f);
        return image;
    }

    private Image getMarkF119(PdfContentByte cb, Image img, Form103 form103) throws DocumentException {
        float width = img.getScaledWidth();
        float height = img.getScaledHeight();
        PdfTemplate template = cb.createTemplate(width, height);

        template.addImage(img, width, 0, 0, height, 0, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_CENTER, new Phrase(form103.getF1(), FontUtil.openSansRegular(14)), width / 2, height / 2, 0);

        return Image.getInstance(template);
    }
}
