package org.example.good;

public interface IPersistence {
    void save(User user);
    void delete(User user);
    void edit(User user);
    User find(String username);
}
