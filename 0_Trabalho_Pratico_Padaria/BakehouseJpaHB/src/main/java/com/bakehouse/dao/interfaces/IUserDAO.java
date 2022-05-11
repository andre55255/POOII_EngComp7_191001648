package com.bakehouse.dao.interfaces;

import com.bakehouse.domain.Role;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface IUserDAO {
    
    public Result insert(User user);
    
    public Result update(User user);
    
    public Result delete(int id);
    
    public User findById(int id);
    
    public List<User> findAll();
    
    public List<User> findByName(String name);
    
    public List<User> findByRole(String roleStr);
    
    public User findByLogin(String login);
}