package com.example.k8s;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @PostMapping("/data")
    public ResponseEntity<Void> addData(@RequestBody Map<String, String> data) {
        String name = data.get("name");
        String description = data.get("description");

        repository.save(new Brand(name, description));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<Object> getData(@PathVariable String id) {
        try {
            Brand brand = repository.findById(Integer.parseInt(id)).orElseThrow(IllegalArgumentException::new);
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("ID가 잘못되었습니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
