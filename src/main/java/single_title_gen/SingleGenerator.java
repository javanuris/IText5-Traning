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
    private static final int FIRST_PAGE = 1;
    private static final int SECOND_PAGE = 2;
    private static final int THIRD_PAGE = 3;
    private static final int FOURTH_PAGE = 4;
    private static final int FIFTH_PAGE = 5;
    private static final int SIXTH_PAGE = 6;
    private static final int SEVENTH_PAGE = 0;

    private static final int MAX_PAGE_FOR_PRINT_MARKS = 7;

    private static final int WIDTH_A4 = 210;
    private static final int HEIGHT_A4 = 297;

    private static final float FIRST_POINT_Y = 16.5f;
    private static final float SECOND_POINT_Y = 5.5f;

    public void generate(List<Form103> list) {
        String FILE = "d:/test/FirstPdf.pdf";
        CivilPreviouslyNoticeRusTitle title = new CivilPreviouslyNoticeRusTitle();
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));

            document.open();
            int currentPage = 1;

            for (Form103 form103 : list) {
                title.createTitle(writer, form103);

                PdfContentByte cb = writer.getDirectContent();
                printMarks(cb, currentPage, document);
                currentPage++;

                document.newPage();
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMarks(PdfContentByte cb, int currentPage, Document document) {

        cb.setColorStroke(BaseColor.BLACK);
        cb.setLineWidth(1.3f);

        int page = currentPage % MAX_PAGE_FOR_PRINT_MARKS;

        markLeftEdge(cb, page, document);
        markLeftBottom(cb, page, document);
        markRightEdge(cb, document);
        markRightBottom(cb, page, document);

        cb.stroke();
    }

    private void markLeftEdge(PdfContentByte cb, int currentPage, Document document) {
        addFirstLine(cb, document, 33.5f);
        addFirstLine(cb, document, 26.0f);
        addFirstLine(cb, document, 17.4f);

        if (currentPage == FIRST_PAGE || currentPage == THIRD_PAGE || currentPage == FIFTH_PAGE || currentPage == SEVENTH_PAGE) {
            addFirstLine(cb, document, 37.6f);
        }

        if (currentPage == SECOND_PAGE || currentPage == THIRD_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addFirstLine(cb, document, 41.6f);
        }

        if (currentPage == FOURTH_PAGE || currentPage == FIFTH_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addFirstLine(cb, document, 46.5f);
        }

        if (currentPage == FIRST_PAGE || currentPage == SECOND_PAGE || currentPage == FOURTH_PAGE || currentPage == SEVENTH_PAGE) {
            addFirstLine(cb, document, 50.8f);
        }
    }

    private void markLeftBottom(PdfContentByte cb, int currentPage, Document document) {
        addLine(cb, document, 39.90f, FIRST_POINT_Y, 39.90f, SECOND_POINT_Y);
        addLine(cb, document, 48.50f, FIRST_POINT_Y, 48.50f, SECOND_POINT_Y);
        addLine(cb, document, 56.00f, FIRST_POINT_Y, 56.00f, SECOND_POINT_Y);

        if (currentPage == FIRST_PAGE || currentPage == THIRD_PAGE || currentPage == FIFTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 60.80f, FIRST_POINT_Y, 60.80f, SECOND_POINT_Y);
        }

        if (currentPage == SECOND_PAGE || currentPage == THIRD_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 64.80f, FIRST_POINT_Y, 64.80f, SECOND_POINT_Y);
        }

        if (currentPage == FOURTH_PAGE || currentPage == FIFTH_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 69.70f, FIRST_POINT_Y, 69.70f, SECOND_POINT_Y);
        }

        if (currentPage == FIRST_PAGE || currentPage == SECOND_PAGE || currentPage == FOURTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 75.00f, FIRST_POINT_Y, 75.00f, SECOND_POINT_Y);
        }

    }

    private void markRightEdge(PdfContentByte cb, Document document) {
        addLine(cb, document, 192.30f, 54.60f, 201.90f, 54.60f);
        addLine(cb, document, 192.30f, 50.40f, 201.90f, 50.40f);
        addLine(cb, document, 192.30f, 46.24f, 201.90f, 46.24f);
    }

    private void markRightBottom(PdfContentByte cb, int currentPage, Document document) {
        addLine(cb, document, 173.30f, FIRST_POINT_Y, 173.30f, SECOND_POINT_Y);
        addLine(cb, document, 164.4f, FIRST_POINT_Y, 164.4f, SECOND_POINT_Y);
        addLine(cb, document, 156.0f, FIRST_POINT_Y, 156.0f, SECOND_POINT_Y);

        if (currentPage == FIRST_PAGE || currentPage == THIRD_PAGE || currentPage == FIFTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 151.50f, FIRST_POINT_Y, 151.50f, SECOND_POINT_Y);
        }

        if (currentPage == SECOND_PAGE || currentPage == THIRD_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 147.4f, FIRST_POINT_Y, 147.4f, SECOND_POINT_Y);
        }

        if (currentPage == FOURTH_PAGE || currentPage == FIFTH_PAGE || currentPage == SIXTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 143.20f, FIRST_POINT_Y, 143.20f, SECOND_POINT_Y);
        }

        if (currentPage == FIRST_PAGE || currentPage == SECOND_PAGE || currentPage == FOURTH_PAGE || currentPage == SEVENTH_PAGE) {
            addLine(cb, document, 138.80f, FIRST_POINT_Y, 138.80f, SECOND_POINT_Y);
        }
    }

    private void addLine(PdfContentByte cb, Document document, float f1, float f2, float f3, float f4) {
        cb.moveTo(document.getPageSize().getWidth() * f1 / WIDTH_A4, document.getPageSize().getHeight() * f2 / HEIGHT_A4);
        cb.lineTo(document.getPageSize().getWidth() * f3 / WIDTH_A4, document.getPageSize().getHeight() * f4 / HEIGHT_A4);
    }

    private void addFirstLine(PdfContentByte cb, Document document, float f1) {
        cb.moveTo(document.getPageSize().getWidth() * 3 / WIDTH_A4, document.getPageSize().getHeight() * f1 / HEIGHT_A4);
        cb.lineTo(document.getPageSize().getWidth() * 14 / WIDTH_A4, document.getPageSize().getHeight() * f1 / HEIGHT_A4);
    }
}

