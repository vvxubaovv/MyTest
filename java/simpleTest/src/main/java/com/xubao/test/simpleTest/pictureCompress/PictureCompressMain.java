package com.xubao.test.simpleTest.pictureCompress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

public class PictureCompressMain {
	public static void main(String[] args) throws IOException {
		String src = "z://bb.jpg";
		compress(src,"",(float) 0.8);
		compress(src,"",(float) 0.6);
		compress(src,"",(float) 0.4);
		compress(src,"",(float) 0.2);
		compress(src,"",(float) 0.1);
		
		System.out.println("----------------------------");
		
//		compress1(src,"",(float) 0.8);
//		compress1(src,"",(float) 0.6);
//		compress1(src,"",(float) 0.4);
//		compress1(src,"",(float) 0.2);
//		compress1(src,"",(float) 0.1);
	}
	
	public static void compress(String src,String des,float compressRatio) {
		try {
			String before = src.substring(0, src.lastIndexOf('.'));
			String after = src.substring(src.lastIndexOf('.'));
			String fileName = before+compressRatio+after;
			long oldTime = System.currentTimeMillis();
			Thumbnails.of(src) 
			.scale(0.1f) 
			.outputQuality(compressRatio) 
			.toFile(fileName);
			
			long newTime = System.currentTimeMillis();
			System.out.println("compress "+fileName+" spend time="+(newTime-oldTime)+"ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void compress1(String src,String des,float compressRatio) {
		try {
			String before = src.substring(0, src.lastIndexOf('.'));
			String after = src.substring(src.lastIndexOf('.'));
			String fileName = before+compressRatio+after;
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(src);
			byte[] buf = new byte[1024];
			
			while(fis.read(buf)>-1) {
				baos.write(buf);
			}
			fis.close();
			
			
			long oldTime = System.currentTimeMillis();
			Builder<? extends InputStream> outputQuality = Thumbnails.of(new ByteArrayInputStream(baos.toByteArray())) 
			.scale(1f) 
			.outputQuality(compressRatio);
			outputQuality.toOutputStream(new ByteArrayOutputStream());
			long newTime = System.currentTimeMillis();
			System.out.println("compress "+fileName+" spend time="+(newTime-oldTime)+"ms");
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
