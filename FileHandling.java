package com.sesi11;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class FileHandling {
   static int pil;

   // MEMBUAT FILE

    public static void Create() {
        try {
            File myObj = new File("file.json");
            if (myObj.createNewFile()) {
                System.out.println("FILE CREATE  : "+ myObj.getName());
            } else {
                System.out.println("\nFile already exist\n");
            }
        } catch (IOException e) {
            System.out.println("\nan error occured\n");
            e.printStackTrace();
        }
    }

    //MENULIS ISI DALAM FILE

    public static void Write() {
        try {
            FileWriter myWriter = new FileWriter("file.json");
            Scanner input = new Scanner(System.in);
            System.out.print("Masukan Nama    : ");
            String Nama = input.nextLine();
            myWriter.write(Nama);
            System.out.print("Masukan NIM     : ");
            String NIM = input.nextLine();
            myWriter.write(NIM);
            System.out.print("Masukan Jurusan : ");
            String Jurusan = input.nextLine();
            myWriter.write(Jurusan);
            System.out.print("Masukan Ttl     : ");
            String Ttl = input.nextLine();
            myWriter.write(Ttl);
            
            myWriter.close();
            System.out.println("\nSuccesfully wrote to the file\n");
        } catch (IOException e) {
            System.out.println("\nan error occured\n");
            e.printStackTrace();
        }
    }
     //MEMBACA FILE
     public static void Read() {
        try {
            File myObj = new File("file.json");
            Scanner input = new Scanner(myObj);
            System.out.print("Menampilkan Isi file : ");
            while (input.hasNextLine()) {
                String data = input.nextLine();
                System.out.println(data);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nan Error occured\n");
            e.printStackTrace();
        }
    }


    //MENGHAPUS FILE

    public static void Delete() {
        File myObj = new File("file.json");
        if (myObj.delete()) {
            System.out.println("\nDeleted the file " + myObj.getName());
        } else {
            System.out.println("\nFailed to delete the file");
        }
    }

   


    public static void main(String[] args) {
        Create();     // Mmebuat file terlebih dahulu
        while (true){   // Perulangan while . selama bernilai true atau benar atau bukan nol maka program akan terus berjalan

        Scanner input = new Scanner(System.in);
        System.out.println("\n====== FILE HANDLING =====\n");
        System.out.println(" 1. WRITE \n 2. READ \n 3. DELETE \n ");
        System.out.print(" Masukan Pilihan Anda : ");
        pil = input.nextInt();

        if(pil == 1){     // KONDISI . jika pil bernilai 1 maka akan menulis dalam file yang sudah dibuat 
            Write();
        }else if(pil == 2){  //KONDISI . jika pil bernilai 2 maka program akan membaca isi dalam file yang sudah dibuat
            Read();
        }else if(pil ==3) { // KONDISI . jika pil bernilai 3 maka program akan menghapus file yang sudah dibuat
            Delete();
        }else{             // KONDISI . jika pilihan tidak ada maka akan menampilkan perintah untuk memasukan ulang pilihan
            System.out.println("Pilihan Anda tidak ada dalam daftar silahkan masukan kembali pilihan anda");
        }
    }
}
}