package Util;

import java.net.*;
import java.io.*;

public class CusUtil{

    public static void main(String args[]) throws Exception {
        URL u=new URL("http://api.k780.com/?app=code.hanzi_pinyin&typeid=1&wd=需要转换的汉字&appkey=39641&sign=ce5c5f2602ba2f225c3801d0c0a7a59b&format=json");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        String jsonStr=new String(b,"utf-8");

        System.out.println(jsonStr.substring(jsonStr.indexOf("ret")+6,jsonStr.length()-3));
    }
    public static String getPinYin (String word)throws Exception{
        URL u=new URL("http://api.k780.com/?app=code.hanzi_pinyin&typeid=1&wd="+word+"&appkey=39641&sign=ce5c5f2602ba2f225c3801d0c0a7a59b&format=json");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        String jsonStr=new String(b,"utf-8");
        String pinyin=jsonStr.substring(jsonStr.indexOf("ret")+6,jsonStr.length()-3);
        //System.out.println(pinyin);
        return pinyin;
    }
}