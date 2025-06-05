package com.docucollab.documentservice.repository;

import com.docucollab.documentservice.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByUploadedBy(String uploadedBy);
}
