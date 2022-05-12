package com.bakehouse.services.impl;

import com.bakehouse.dao.impl.MovementDAOImpl;
import com.bakehouse.dao.impl.UserDAOImpl;
import com.bakehouse.dao.interfaces.IMovementDAO;
import com.bakehouse.dao.interfaces.IUserDAO;
import com.bakehouse.domain.Movement;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.ApplicationUser;
import com.bakehouse.helpers.Crypt;
import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import com.bakehouse.viewobjects.account.LoginVO;
import java.util.List;

public class AccountService implements IAccountService {

    private IUserDAO userDao;
    private IMovementDAO movementDao;
    
    public AccountService() {
        userDao = new UserDAOImpl();
        movementDao = new MovementDAOImpl();
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
            
            String passVO = Crypt.password(loginVO.getPassword());
            if (!passVO.equals(user.getPassword()) && !loginVO.getPassword().equals(user.getPassword()))
                return new Result("Senha não confere", false);
            
            user.setStatus("Ativo");
            userDao.update(user);
            
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
            
            if (userVO.getPassword() != null && !Validations.stringIsNullOrEmpty(userVO.getPassword())) {
                String hashPassword = Crypt.password(userVO.getPassword());
                userEdit.setPassword(hashPassword);
            } 
            
            userEdit.setLogin(userVO.getLogin());
            userEdit.setName(userVO.getName());
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