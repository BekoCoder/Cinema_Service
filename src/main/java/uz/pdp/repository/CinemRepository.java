package uz.pdp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.ArrayType;
import uz.pdp.model.Cinema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtil.cinemaPath;
import static uz.pdp.util.FileUtil.objectMapper;

public interface CinemRepository {
    File file=new File(cinemaPath);


    default ArrayList<Cinema> getCinemaListFile(){
        try {
           return objectMapper.readValue(file, new TypeReference<ArrayList<Cinema>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    default void writeCinemaToFile (ArrayList<Cinema> cinemaList){
        try {
            objectMapper.writeValue(file, cinemaList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
