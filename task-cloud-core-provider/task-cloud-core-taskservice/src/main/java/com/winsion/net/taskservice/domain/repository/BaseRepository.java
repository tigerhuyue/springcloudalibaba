package com.winsion.net.taskservice.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public  interface BaseRepository<T> extends JpaRepository<T, Integer> {

}