package com.xubao.test.simpleTest.dataCompress;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xerial.snappy.Snappy;

public class DataCompressMain {
	public static void main(String[] args) throws IOException {

		byte[] first = getBytes("z:/1.jpg");
		byte[] second = getBytes("z:/2.jpg");
		System.out.println("first.length="+first.length);
		System.out.println("second.length="+second.length);
		
		byte[] third = getDefault(first, second);
		System.out.println("third.length="+third.length);
		
		byte[] forth = getDefault(first, third);
		System.out.println("forth.length="+forth.length);
		
		copyImage(first, "z:/1c.jpg");
		copyImage(second,"z:/2c.jpg");
		copyImage(third,"z:/3c.jpg");
		copyImage(forth,"z:/4c.jpg");
		
		
		byte[] five = Snappy.compress(third);
		System.out.println("five.length="+five.length);
	}

	public static byte[] getBytes(String filePath) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream fis = new FileInputStream(filePath);
		byte[] buf = new byte[1024];
		while (fis.read(buf) > 0) {
			baos.write(buf);
		}
		fis.close();

		return baos.toByteArray();
	}
	
	public static void copyImage(byte[] imgByte,String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(imgByte);
		fos.close();
	}

	public static byte[] getDefault(byte[] first, byte[] second) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int length = first.length < second.length ? first.length : second.length;
		for (int i = 0; i < length; i++) {
			baos.write(first[i]^second[i]);
		}
		for(int j = length;j<second.length;j++) {
			baos.write(second[j]);
		}
		
		return baos.toByteArray();
	}
}
