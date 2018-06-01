package com.xubao.test.simpleTest.imageTest;

import javax.imageio.ImageIO;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/4/14
 */
public class ImageTest
{
	public static void main(String[] args){
		showArray(ImageIO.getReaderFormatNames());
	}

	public static void showArray(Object[] objArr){
		for(Object obj:objArr){
			System.out.println(obj);
		}
	}

}
