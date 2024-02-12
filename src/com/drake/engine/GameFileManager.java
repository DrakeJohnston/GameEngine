package com.drake.engine;

import com.drake.engine.math.Vector2;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class GameFileManager {

    private static HashMap<String, String> data = new HashMap<>();
    private static String fileExtension = ".sgam";
    public static String SaveLocation = "./data/";

    public static void SaveString(String varName, String value){
        data.put(varName, value);
    }

    public static void SaveDouble(String varName, double value){
        data.put(varName, String.valueOf(value));
    }

    public static void SaveLong(String varName, long value){
        data.put(varName, String.valueOf(value));
    }

    public static void SaveInteger(String varName, int value){
        data.put(varName, String.valueOf(value));
    }

    public static void SaveBoolean(String varName, boolean value){
        data.put(varName, String.valueOf(value));
    }

//    public static void SaveVector(String name, Vector2 vec){
//        int x = vec.x;
//        int y = vec.y;
//
//        String str = new String(x + "," + y);
//        data.put(name, str);
//    }

    /**
     * Saves data in the data list to a specified file with
     * filename
     * @param fileName name of the file to save
     */
    public static void SaveData(String fileName){
        File file = new File(SaveLocation+fileName+fileExtension);
        try (FileWriter wr = new FileWriter(file)){
            for(String key : data.keySet()){
                String value = data.get(key);

                String f = key + ":" + value + "\n";
                wr.write(f);
            }
        }catch (IOException e){
            System.out.println("File creation failed");
        }
    }

    /**
     * Offers the ability to change the file extension
     * @param fileExt the desired file extention to use
     * @param fileName name of the file to save
     */
    public static void SaveData(String fileExt, String fileName){
        File file = new File(SaveLocation+fileName+fileExt);
        try (FileWriter wr = new FileWriter(file)){
            for(String key : data.keySet()){
                String value = data.get(key);

                String f = key + ":" + value + "\n";
                wr.write(f);
            }
        }catch (IOException e){
            System.out.println("File creation failed");
        }
    }

    /**
     * Loads the data from the save file
     * @param filePath file path of the data file
     */
    public static void LoadData(String filePath){
        File file = new File(filePath);
        try(Scanner scan = new Scanner(file)){
            if(scan.hasNext()){
                String ln = scan.nextLine();
                String[] tmp = ln.split(":");
                data.put(tmp[0], tmp[1]);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!!");
        }
    }

    /**
     * @param varName name of the stored variable
     * @param <T> type of the variable
     * @return returns the variable stored
     */
    public static <T> T GetData(String varName){
        if(data.containsKey(varName)) {
            return (T) data.get(varName);
        }else {
            return null;
        }
    }

    /**
     * @return returns the file extension
     */
    public static String getFileExtension() {
        return fileExtension;
    }

    /**
     * @return returns the current save location
     */
    public static String getSaveLocation() {
        return SaveLocation;
    }

    /**
     * Sets the save location
     * @param saveLocation the location to use
     */
    public static void setSaveLocation(String saveLocation) {
        SaveLocation = saveLocation;
    }

    /**
     * Sets the file extension to use in loads and saves
     * @param fileExtension the file extension to use
     */
    public void setFileExtension(String fileExtension) {
        GameFileManager.fileExtension = fileExtension;
    }
}
