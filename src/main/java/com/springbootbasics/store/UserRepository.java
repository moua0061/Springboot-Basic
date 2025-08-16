package com.springbootbasics.store;

public interface UserRepository {
    public void save(User user);

    User findByEmail(String email);
}
