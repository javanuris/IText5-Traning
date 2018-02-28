package titles;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DVDAstanaTitle implements Title {


    @Override
    public ByteArrayOutputStream createTitle(Form103 form103) {
        String FILE = "d:/test/FirstPdf.pdf";
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            createHeader(writer, form103);
            createBody(writer, form103);
            createFooter(writer, form103);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createHeader(PdfWriter writer, Form103 form103) {

    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {

    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {

    }


}
