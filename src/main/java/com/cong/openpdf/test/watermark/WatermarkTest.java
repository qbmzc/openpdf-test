package com.cong.openpdf.test.watermark;

import lombok.SneakyThrows;

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
        String text ="这是一个水印 \u25cf";
        int fontSize = 100;
        float opacity= 0.5f;
        WatermarkerTool

    }
}
