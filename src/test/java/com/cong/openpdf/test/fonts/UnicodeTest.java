package com.cong.openpdf.test.fonts;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author cong
 * @since 2023/11/13 10:46
 */
public class UnicodeTest {

    public static void main(String[] args) {
        System.out.println("True Types (embedded)");

        try (Document document = new Document()) {
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get("/Users/cong/Downloads/a.pdf")));
            document.open();
            BaseFont baseFont = BaseFont.createFont("/Users/cong/IdeaProjects/fs/fs-web/merge.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 14);
            String text1 = "This is the quite popular True Type font 'Comic'.";
            String text2 = "Some greek characters: \u0393\u0394\u03b6";
            String text3 = "Some cyrillic characters: \u0418\u044f";
            document.add(new Paragraph(text1,font));
            document.add(new Paragraph(text2,font));
            document.add(new Paragraph(text3,font));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
