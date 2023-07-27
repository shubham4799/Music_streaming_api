package com.geekster.MusicAPI.repository;

import com.geekster.MusicAPI.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
