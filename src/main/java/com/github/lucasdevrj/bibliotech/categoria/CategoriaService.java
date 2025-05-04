package com.github.lucasdevrj.bibliotech.categoria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriaDTO> listarTodasAsCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoriaMapper::map).collect(Collectors.toList());
    }

    public CategoriaDTO exibirCategoriaPorId(Long id) {
        Optional<CategoriaModel> categoriaPorId = categoriaRepository.findById(id);
        return categoriaPorId.map(categoriaMapper::map).orElse(null);
    }

    public CategoriaDTO adicionarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoria = categoriaMapper.map(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.map(categoria);
    }

    public void deletarCategoriaPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    public CategoriaDTO atualizarCategoriaPorId(Long id, CategoriaDTO categoriaDTO) {
        Optional<CategoriaModel> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            CategoriaModel categoriaAtualizada =  categoriaMapper.map(categoriaDTO);
            categoriaAtualizada.setId(id);
            CategoriaModel categoriaSalva = categoriaRepository.save(categoriaAtualizada);
            return categoriaMapper.map(categoriaSalva);
        }
        return null;
    }
}
