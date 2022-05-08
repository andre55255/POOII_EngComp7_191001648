package com.bakehouse.dao_interfaces;

import com.bakehouse.domain.Role;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface IRoleDAO {
    
    public Result insert(Role role);
    
    public Result update(Role role);
    
    public Result delete(int id);
    
    public Role findById(int id);
    
    public List<Role> findAll();
    
    public List<Role> findByDescription(String description);
}