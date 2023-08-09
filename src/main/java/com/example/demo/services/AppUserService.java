// package com.example.demo.services;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.demo.entities.AppUser;
// import com.example.demo.repositories.AppUserRepository;

// @Service
// public class AppUserService implements UserDetailsService{
//     @Autowired
//     private AppUserRepository appUserRepository;

//     @Autowired
//     private BCryptPasswordEncoder bCryptePasswordEncoder;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         return appUserRepository.findByEmail(username)
//             .orElseThrow(() ->
//             new UsernameNotFoundException(
//                 String.format("user with username '%s' not found", username)));
//     }

//     public AppUser registerAppUser(AppUser user){
//         boolean userExists = appUserRepository.findByEmail(user.getUsername()).isPresent();
//             if(userExists){
//             throw new RuntimeException(
//                 String.format("username '%s' already exist", user.getUsername())
//             );
//         }
//         String encodePassword = bCryptePasswordEncoder.encode(user.getPassword());
//         user.setPassword(encodePassword);
//         return appUserRepository.save(user);
//     }
    
// }
