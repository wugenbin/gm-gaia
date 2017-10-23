package com.ntc.gaia.base.utils.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成助手类
 * 
 * @author allen
 * @date 2015-7-28
 * 
 */
public class AuthCodeUtil {

	// 图片的宽度
	private final static int IMAGEWIDTH = 13;

	// 图片的高度
	private final static int IMAGEHEIGHT = 25;

	// 字体大小
	private final static int FONTSIZE = 18;

	// 字符串长度
	private final static int CODELENGTH = 4;

	// 单个验证码之间间隔
	private final static int SINGLECODE_GAP = 5;

	public static final int IMG_WIDTH = CODELENGTH
			* (IMAGEWIDTH + SINGLECODE_GAP);

	// 随机字符范围
	private final static char[] CHAR_RANGE = { 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7',
			'8', '9' };
	private static Random random = new Random();

	/**
	 * 生成随机颜色
	 * 
	 * @param ll
	 *            产生颜色值下限(lower limit)
	 * @param ul
	 *            产生颜色值上限(upper limit)
	 * @return 生成的随机颜色对象
	 */
	private static Color getRandColor(int ll, int ul) {
		if (ll > 255)
			ll = 255;
		if (ll < 1)
			ll = 1;
		if (ul > 255)
			ul = 255;
		if (ul < 1)
			ul = 1;
		if (ul == ll)
			ul = ll + 1;
		int r = random.nextInt(ul - ll) + ll;
		int g = random.nextInt(ul - ll) + ll;
		int b = random.nextInt(ul - ll) + ll;
		Color color = new Color(r, g, b);
		return color;
	}

	/**
	 * 生成随机字符串
	 * 
	 * @return 随机字符串
	 */
	public static String getAuthCode() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < CODELENGTH; i++)

			sb.append(CHAR_RANGE[random.nextInt(CHAR_RANGE.length)]);
		return sb.toString();
	}

	/**
	 * 生成指定字符串的图像数据
	 * 
	 * @param verifyCode
	 *            即将被打印的随机字符串
	 * @return 生成的图像数据
	 * */
	public static BufferedImage getAuthImg(String verifyCode) {

		// 生成画布
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMAGEHEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文 （生成画笔）
		Graphics graphics = image.getGraphics();

		// 设置背景色（）
		//graphics.setColor(getRandColor(1, 50));
		graphics.setColor(Color.WHITE);

		// 填充矩形区域 ，作为背景
		graphics.fillRect(0, 0, IMAGEWIDTH * 6, IMAGEHEIGHT);

		// 画出边框
		for (int i = 0; i < 2; i++)
			graphics.drawRect(i, i, IMAGEWIDTH * CODELENGTH - i * 2 - 1,
					IMAGEHEIGHT - i * 2 - 1);

		// 设置随机干扰线条颜色
		//graphics.setColor(getRandColor(50, 100));

		// 产生50条干扰线条
		for (int i = 0; i < 50; i++) {
			int x1 = random.nextInt(IMAGEWIDTH * CODELENGTH - 4) + 2;
			int y1 = random.nextInt(IMAGEHEIGHT - 4) + 2;
			int x2 = random.nextInt(IMAGEWIDTH * CODELENGTH - 2 - x1) + x1;
			int y2 = y1;
			graphics.drawLine(x1, y1, x2, y2);
		}

		// 设置字体
		graphics.setFont(new Font("Times New Roman", Font.PLAIN, FONTSIZE));

		// 画字符串
		for (int i = 0; i < CODELENGTH; i++) {

			String temp = verifyCode.substring(i, i + 1);
			graphics.setColor(getRandColor(0, 150));
			graphics.drawString(temp, 16 * i + 6, 18);
		}

		// 图像生效
		graphics.dispose();
		return image;
	}
}