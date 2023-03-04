package uz.pdp.service;

import uz.pdp.model.User;
import uz.pdp.repository.UserRepository;

import java.util.ArrayList;

public class UserService implements UserRepository {

    public boolean checkEmail(ArrayList<User> users, String email) {
        for (User user : getUserListFile()) {
            if (user.getEmail().equals(email)) {
                return true;
            }

        }
        return false;
    }
    public boolean Register(User user){
        ArrayList<User> arrayList=getUserListFile();
        if(checkEmail(arrayList, user.getEmail())){
            return false;
        }
        arrayList.add(user);
        writeUserToFile(arrayList);
        return true;
    }
    public  User login(String email, String password){
        for (User user: getUserListFile()) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;

    }





}
