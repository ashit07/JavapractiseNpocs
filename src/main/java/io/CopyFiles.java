package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyFiles {
  private static class abc implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
      // TODO Auto-generated method stub
      return name.endsWith(".sh");
    }
  }

  public static void copyFiles(File sourceLocation, File targetLocation) throws IOException {

    if (sourceLocation.isDirectory()) {
      if (!targetLocation.exists()) {
        targetLocation.mkdir();
      }
      File[] files = sourceLocation.listFiles();

      File[] filename = sourceLocation.listFiles(new abc());
      /*
       * File[] filename=sourceLocation.listFiles(new FilenameFilter() { public boolean accept(File
       * dir, String filena) { return filena.endsWith(".sh"); } });
       */
      System.out.println("filename is " + filename[0].getName());
      for (File file : files) {
        InputStream in = null;
        OutputStream out = null;
        try {
          in = new FileInputStream(file);;
          out = new FileOutputStream(targetLocation + "/" + file.getName());;
          if (file.getName().endsWith(".txt")) {
            String abc = file.getName();
            // getRegexPattern(abc);
            System.out.println(abc);


            // InputStream in = new FileInputStream(file);
            // OutputStream out= new FileOutputStream(targetLocation+"/"+file.getName());

            System.out.println("sourceLocation is " + sourceLocation.getPath());
            // Copy the bits from input stream to output stream

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
              out.write(buf, 0, len);
            }


          }
        } finally {
          try {
            if (out != null)
              out.close();
          } finally {
            if (in != null)
              in.close();
          }
        }
      }
    }
  }

  public static String getRegexPattern(String toMatch) {
    // String pattern = "^ccx[0-9][0-9][0-9].[pre][pre][pre].demo.lic$";
    String pattern = "(.*ccx.*pre.*demo.lic$)";
    Pattern r = Pattern.compile(pattern);
    String name = null;
    // Now create matcher object.
    Matcher m = r.matcher(toMatch);
    if (m.find()) {
      name = m.group(0);
    }
    return name;
  }



  public static void main(String args[]) {
    /*
     * String toMatch="ccx100_pre_demo.lic"; String name = getRegexPattern(toMatch);
     * System.out.println(name);
     */
    File f = new File("C:/Users/ashijune/Desktop/abc/");
    File f2 = new File("C:/Users/ashijune/Desktop/bcd");
    try {
      copyFiles(f, f2);
    } catch (IOException e) {

    }
    System.out.println("Copied");
  }
}
