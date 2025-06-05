package com.docucollab.documentservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String contentType;
    private Long size;
    private String uploadedBy;
    private String uploadDate;
    @Lob
    @Column(length = 100000) // Optional: specify max size
    private byte[] data;
}
