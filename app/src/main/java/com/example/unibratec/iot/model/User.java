package com.example.unibratec.iot.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by mvpires on 01/07/17.
 */

public class User implements Serializable{


    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("endereco")
    private String endereco;

    @SerializedName("telefone")
    private String telefone;

    @SerializedName("volume")
    private float volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public User(String nome, String cpf, String endereco, String telefone, float volume)
    {
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setTelefone(telefone);
        setVolume(volume);
    }

    public User()
    {

    }


}

