package com.employee.file.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public List<String> readFile(String filePath){
        List<String> lines = new ArrayList<>();
        try{
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            boolean isFirstLine = true;
            while( (line = br.readLine()) != null){
                if(!isFirstLine) {
                    lines.add(line);
                }else{
                    isFirstLine = false;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return lines;
    }
}
