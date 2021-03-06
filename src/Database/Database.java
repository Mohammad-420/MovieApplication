package Database;

import Entity.Model;
import Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database<T extends Model> {
    private String path;

    protected Database(String path){
        this.path = path;
    }

    protected void create(T user){
        try{
            List<T> users;
            if(read() == null)
                users = new ArrayList();
            else
                users = read();

            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            users.add(user);

            objectOutputStream.writeObject(users);
            objectOutputStream.flush();
            objectOutputStream.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<T> read(){
        try{
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<T> users = (List<T>) objectInputStream.readObject();

            return users;

        }catch (Exception e) {
            return null;
        }
    }

    protected void update(int oldItemIndex,T newItem){
        try {
            List<T> users = read();
            users.set(oldItemIndex, newItem);

            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(users);
            objectOutputStream.flush();
            objectOutputStream.close();

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    protected void delete(int index){
        try{
            List<T> items = read();

            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            items.remove(index);

            objectOutputStream.writeObject(items);

            objectOutputStream.flush();
            objectOutputStream.close();

        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
