package com.qintess.cadestag.dtos;

import com.qintess.cadestag.models.Estagiario;
import com.qintess.cadestag.models.SituacaoAtual;

/**
 * EstagiarioDTO
 */
public class EstagiarioDTO {

    private int id;
	private String pendencias;
	private String cliente;
	private String contratoOk;
	private String nome;
	private int situacaoAtual;
	private String dtAdmissao;
	private String dtTerminoCurso;
	private String dtTerminoContrato;
	private String recesso;
	private String dtDesligEfetivRenov;
	private String potencial;
	private String particularidade;
    private String obs;

    public Estagiario transformModel() {

        Estagiario estagiario = new Estagiario();

        estagiario.setId(id);
        estagiario.setPendencias(pendencias);
        estagiario.setCliente(cliente);
        estagiario.setContratoOk(contratoOk);
        estagiario.setNome(nome);
        estagiario.setDtAdmissao(dtAdmissao);
        estagiario.setDtTerminoCurso(dtTerminoCurso);
        estagiario.setDtTerminoContrato(dtTerminoContrato);
        estagiario.setRecesso(recesso);
        estagiario.setDtDesligEfetivRenov(dtDesligEfetivRenov);
        estagiario.setPotencial(potencial);
        estagiario.setParticularidade(particularidade);
        estagiario.setObs(obs);

        SituacaoAtual situ = new SituacaoAtual();

        situ.setId(situacaoAtual);

        estagiario.setSituacaoAtual(situ);

        return estagiario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPendencias() {
        return pendencias;
    }

    public void setPendencias(String pendencias) {
        this.pendencias = pendencias;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getContratoOk() {
        return contratoOk;
    }

    public void setContratoOk(String contratoOk) {
        this.contratoOk = contratoOk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSituacaoAtual() {
        return situacaoAtual;
    }

    public void setSituacaoAtual(int situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }

    public String getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(String dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public String getDtTerminoCurso() {
        return dtTerminoCurso;
    }

    public void setDtTerminoCurso(String dtTerminoCurso) {
        this.dtTerminoCurso = dtTerminoCurso;
    }

    public String getDtTerminoContrato() {
        return dtTerminoContrato;
    }

    public void setDtTerminoContrato(String dtTerminoContrato) {
        this.dtTerminoContrato = dtTerminoContrato;
    }

    public String getRecesso() {
        return recesso;
    }

    public void setRecesso(String recesso) {
        this.recesso = recesso;
    }

    public String getDtDesligEfetivRenov() {
        return dtDesligEfetivRenov;
    }

    public void setDtDesligEfetivRenov(String dtDesligEfetivRenov) {
        this.dtDesligEfetivRenov = dtDesligEfetivRenov;
    }

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }

    public String getParticularidade() {
        return particularidade;
    }

    public void setParticularidade(String particularidade) {
        this.particularidade = particularidade;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}