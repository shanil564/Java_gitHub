package com.example.springBootMiniProject.service.implementation;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.Repository.ApplicationUserRepository;
import com.example.springBootMiniProject.dto.Response;
import com.example.springBootMiniProject.exception.DuplicateUserException;
import com.example.springBootMiniProject.entity.ApplicationUser;
import com.example.springBootMiniProject.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    public ApplicationUser getUser(Long userId) {
        ApplicationUser applicationUser=applicationUserRepository.findByUserId(userId);
        if (Objects.nonNull(applicationUser)){
            return applicationUser;
        }else {
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND_EXCEPTION_MSG);
        }

    }
    public ApplicationUser saveUser(ApplicationUser applicationUser) throws DuplicateUserException{
        if(applicationUserRepository.findByUserName(applicationUser.getUserName())!=null) {
            throw new DuplicateUserException(Constants.DUPLICATE_EXCEPTION_MSG);
        }
        return applicationUserRepository.save(applicationUser);
    }
    public ResponseEntity<?> updateUser(ApplicationUser applicationUser) {
        Response response = new Response();
        Optional<ApplicationUser> appUser = applicationUserRepository.findById(applicationUser.getUserId());
        appUser.get().setUserId(applicationUser.getUserId());
        appUser.get().setRole(applicationUser.getRole());
        response.setResponse(applicationUserRepository.save(appUser.get()));
        response.setStatus(true);
        response.setMessage(Constants.MSG_UPDATED);
        return ResponseEntity.ok(response);
    }
    public void deleteUser(ApplicationUser applicationUser) {
        try{
            applicationUserRepository.deleteById(applicationUser.getUserId());
        }catch (Exception e){
            throw new RecordNotFoundException(Constants.RECORD_NOT_FOUND_EXCEPTION_MSG);
        }
    }
    public List<ApplicationUser> getAllUser() {
        return applicationUserRepository.findAll();
    }
}
