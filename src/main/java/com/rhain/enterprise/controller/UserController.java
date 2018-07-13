package com.rhain.enterprise.controller;


import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.User;
import com.rhain.enterprise.model.UserIdentity;
import com.rhain.enterprise.payload.*;
import com.rhain.enterprise.security.CurrentUser;
import com.rhain.enterprise.security.UserPrincipal;
import com.rhain.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public UsersResponse getAllUsers(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                                              @RequestParam(name = "limit", required = false, defaultValue = "10") int pageSize) {
        PageInfo<UserIdentity> users = userService.findAllUser(pageNum, pageSize);
        return new UsersResponse(true, users);
    }

    @DeleteMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(name = "username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok(new ApiResponse(true, "Delete user:" + username + " successfully"));
    }

    @PutMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody UserIdentity user){
        userService.updateUser(user);
        return ResponseEntity.ok(new ApiResponse(true, "Update user successfully"));
    }

    @GetMapping("/user/info")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(true, currentUser.getId(), currentUser.getUsername(), currentUser.getPhone(), currentUser.getRoles());
    }

    @GetMapping("/user/checkUsername")
    public PayloadResponse checkUsernameAvailability(@RequestParam(value = "username")String username){
        User user = userService.getByUsername(username);
        if(user != null){
            return new PayloadResponse(true, true);
        }
        return new PayloadResponse(true, false);
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public PayloadResponse<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
        User user = userService.getByUsername(signUpRequest.getUsername());
        if(user != null){
            new PayloadResponse<UserIdentity>(true, "Username is already taken!");
        }
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        UserIdentity userIdentity = userService.addUser(signUpRequest);


        return new PayloadResponse<UserIdentity>(true, "User registered successfully", userIdentity);
    }
}
