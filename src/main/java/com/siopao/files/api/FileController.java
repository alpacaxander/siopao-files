package com.siopao.files.api;

import com.siopao.files.model.File;
import com.siopao.files.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    FileRepository fileRepository;

    @Autowired
    FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PostMapping
    private UUID create(@RequestBody String data) {
        File file = new File()
                .data(data);

        file = this.fileRepository.save(file);
        return file.id();
    }

    @GetMapping("/{id}")
    private String get(@PathVariable("id") UUID id) {
        Optional<File> result = this.fileRepository.findById(id);
        return result.get().data();
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") UUID id) {
        this.fileRepository.deleteById(id);
    }

}
