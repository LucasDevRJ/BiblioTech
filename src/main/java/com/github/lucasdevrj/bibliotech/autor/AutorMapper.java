package com.github.lucasdevrj.bibliotech.autor;

import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorModel map(AutorDTO autorDTO) {
        AutorModel autorModel = new AutorModel();
        autorModel.setId(autorDTO.getId());
        autorModel.setNome(autorDTO.getNome());
        autorModel.setNacionalidade(autorDTO.getNacionalidade());
        autorModel.setDataNascimento(autorDTO.getDataNascimento());
        autorModel.setBiografia(autorDTO.getBiografia());
        return autorModel;
    }

    public AutorDTO map(AutorModel autorModel) {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autorModel.getId());
        autorDTO.setNome(autorModel.getNome());
        autorDTO.setNacionalidade(autorModel.getNacionalidade());
        autorDTO.setDataNascimento(autorModel.getDataNascimento());
        autorDTO.setBiografia(autorModel.getBiografia());
        return autorDTO;
    }
}
