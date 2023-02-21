import java.io.*;
import java.util.Scanner;

public class FileHandleJava {

    public static void main(String[] args) throws IOException {

        FileHandleJava fhj = new FileHandleJava();

          File f1 = fhj.createFile();
          fhj.basicChecks(f1);
          fhj.writeSomething(f1);
          String data = fhj.readSomething(f1);
          System.out.println(data);

    }

    private String readSomething(File f1) {

        String c="";
        try {
            FileReader fr = new FileReader(f1);
            int a;

            while((a=fr.read())!=-1){
                c = c+(char)a;
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    private void basicChecks(File f1) {

        System.out.println("=============================FILE Checkup=========================");
        System.out.println("Existence: "+f1.exists());
        System.out.println("Name: "+f1.getName());
        System.out.println("Path: "+f1.getAbsolutePath());
        System.out.println("Writable: "+f1.canWrite());
        System.out.println("Readable: "+f1.canRead());
        System.out.println("Length of file: "+f1.length());
        System.out.println("==================================================================");


    }

    private void writeSomething(File f1){

        try {
            if(f1.length()>1){
                FileWriter flw = new FileWriter(f1,true);
                flw.write("Append:- Count!!!\n");
                flw.close();
                System.out.println("Appended!!!!");
            }else{
                FileWriter flw = new FileWriter(f1);
                flw.write("Add:- Count!!!\n");
                flw.write("Add:- Count!!!\n");
                flw.write("Add:- Count!!!\n");
                flw.close();
                System.out.println("Content Added!!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    private File createFile() throws IOException {

        System.out.println("Enter file name");
        String fname = new Scanner(System.in).nextLine();

        File file1 = new File("src/" + fname + ".txt");

        if (file1.exists()) {
            System.out.println("File already present!!");
        } else {
                file1.createNewFile();
                System.out.println(file1.getName() + " is created!!");
        }
        return file1;
    }

}

