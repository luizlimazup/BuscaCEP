package com.lcardoso.buscacep.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CEP implements Parcelable {

    @SerializedName("cep")
    public String cep;
    @SerializedName("logradouro")
    public String logradouro;
    @SerializedName("complemento")
    public String complemento;
    @SerializedName("bairro")
    public String bairro;
    @SerializedName("localidade")
    public String localidade;
    @SerializedName("uf")
    public String uf;
    @SerializedName("unidade")
    public String unidade;
    @SerializedName("ibge")
    public String ibge;
    @SerializedName("gia")
    public String gia;

    public CEP() {
    }

    public CEP(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String unidade, String ibge, String gia) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.unidade = unidade;
        this.ibge = ibge;
        this.gia = gia;
    }

    protected CEP(Parcel in) {
        cep = in.readString();
        logradouro = in.readString();
        complemento = in.readString();
        bairro = in.readString();
        localidade = in.readString();
        uf = in.readString();
        unidade = in.readString();
        ibge = in.readString();
        gia = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cep);
        dest.writeString(logradouro);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(localidade);
        dest.writeString(uf);
        dest.writeString(unidade);
        dest.writeString(ibge);
        dest.writeString(gia);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CEP> CREATOR = new Creator<CEP>() {
        @Override
        public CEP createFromParcel(Parcel in) {
            return new CEP(in);
        }

        @Override
        public CEP[] newArray(int size) {
            return new CEP[size];
        }
    };

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
