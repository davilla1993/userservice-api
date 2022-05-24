package com.follydev.userservice.services;

import com.follydev.userservice.domain.AppUser;
import com.follydev.userservice.domain.Role;

import java.util.List;

public interface UserServices {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
