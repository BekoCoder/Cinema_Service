package uz.pdp.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import uz.pdp.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtil.*;

public interface UserRepository{
    File file=new File(userPath);
    default ArrayList<User> getUserListFile(){


        try {
            return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    default void writeUserToFile(ArrayList<User> userList){
        try {
            objectMapper.writeValue(file, userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
