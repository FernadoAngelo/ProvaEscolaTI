package com.unicesumar.tema_1.controller.Veiculo;

import com.unicesumar.tema_1.model.acessorio.AcessorioRepository;
import com.unicesumar.tema_1.model.veiculo.Veiculo;
import com.unicesumar.tema_1.model.veiculo.VeiculoDTO;
import com.unicesumar.tema_1.model.veiculo.VeiculoRepository;
import com.unicesumar.tema_1.model.acessorio.Acessorio;
import com.unicesumar.tema_1.model.acessorio.AcessorioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@CrossOrigin(maxAge = 3600)
@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private AcessorioRepository acessorioRepositoryrepository;

    @GetMapping("/api/veiculo")
    List<Veiculo> getAllVeiculo() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/api/veiculo")
    Veiculo createVeiculo(@RequestBody VeiculoDTO dto) {
        try {
            Veiculo veiculo = new Veiculo(dto);
            return repository.save(veiculo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/veiculo/{id}")
    ResponseEntity<Veiculo> findVeiculo(@PathVariable Long id) {
        try {
            Optional<Veiculo> body = repository.findById(id);
            return body.map(veiculo -> new ResponseEntity<>(veiculo, HttpStatus.FOUND))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/api/veiculo/{id}")
    ResponseEntity<Veiculo> updateVeiculo(@RequestBody VeiculoDTO dto,@PathVariable Long id) {
        try {
            Optional<Veiculo> body = repository.findById(id);
            if(!body.isPresent()){
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Veiculo save = new Veiculo(dto);
            save.setId(id);

            return new ResponseEntity<>(repository.save(save), HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/api/add/acessorio/veiculo/{id}")
    ResponseEntity<Veiculo> adicionarAcessorioVeiculo(@RequestBody AcessorioDTO dto, @PathVariable Long id) {
        try {
            Optional<Veiculo> body = repository.findById(id);
            if(!body.isPresent()){
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Veiculo veiculoSave = body.get();
            veiculoSave.setId(id);
            List<Acessorio> acessorios = veiculoSave.getAcessorio();
            acessorios.add(new Acessorio(dto));
            veiculoSave.setAcessorio(acessorios);

            return new ResponseEntity<>(repository.save(veiculoSave), HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/api/remove/acessorio/veiculo/{veiculoId}")
    ResponseEntity<Veiculo> removerAcessorioVeiculo(@RequestBody  Long acessorioId, @PathVariable Long veiculoId) {
        try {
            Optional<Veiculo> body = repository.findById(veiculoId);
            if(!body.isPresent()){
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Veiculo veiculoSave = body.get();
            veiculoSave.setId(veiculoId);
            acessorioRepositoryrepository.deleteById(acessorioId);
            return new ResponseEntity<>(repository.save(veiculoSave), HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/api/veiculo/{id}")
    ResponseEntity<Veiculo> deleteVeiculo(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
