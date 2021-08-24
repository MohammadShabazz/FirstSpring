package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Upload;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long>{

	Optional<Upload> findById(String fileId);

	

	

}
