package com.ntc.gaia.base.utils.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件助手类
 * 
 * @author ALLEN
 * 
 */
public class ImageUtil {

	static Font FONT = new Font("微软雅黑", Font.BOLD, 12);
	static final Color COLOR = Color.WHITE;
	static final Color FONT_COLOR = new Color(255, 255, 255, 150);
	static final Color FONT_SHADOW_COLOR = new Color(170, 170, 170, 77);

	public static boolean isJpg(String str) {
		return isEndWid(str, "jpg");
	}

	public static boolean isPng(String str) {
		return isEndWid(str, "png");
	}

	public static boolean isGif(String str) {
		return isEndWid(str, "gif");
	}

	private static boolean isEndWid(String str, String ext) {

		if (str == null || "".equals(str.trim())) {
			return false;
		}

		int position = str.lastIndexOf(".");
		if (position == -1 || (position == str.length() - 1)) {
			return false;
		}
		String suffix = str.substring(position + 1);
		if (ext.equalsIgnoreCase(suffix)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isJpg(InputStream in) throws IOException {

		InputStream iis = in;

		if (!in.markSupported()) {
			throw new IllegalArgumentException("Input stream must support mark");
		}

		iis.mark(30);

		try {
			int byte1 = iis.read();
			int byte2 = iis.read();
			if ((byte1 == 0xFF) && (byte2 == 0xD8)) {
				return true;
			}
		} finally {
			iis.reset();
		}

		return false;
	}

	public static boolean isPng(InputStream in) throws IOException {

		if (!in.markSupported()) {
			throw new IllegalArgumentException("Input stream must support mark");
		}

		byte[] b = new byte[8];
		try {
			in.mark(30);
			in.read(b);
		} finally {
			in.reset();
		}

		return (b[0] == (byte) 137 && b[1] == (byte) 80 && b[2] == (byte) 78 && b[3] == (byte) 71 && b[4] == (byte) 13
				&& b[5] == (byte) 10 && b[6] == (byte) 26 && b[7] == (byte) 10);
	}

	public static boolean isGif(InputStream in) throws IOException {
		if (!in.markSupported()) {
			throw new IllegalArgumentException("Input stream must support mark");
		}

		byte[] b = new byte[6];

		try {
			in.mark(30);
			in.read(b);
		} finally {
			in.reset();
		}

		return b[0] == 'G' && b[1] == 'I' && b[2] == 'F' && b[3] == '8' && (b[4] == '7' || b[4] == '9') && b[5] == 'a';
	}

	public static void makeWatermark(String[] text, BufferedImage image, Font font, Color fontColor) {

		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (font != null) {
			graphics.setFont(font);
		} else {
			graphics.setFont(FONT);
		}
		if (fontColor == null) {
			fontColor = COLOR;
		}
		//
		graphics.setColor(fontColor);
		for (int i = 0; i < text.length; i++) {
			if ("".equals(text[i].trim())) {
				continue;
			}
			FontRenderContext context = graphics.getFontRenderContext();
			Rectangle2D fontRectangle = font.getStringBounds(text[i], context);
			int sw = (int) fontRectangle.getWidth();
			int sh = (int) fontRectangle.getHeight();
			if (text.length - i == 1) {
				graphics.drawString(text[i], image.getWidth() - sw - 6, image.getHeight() - 8);
			} else {
				graphics.drawString(text[i], image.getWidth() - sw - 6, image.getHeight() - sh * (text.length - 1) - 8);
			}
		}
		graphics.dispose();
	}

	public static void checkParams(InputStream in, OutputStream out, int maxWidth, int maxHeight, float quality)
			throws IOException {

		if (in == null) {
			throw new IOException("InputStream can not be null ");
		}
		if (out == null) {
			throw new IOException("OutputStream can not be null ");
		}
		if (maxWidth < 1 || maxHeight < 1) {
			throw new IOException("maxWidth or maxHeight can not be less than 1 ");
		}
		if (quality < 0f || quality > 1f) {
			throw new IOException("quality must be in [0-1] ");
		}
	}

}
