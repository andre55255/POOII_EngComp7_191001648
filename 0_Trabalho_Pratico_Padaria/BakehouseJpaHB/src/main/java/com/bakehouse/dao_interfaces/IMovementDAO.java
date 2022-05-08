package com.bakehouse.dao_interfaces;

import com.bakehouse.domain.Movement;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.Result;
import java.time.LocalDateTime;
import java.util.List;

public interface IMovementDAO {
    
    public Result insert(Movement movement);
    
    public Result update(Movement movement);
    
    public Result delete(int id);
    
    public List<Movement> findAll();
    
    public Movement findById(int id);
    
    public List<Movement> findByDate(LocalDateTime dateInitial, LocalDateTime dateFinal);
    
    public List<Movement> findByUser(User user);
    
    public List<Movement> findByType(String type);
    
    public List<Movement> findbyValue(double valueInitial, double finalValue);
    
    public List<Movement> findByDescription(String description);
}