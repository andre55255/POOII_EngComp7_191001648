package com.bakehouse.services_impl;

import com.bakehouse.dao_impl.MovementImpl;
import com.bakehouse.dao_impl.UserImpl;
import com.bakehouse.dao_interfaces.IMovementDAO;
import com.bakehouse.dao_interfaces.IUserDAO;
import com.bakehouse.domain.Movement;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.ApplicationUser;
import com.bakehouse.helpers.Crypt;
import com.bakehouse.helpers.Result;
import com.bakehouse.services_interfaces.IAccountService;
import com.bakehouse.viewobjects.CreateEditUserVO;
import com.bakehouse.viewobjects.LoginVO;
import java.util.List;

public class AccountService implements IAccountService {

    private IUserDAO userDao;
    private IMovementDAO movementDao;
    
    public AccountService() {
        userDao = new UserImpl();
        movementDao = new MovementImpl();
    }
    
    @Override
    public Result login(LoginVO loginVO) {
        try {
            Result result = loginVO.valid();
            if (!result.isSuccess())
                return result;
            
            User user = userDao.findByLogin(loginVO.getLogin());
            if (user == null)
                return new Result("Usuário não encontrado", false);
            
            user.setStatus("Ativo");
            userDao.update(user);
            
            String passVO = Crypt.password(loginVO.getPassword());
            if (!passVO.equals(user.getPassword()) || !loginVO.getPassword().equals(user.getPassword()))
                return new Result("Senha não confere", false);
            
            ApplicationUser.setLoginUser(user);
            return new Result("Login efetuado com sucesso", true);
        } catch (Exception ex) {
            return new Result("Falha ao realizar login", false);
        }
    }

    @Override
    public Result createUser(CreateEditUserVO userVO) {
        try {
            Result valid = userVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            String hashPassword = Crypt.password(userVO.getPassword());
            
            User userEntity = new User();
            userEntity.setId(0);
            userEntity.setLogin(userVO.getLogin());
            userEntity.setName(userVO.getName());
            userEntity.setPassword(hashPassword);
            userEntity.setRole(userVO.getRole());
            userEntity.setStatus("Deslogado");
            
            Result resultCreate = userDao.insert(userEntity);
            return resultCreate;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao criar usuário", false);
        }
    }

    @Override
    public Result editUser(CreateEditUserVO userVO) {
        try {
            Result valid = userVO.valid();
            if (!valid.isSuccess())
                return valid;
            User userEdit = userDao.findById(userVO.getId());
            if (userEdit == null)
                return new Result("Usuário não encontrado para editar", false);
            
            String hashPassword = Crypt.password(userVO.getPassword());
            
            userEdit.setLogin(userVO.getLogin());
            userEdit.setName(userVO.getName());
            userEdit.setPassword(hashPassword);
            userEdit.setRole(userVO.getRole());

            return userDao.update(userEdit);
        } catch (Exception ex) {
            return new Result("Falha inesperada ao editar usuário", false);
        }
    }

    @Override
    public Result deleteUser(int id) {
        try {
            User user = userDao.findById(id);
            if (user == null)
                return new Result("Usuário não encontrado", false);
            
            List<Movement> movements = movementDao.findByUser(user);
            if (movements.size() > 0)
                return new Result("Não é possível excluir este usuário, ele possui vinculo com algum movimentos", false);
            
            Result resultDelete = userDao.delete(id);
            return resultDelete;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao deletar usuário", false);
        }
    }
}