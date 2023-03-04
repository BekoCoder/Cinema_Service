package uz.pdp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public interface FileUtil {
    ObjectMapper objectMapper=new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT,true);
    String cinemaPath="C:\\Users\\user\\IdeaProjects\\Imtihon\\src\\main\\resources\\cinema.json";
    String userPath="C:\\Users\\user\\IdeaProjects\\Imtihon\\src\\main\\resources\\users.json";
    String  cardPath="C:\\Users\\user\\IdeaProjects\\Imtihon\\src\\main\\resources\\cards.json";
    String buyCinemaPath="C:\\Users\\user\\IdeaProjects\\Imtihon\\src\\main\\resources\\boughtCinema.json";


}
