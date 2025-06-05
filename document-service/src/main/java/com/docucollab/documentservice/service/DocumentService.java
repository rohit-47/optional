package com.docucollab.documentservice.service;

import com.docucollab.documentservice.model.Document;
import com.docucollab.documentservice.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.docucollab.documentservice.model.Document.*;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    public Document save(MultipartFile file, String uploadedBy) throws IOException {
        Document document = builder()
                .filename(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .data(file.getBytes()) // Ensure your Document entity has 'data' field
                .uploadedBy(uploadedBy)
                .uploadDate(LocalDate.now().toString())
                .build();

        return repository.save(document);
    }

    public List<Document> getAllDocuments() {
        return repository.findAll();
    }

    public Optional<Document> getDocumentById(Long id) {
        return repository.findById(id);
    }

    public List<Document> getDocumentsByUploadedBy(String uploadedBy) {
        return repository.findByUploadedBy(uploadedBy);
    }
}
