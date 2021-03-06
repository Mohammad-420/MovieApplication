package Database;

import Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase extends Database<User> {
    private static UserDatabase instance;

    private UserDatabase(String path){
        super(path);
    }

    public static UserDatabase getInstance(String path){
        if(instance == null)
            instance = new UserDatabase(path);
        return instance;
    }

    public void create(User user){
        super.create(user);
    }

    public List<User> read(){
        return super.read();
    }

    public void update(int oldUserIndex,User newUser){
        super.update(oldUserIndex,newUser);
    }

    public void delete(int index){
        super.delete(index);
    }
}
