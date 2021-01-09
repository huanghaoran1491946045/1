package cn.edu.jsu.hhr.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class loginrecord {
	public static void In(String str) throws IOException {
		File file =new File("D:"+File.separator+"test"+File.separator+"loginrecord.txt");
		FileOutputStream fo =new FileOutputStream(file,true);
		SimpleDateFormat ds= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ans=str+"ÓÚ"+ds.format(new Date())+"³É¹¦µÇÂ½\r\n";
		fo.write(ans.getBytes());
		fo.close();
	}
}
