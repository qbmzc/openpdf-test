package com.cong.openpdf.fontstest;

import sun.font.FontDesignMetrics;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * @author cong
 * @since 2023/11/21 15:43
 */
public class FontTestTest {

    public static void main(String[] args) {

        FontDesignMetrics fdm = getFdm("Arial", 12);
        FontMetrics fontMetrics = getFontWithAndHeight();
        FontMetrics fontWithAndHeight2 = getFontWithAndHeight2();
        getFontWithAndHeight3();
        System.out.println(fdm.getHeight());
        System.out.println(fdm.getWidths().length);
        System.out.println(fontMetrics.getHeight());
        System.out.println(fontMetrics.getWidths().length);

        System.out.println("11111");
        System.out.println(fdm.stringWidth("窗前明月光"));
        System.out.println(fontMetrics.stringWidth("窗前明月光"));
    }

    /**
     * 已过时，不建议使用
     * 
     * @param fontName
     * @param fontSize
     * @return
     */
    private static FontDesignMetrics getFdm(String fontName, Integer fontSize) {
        long currentTimeMillis = System.currentTimeMillis();
        FontDesignMetrics metrics = FontDesignMetrics
                .getMetrics(new java.awt.Font(fontName, java.awt.Font.PLAIN, fontSize));

        System.out.println(0 + "_" + (System.currentTimeMillis() - currentTimeMillis));
        return metrics;
    }

    /**
     * 建议使用
     * 
     * @return
     */
    private static FontMetrics getFontWithAndHeight() {
        long currentTimeMillis = System.currentTimeMillis();
        // 创建字体对象
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN, 12);

        // 创建一个临时的图形对象
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // 设置字体
        g2d.setFont(font);
        // 获取字体度量对象
        FontMetrics fontMetrics = g2d.getFontMetrics();
        // 获取字体宽度和高度
        // int width = fontMetrics.stringWidth("Hello, World!");
        // int height = fontMetrics.getHeight();
        // 关闭图形对象
        g2d.dispose();
        System.out.println(1 + "_" + (System.currentTimeMillis() - currentTimeMillis));
        return fontMetrics;
    }

    /**
     * api已过时，不建议使用
     * 
     * @return
     */
    private static FontMetrics getFontWithAndHeight2() {
        long currentTimeMillis = System.currentTimeMillis();
        // 创建字体对象
        java.awt.Font font = new java.awt.Font("sans-serif", java.awt.Font.PLAIN, 12);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        FontMetrics fontMetrics = toolkit.getFontMetrics(font);
        System.out.println(2 + "_" + (System.currentTimeMillis() - currentTimeMillis));
        return fontMetrics;
    }

    /**
     * 可以使用,耗时比1多一些
     */
    private static void getFontWithAndHeight3() {
        long currentTimeMillis = System.currentTimeMillis();

        // 创建字体对象
        Font font = new Font("Arial", Font.PLAIN, 12);

        // 获取字体渲染上下文
        FontRenderContext fontRenderContext = new FontRenderContext(new AffineTransform(), true, true);
        // 获取字体的宽度
        String text = "Hello, World!";
        double width2 = font.getStringBounds(text, fontRenderContext).getWidth();
        Long width = Math.round(width2);
        double h = font.getStringBounds(text, fontRenderContext).getHeight();
        long height = Math.round(h);
        // 输出结果
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println(3 + "_" + (System.currentTimeMillis() - currentTimeMillis));

    }
}
