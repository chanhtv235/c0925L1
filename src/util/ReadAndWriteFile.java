package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static void writeStringListToCSV(String pathFile, List<String> stringList,boolean append){
        File file = new File(pathFile);
        try(FileWriter fileWriter = new FileWriter(file,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ){
            for (int i = 0; i <stringList.size() ; i++) {
                bufferedWriter.write(stringList.get(i));
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            System.out.println("Lỗi ghi file");
        }
    }
    public static List<String>  readFileCSVToStringList(String pathFile){
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String line =null;
         while ((line = bufferedReader.readLine())!=null){
             stringList.add(line);
         }
        }catch (Exception e){
            System.out.println("Lỗi ghi file");
        }
        return stringList;
    }
}
