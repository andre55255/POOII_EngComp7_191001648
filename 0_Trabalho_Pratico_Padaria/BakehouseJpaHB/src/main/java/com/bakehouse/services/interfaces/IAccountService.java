package com.bakehouse.services.interfaces;

import com.bakehouse.helpers.Result;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import com.bakehouse.viewobjects.account.LoginVO;
import com.bakehouse.viewobjects.account.RoleVO;

public interface IAccountService {
    
    public Result login(LoginVO loginVO);
    
    public Result createUser(CreateEditUserVO userVO);
    
    public Result editUser(CreateEditUserVO userVO);
    
    public Result deleteUser(int id);
    
    public Result createRole(RoleVO roleVO);
    
    public Result editRole(RoleVO roleVO);
    
    public Result deleteRole(int id);
}