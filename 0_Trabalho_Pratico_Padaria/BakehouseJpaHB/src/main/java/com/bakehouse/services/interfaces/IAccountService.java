package com.bakehouse.services.interfaces;

import com.bakehouse.helpers.Result;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import com.bakehouse.viewobjects.account.LoginVO;

public interface IAccountService {
    
    public Result login(LoginVO loginVO);
    
    public Result createUser(CreateEditUserVO userVO);
    
    public Result editUser(CreateEditUserVO userVO);
    
    public Result deleteUser(int id);
}