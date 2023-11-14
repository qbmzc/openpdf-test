package com.cong.openpdf.test.watermark;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.toolbox.plugins.watermarker.Watermarker;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author cong
 * @since 2023/11/13 13:39
 */
public class WatermarkTest {

    @SneakyThrows
    public static void main(String[] args) {
        Path path = Paths.get("/Users/cong/Downloads/a.pdf");
        byte[] bytes = Files.readAllBytes(path);
        String text = "这是一个水印 \u25cf";
        int fontSize = 100;
        float opacity = 0.5f;
        BaseFont baseFont = BaseFont.createFont("/Users/cong/IdeaProjects/fs/fs-web/merge.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        byte[] write = new Watermarker(bytes, text, fontSize, opacity).withColor(Color.GRAY)
                .withFont(baseFont)
                .write();
        System.out.println(write.length > bytes.length);
        writeOnDisk(write);
    }

    @SuppressWarnings("unused")
    private static void writeOnDisk(byte[] result) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("/Users/cong/Downloads/Result.pdf")) {
            fileOutputStream.write(result);
        }
    }
}
