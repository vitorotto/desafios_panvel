package com.vitorotto.dtos;

public class TarefaDTO {
    private final int id;
    private final String titulo;
    private final String descricao;
    private final String status;

    public TarefaDTO(String descricao, int id, String status, String titulo) {
        this.descricao = descricao;
        this.id = id;
        this.status = status;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }


}
