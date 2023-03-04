package uz.pdp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import uz.pdp.model.Cinema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtil.buyCinemaPath;
import static uz.pdp.util.FileUtil.objectMapper;

public interface BoughtCinemaRepository {
    File file=new File(buyCinemaPath);
    default ArrayList<Cinema> getBoughtCinema(){
        try {
            return  objectMapper.readValue(file, new TypeReference<ArrayList<Cinema>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    default void writeBougthCinematoFile(ArrayList<Cinema> cinemas){
        try {
            objectMapper.writeValue(file, cinemas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
