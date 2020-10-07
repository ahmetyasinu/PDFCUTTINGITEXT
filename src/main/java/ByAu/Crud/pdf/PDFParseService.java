package ByAu.Crud.pdf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFParseService {
    public static void main(String[] args) {
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("C:\\test.pdf");
        try {
            String text = pdfManager.toText();
            System.out.println(text);
        } catch (IOException ex) {
            Logger.getLogger(PDFParseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

