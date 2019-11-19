//package com.example.demo.service;
//
//import com.example.demo.repo.UserRepos;
//import com.example.demo.repo.WorkerRepos;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserService implements UserDetailsService {
//    private final UserRepos repos;
//
//    public UserService(UserRepos repos) {
//        this.repos = repos;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            return repos.findByUsername(username);
//        } catch (EmptyResultDataAccessException e) {
//            throw new UsernameNotFoundException(username);
//        }
//    }
//}
