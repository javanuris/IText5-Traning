package single_title_gen;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.rus.CivilPreviouslyNoticeRusTitle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class SingleGenerator {
    private final int firstPage = 1;
    private final int secondPage = 2;
    private final int thirdPage = 3;
    private final int fourthPage = 4;
    private final int fifthPage = 5;
    private final int sixthPage = 6;
    private final int seventhPage = 0;
    private final int maxPageForPrintMarks = 7;

    public void generate(List<Form103> list) {
        String FILE = "d:/test/FirstPdf.pdf";
        CivilPreviouslyNoticeRusTitle title = new CivilPreviouslyNoticeRusTitle();
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));

            document.open();

            int i = 1;
            for (Form103 form103 : list) {
                title.createTitle(writer, form103);

                PdfContentByte cb = writer.getDirectContent();
                printMarks(cb, i, document);
                i++;

                document.newPage();
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMarks(PdfContentByte cb, int allPageCounter, Document document) {
        cb.setColorStroke(BaseColor.BLACK);
        cb.setLineWidth(1.3f);

        int ccc = allPageCounter % maxPageForPrintMarks;

        addFirstLine(cb, document, 33.5f);
        addFirstLine(cb, document, 26.0f);
        addFirstLine(cb, document, 17.4f);

        //259
        if (ccc == firstPage || ccc == thirdPage || ccc == fifthPage || ccc == seventhPage) {
            addFirstLine(cb, document, 37.6f);
        }
        //255
        if (ccc == secondPage || ccc == thirdPage || ccc == sixthPage || ccc == seventhPage) {
            addFirstLine(cb, document, 41.6f);
        }
        //250
        if (ccc == fourthPage || ccc == fifthPage || ccc == sixthPage || ccc == seventhPage) {//3
            addFirstLine(cb, document, 46.5f);
        }
        //246
        if (ccc == firstPage || ccc == secondPage || ccc == fourthPage || ccc == seventhPage) {
            addFirstLine(cb, document, 50.8f);
        }

        //LEFT BOTTOM
        addLine(cb, document, 39.90f, 16.5f, 39.90f, 5.5f);
        addLine(cb, document, 48.50f, 16.5f, 48.50f, 5.5f);
        addLine(cb, document, 56.00f, 16.5f, 56.00f, 5.5f);

        //59
        if (ccc == firstPage || ccc == thirdPage || ccc == fifthPage || ccc == seventhPage) {
            addLine(cb, document, 60.80f, 16.5f, 60.80f, 5.5f);
        }
        //63
        if (ccc == secondPage || ccc == thirdPage || ccc == sixthPage || ccc == seventhPage) {
            addLine(cb, document, 64.80f, 16.5f, 64.80f, 5.5f);
        }

        //68
        if (ccc == fourthPage || ccc == fifthPage || ccc == sixthPage || ccc == seventhPage) {
            addLine(cb, document, 69.70f, 16.5f, 69.70f, 5.5f);
        }
        //72*/
        if (ccc == firstPage || ccc == secondPage || ccc == fourthPage || ccc == seventhPage) {
            addLine(cb, document, 75.00f, 16.5f, 75.00f, 5.5f);
        }


        //RIGHT BOTTOM
        //--------------------------------KERN_END-------------------------------------------------------------


        addLine(cb, document, 192.30f, 54.60f, 201.90f, 54.60f);
        addLine(cb, document, 192.30f, 50.40f, 201.90f, 50.40f);
        addLine(cb, document, 192.30f, 46.24f, 201.90f, 46.24f);

        //Для астаникского электронпоста
        addLine(cb, document, 173.30f, 16.5f, 173.30f, 5.5f);
        addLine(cb, document, 164.4f, 16.5f, 164.4f, 5.5f);
        addLine(cb, document, 156.0f, 16.5f, 156.0f, 5.5f);

        //59
        if (ccc == firstPage || ccc == thirdPage || ccc == fifthPage || ccc == seventhPage) {
            addLine(cb, document, 151.50f, 16.5f, 151.50f, 5.5f);
        }

        //63
        if (ccc == secondPage || ccc == thirdPage || ccc == sixthPage || ccc == seventhPage) {
            addLine(cb, document, 147.4f, 16.5f, 147.4f, 5.5f);
        }

        //68
        if (ccc == fourthPage || ccc == fifthPage || ccc == sixthPage || ccc == seventhPage) {
            addLine(cb, document, 143.20f, 16.5f, 143.20f, 5.5f);
        }

        //72
        if (ccc == firstPage || ccc == secondPage || ccc == fourthPage || ccc == seventhPage) {
            addLine(cb, document, 138.80f, 16.5f, 138.80f, 5.5f);
        }
        cb.stroke();
    }

    private void addLine(PdfContentByte cb, Document document, float f1, float f2, float f3, float f4) {
        cb.moveTo(document.getPageSize().getWidth() * f1 / 210, document.getPageSize().getHeight() * f2 / 297);
        cb.lineTo(document.getPageSize().getWidth() * f3 / 210, document.getPageSize().getHeight() * f4 / 297);
    }

    private void addFirstLine(PdfContentByte cb, Document document, float f1) {
        cb.moveTo(document.getPageSize().getWidth() * 3 / 210, document.getPageSize().getHeight() * f1 / 297);
        cb.lineTo(document.getPageSize().getWidth() * 14 / 210, document.getPageSize().getHeight() * f1 / 297);
    }
}

