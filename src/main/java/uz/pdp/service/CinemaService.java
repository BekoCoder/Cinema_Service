package uz.pdp.service;

import uz.pdp.model.Cinema;
import uz.pdp.repository.BoughtCinemaRepository;
import uz.pdp.repository.CinemRepository;
import java.util.ArrayList;
import java.util.UUID;

public class CinemaService  implements CinemRepository, BoughtCinemaRepository {
    public boolean checkCinema(ArrayList<Cinema> cinema, String  name){
        for (Cinema cinema1: getCinemaListFile()) {
            if(cinema1.getName().equals(name)){
                return true;
            }
        }
        return false;

    }

    public boolean addCinema(Cinema cinema){
        ArrayList<Cinema> cinemaList=getCinemaListFile();
        if (checkCinema(cinemaList, cinema.getName())){
            return false;
        }
        cinemaList.add(cinema);
        writeCinemaToFile(cinemaList);
        return true;
    }


    public boolean buyTicket(UUID id){
        ArrayList<Cinema> boughtCinema=getBoughtCinema();
        for (Cinema cinema : getCinemaListFile()) {
           if(cinema.getId().equals(id)){
               boughtCinema.add(cinema);
               writeBougthCinematoFile(boughtCinema);
               return true;
           }
        }
        return false;
    }


    public UUID gName(String name){
        for (Cinema cinema: getCinemaListFile()) {
            if(cinema.getName().equals(name)){
                return cinema.getId();
            }
        }
        return null;
    }



    public void whoBoughtCinema( UUID id){
        ArrayList<Cinema> boughtCinema=getBoughtCinema();
         for (Cinema cinema: getBoughtCinema()) {
            if(cinema.getId().equals(id)){
                boughtCinema.add(cinema);
                writeBougthCinematoFile(boughtCinema);
            }
        }


    }










}
