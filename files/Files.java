package com.onedevz.noct.fragments.functions;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

public class Files {

    Context context;
    public Files(Context context) {
        this.context = context;
    }

    public void writeFiles(String FILE_NAME,String content){
        FileOutputStream fos = null;
        String filename = FILE_NAME + ".txt";
        try {
            fos = context.openFileOutput(filename, MODE_PRIVATE);
            String contentTrim = content.trim();
            fos.write(contentTrim.getBytes());

            Toast.makeText(context, "Saved to " + context.getFilesDir() + "/" + filename,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readFiles(String FILE_NAME){
        String read = "";
        FileInputStream fis = null;
        String filename = FILE_NAME + ".txt";
        try {
            fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            read = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return read;
    }

    public void listFiles(){
        String path = String.valueOf(context.getFilesDir());
        Toast.makeText(context,"Path"+path,Toast.LENGTH_SHORT).show();
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);

        Toast.makeText(context,"Size: "+ files.length,Toast.LENGTH_SHORT).show();
        for (int i = 0; i < files.length; i++)
        {
            Toast.makeText(context,"FileName:" + files[i].getName(),Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteFiles(String FILE_NAME){
        String filename = FILE_NAME + ".txt";
        File dir = context.getFilesDir();
        File file = new File(dir,filename);
        boolean deleted = file.delete();
    }

    public void renameFiles(String oldName,String newName){
        String oldname = oldName+".txt";
        String newname = newName+".txt";
        File oldfile = context.getFileStreamPath(oldname);
        File newfile = context.getFileStreamPath(newname);
        oldfile.renameTo(newfile);
        Toast.makeText(context,oldName,Toast.LENGTH_SHORT).show();
    }
}
