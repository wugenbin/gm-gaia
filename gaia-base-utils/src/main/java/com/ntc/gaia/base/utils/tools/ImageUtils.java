package com.ntc.gaia.base.utils.tools;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片裁剪处理助手类
 *
 * @author allen.yuan
 * @cratedate 2016/5/18
 **/
public class ImageUtils {

    public static byte[] resize(BufferedImage srcBufferedImage, int targetWidth)
            throws IOException {
        return resize(srcBufferedImage, targetWidth, 1f, false);
    }

    public static byte[] resize(BufferedImage srcBufferedImage,
                                int targetWidth, boolean square) throws IOException {
        return resize(srcBufferedImage, targetWidth, square);
    }

    public static byte[] resize(BufferedImage srcBufferedImage,
                                int targetWidth, float quality, boolean square) throws IOException {
        if (quality > 1) {
            throw new IllegalArgumentException(
                    "Quality has to be between 0 and 1");
        }
        if (square) {
            // 正方形，需要提前进行裁剪
            int width = srcBufferedImage.getWidth();
            int height = srcBufferedImage.getHeight();
            if (width > height) {
                int x = (width - height) / 2;
                srcBufferedImage = srcBufferedImage.getSubimage(x, 0, height,
                        height);
            } else if (width < height) {
                int y = (height - width) / 2;
                srcBufferedImage = srcBufferedImage.getSubimage(0, y, width,
                        width);
            }
        }

        Image resizedImage = null;
        int iWidth = srcBufferedImage.getWidth();
        int iHeight = srcBufferedImage.getHeight();

        if (iWidth > iHeight) {
            resizedImage = srcBufferedImage.getScaledInstance(targetWidth,
                    (targetWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
        } else {
            resizedImage = srcBufferedImage.getScaledInstance(
                    (targetWidth * iWidth) / iHeight, targetWidth,
                    Image.SCALE_SMOOTH);
        }

        // This code ensures that all the pixels in the image are loaded.
        Image temp = new ImageIcon(resizedImage).getImage();

        // Create the buffered image.
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // Copy image to buffered image.
        Graphics g = bufferedImage.createGraphics();

        // Clear background and paint the image.
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        // Soften.
        float softenFactor = 0.05f;
        float[] softenArray = {0, softenFactor, 0, softenFactor,
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0};
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);


        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(1.0F);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutputStream = ImageIO
                .createImageOutputStream(byteArrayOutputStream);
        writer.setOutput(imageOutputStream);
        writer.write(null, new IIOImage(bufferedImage, null, null), param);

        return byteArrayOutputStream.toByteArray();
    }

    // Example usage
    public static void main(String[] args) throws IOException {


        File originalImage = new File("D:/sapfiles/masterfs/material/20160408144715265.jpg");
        byte[] bytes = resize(ImageIO.read(originalImage), 100, 1f, true);

        FileOutputStream out = new FileOutputStream(new File("E:/66.jpg"));

        out.write(bytes);
        out.close();
        System.out.println("Ok");
    }
}
