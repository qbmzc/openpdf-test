package com.cong.openpdf.fonts;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author cong
 * @since 2023/11/21 15:43
 */
public class FontTest {

    public static void main(String[] args) {

//        FontDesignMetrics fdm = getFdm("Arial", 12);
        FontMetrics fontMetrics = getFontWithAndHeight();
//        System.out.println(fdm.getHeight());
//        System.out.println(fdm.getWidths().length);
        System.out.println(fontMetrics.getHeight());
        System.out.println(fontMetrics.getWidths().length);
    }

//    private static FontDesignMetrics getFdm(String fontName, Integer fontSize) {
//        return FontDesignMetrics.getMetrics(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));
//    }

    private static FontMetrics getFontWithAndHeight() {
        // 创建字体对象
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN, 12);

        // 创建一个临时的图形对象
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        Graphics2D g2d = (Graphics2D) g;

        // 设置字体
        g2d.setFont(font);
        // 获取字体度量对象
        FontMetrics fontMetrics = g2d.getFontMetrics();
        // 获取字体宽度和高度
//        int width = fontMetrics.stringWidth("Hello, World!");
//        int height = fontMetrics.getHeight();
        // 关闭图形对象
        g.dispose();
        return fontMetrics;
    }

    private static FontMetrics getFontWithAndHeight2() {
        // 创建字体对象
        java.awt.Font font = new java.awt.Font("sans-serif", java.awt.Font.PLAIN, 12);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMetrics = toolkit.getFontMetrics(font);
        return fontMetrics;
    }
}
