package br.com.rafael.techstore.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafael.techstore.dto.ResponseHandlerDto;
import br.com.rafael.techstore.dto.UserRegistrationDto;
import br.com.rafael.techstore.mapper.DozerMapper;
import br.com.rafael.techstore.models.User;
import br.com.rafael.techstore.services.UserServices;
import jakarta.validation.Valid;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/registration")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody() UserRegistrationDto userRegistrationDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            });

            return ResponseHandlerDto.createResponse(errorMessage.toString(), HttpStatus.BAD_REQUEST, null);
        }

        try {
            User user = userServices.createUser(buildUserRegistration(userRegistrationDto));
            return ResponseHandlerDto.createResponse("Usuário criado com sucesso!", HttpStatus.CREATED,
                    user);
        } catch (Exception e) {
            var cause = e.getCause();
            if (cause instanceof ConstraintViolationException) {
                ConstraintViolationException consEx = (ConstraintViolationException) cause;
                return ResponseHandlerDto.createResponse("Erro de duplicação " + consEx.getConstraintName(), HttpStatus.CONFLICT, null);
            }

            return ResponseHandlerDto.createResponse("Error: " + e.getCause(), HttpStatus.CONFLICT, null);
        }
    }

    User buildUserRegistration(UserRegistrationDto userRegistrationDto) {
        User user = DozerMapper.parseObject(userRegistrationDto, User.class);
        user.setFullName(userRegistrationDto.getFirstName() + " " + userRegistrationDto.getLastName());
        return user;
    }
}
