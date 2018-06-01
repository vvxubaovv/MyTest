package com.xubao.test.simpleTest.dataCompress;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShotCompressMain {

	public static void main(String[] args) throws Exception {
		System.out.println("开始截取第一张");
		BufferedImage screenShot1 = getScreenShot(new Rectangle(0, 0, 500, 500));
		System.out.println("截取第一张结束");
		saveScreenShot(screenShot1, "z:/ss1.bmp");
		Thread.sleep(10 * 1000);
		System.out.println("开始截取第二张");
		BufferedImage screenShot2 = getScreenShot(new Rectangle(0, 0, 500, 500));
		System.out.println("截取第二张结束");
		saveScreenShot(screenShot2, "z:/ss2.bmp");

		System.out.println("开始比较----------");

		int width = screenShot1.getWidth();
		int height = screenShot1.getHeight();

		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (screenShot1.getRGB(i, j) != screenShot2.getRGB(i, j)) {
//					System.out.println(String.format("%s,%s 1:%s 2:%s"
//							, i,j,screenShot1.getRGB(i, j),screenShot2.getRGB(i, j)));
				}
			}
		}
		System.out.println(System.currentTimeMillis());
		
		System.out.println("比较结束");
	}

	public static BufferedImage getScreenShot(Rectangle rect) throws AWTException {
		Robot robot = new Robot();
		return robot.createScreenCapture(rect);
	}

	public static void saveScreenShot(BufferedImage bufImg, String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		ImageIO.write(bufImg, "jpg", fos);
		System.out.println("保存图片" + filePath + "结束");
	}

}
