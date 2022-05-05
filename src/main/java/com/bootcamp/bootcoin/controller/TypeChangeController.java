package com.bootcamp.bootcoin.controller;

import com.bootcamp.bootcoin.entity.TypeChange;
import com.bootcamp.bootcoin.service.TypeChangeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("typeChange")
@Tag(name = "Type chamge", description = "Manage mainteance of typeChange")
@CrossOrigin(value = {"*"})
@RequiredArgsConstructor
public class TypeChangeController {

    public final TypeChangeService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<TypeChange>>> getAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getAll())
        );
    }

    @GetMapping("/{idTypeChange}")
    public Mono<ResponseEntity<Mono<TypeChange>>> getByIdTypeChange(@PathVariable String idTypeChange) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getById(idTypeChange))
        );
    }

    @PostMapping
    public Mono<ResponseEntity<TypeChange>> create(@RequestBody TypeChange typeChange) {

        return service.save(typeChange).map(p -> ResponseEntity
                .created(URI.create("/TypeChange/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p)
        );
    }

    @PutMapping
    public Mono<ResponseEntity<TypeChange>> update(@RequestBody TypeChange typeChange) {
        return service.update(typeChange)
                .map(p -> ResponseEntity.created(URI.create("/TypeChange/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<TypeChange>> delete(@RequestBody String id) {
        return service.delete(id)
                .map(p -> ResponseEntity.created(URI.create("/TypeChange/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
