package top.jhana;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 从txt文件里取出相对路径里的文件名
 * 2. 拼接绝对路径base和target
 * 3. 开始复制文件
 */
public class CopyFile {

    public static String base = "D:\\FujitsuSVN\\ちば電子調達\\chiba_choutatsu\\trunk\\";

    public static String target = "C:\\Users\\li.gang3\\Desktop\\gaixiuqian\\";

    /**
     * Copy files
     *
     * @param source
     * @param target
     */
    public static void copy(List<String> source, List<String> target) throws IOException {

        if (source != null && target != null) {
            for (int i = 0; i < source.size(); i++) {
                File sourceFile = new File(source.get(i));
                File targetFile = new File(target.get(i));

                FileUtils.copyFile(sourceFile, targetFile);
            }
        }

    }

    /**
     * read the file list
     *
     * @return
     */
    public static List<String> read() throws Exception {

        FileInputStream inputStream = new FileInputStream("d:\\11.txt");
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = "";
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

        return list;
    }

    /**
     * main function
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("start....");

        //start code
        List<String> list = new ArrayList<>();
        List<String> slist = new ArrayList<>();
        List<String> tlist = new ArrayList<>();

        list = read();

        for (int i = 0; i < list.size(); i++) {
            //list.get(i);
            slist.add(base + list.get(i));
            tlist.add(target + list.get(i));
        }

            copy(slist, tlist);

        System.out.println("end....");
    }
}
