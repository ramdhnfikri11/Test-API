// package com.example.demo.entities;

// import java.util.Collection;
// import java.util.Collections;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// @Entity
// @Table(name="tb_m_user")
// public class AppUser implements UserDetails{
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer user_id;
//     @Column(unique=true)
//     private String username;
//     private String password;
//     @Enumerated(EnumType.STRING)
//     private AppUserRole appUserRole;

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
//         return Collections.singletonList(authority);
//     }
//     @Override
//     public String getPassword() {
//         return password;
//     }
//     @Override
//     public String getUsername() {
//         return username;
//     }
//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }
//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }


//     public Integer getUser_id() {
//         return user_id;
//     }
//     public void setUser_id(Integer user_id) {
//         this.user_id = user_id;
//     }
//     public void setUsername(String username) {
//         this.username = username;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
//     public AppUserRole getAppUserRole() {
//         return appUserRole;
//     }
//     public void setAppUserRole(AppUserRole appUserRole) {
//         this.appUserRole = appUserRole;
//     }
// }
