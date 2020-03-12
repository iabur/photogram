package com.spring5.practice.service;

import com.spring5.practice.dtos.UserDto;
import com.spring5.practice.enums.Role;
import com.spring5.practice.repositories.UserRepository;
import com.spring5.practice.util.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
    }

    public com.spring5.practice.model.User findUserByName(String name)
    {
        var user = userRepository.findByUsername(name).get();
        return user;
    }

    public void save(UserDto userDto, MultipartFile file){
        savePhoto(file);
        var newUser = new com.spring5.practice.model.User();
        BeanUtils.copyProperties(userDto, newUser);
        newUser.setPhoto("/img/"+file.getOriginalFilename());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRole(Role.ROLE_ADMIN);
        userRepository.save(newUser);
    }

    private void savePhoto(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("Please select a file to upload");
        }
        try {
            byte[] bytes = file.getBytes();
            String absoluteFilePath = Constants.UPLOADED_FOLDER;
            Path path = Paths.get(absoluteFilePath + file.getOriginalFilename());
            File dir = Paths.get(absoluteFilePath).toFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Files.write(path, bytes);
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveEdit(UserDto userDto, MultipartFile file){
        savePhoto(file);
        var previousUser= userRepository.findById(userDto.getId()).get();
        var previousPass = previousUser.getPassword();
        var previousUserName = previousUser.getUsername();
        BeanUtils.copyProperties(userDto,previousUser);
        previousUser.setPassword(previousPass);
        previousUser.setUsername(previousUserName);
        previousUser.setRole(Role.ROLE_ADMIN);
        previousUser.setPhoto("/img/"+file.getOriginalFilename());
        userRepository.save(previousUser);
    }
}
