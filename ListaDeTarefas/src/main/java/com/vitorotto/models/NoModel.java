package com.vitorotto.models;

public class NoModel<T> {

    private T elemento;
    private NoModel<T> proximo;

    public NoModel(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public NoModel(T elemento, NoModel<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoModel<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoModel<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("No{");
        sb.append("elemento=").append(elemento);
        sb.append(", proximo=").append(proximo);
        sb.append('}');
        return sb.toString();
    }
}
