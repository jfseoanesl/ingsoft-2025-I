package org.example.good;



public class Main {
    public static void main(String[] args) {

        UserService service = new UserService(new ListPersistenceImp());
        User user = new User("usuario", "12345");
        service.save(user);

        service.edit(new User("usuario", "3456"));
        User eenc = service.find("usuario");
        System.out.println( eenc.getUsername()+"," + eenc.getPassword());




    }



}

