package com.purpura.dao;

import com.purpura.model.EnderecoEmpresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Classe DAO para a tabela EnderecoEmpresa
 * @author [Seu nome ou autor do código]*/

/**Classe implementando a interface generica DAO
 * e adicionando a Classe model equivalente: EnderecoEmpresa*/
public class EnderecoEmpresaDAO extends DAO<EnderecoEmpresa> {

    /**Metodo para retornar o nome da tabela
     * @return uma String com o nome da tabela*/
    @Override
    public String getNomeTabela() {
        return "EnderecoEmpresa";
    }

    /**Metodo para instanciar um objeto
     * @param rs -> ResultSet
     * @return objeto EnderecoEmpresa*/
    @Override
    protected EnderecoEmpresa mapResultSet(ResultSet rs) throws SQLException {
        return new EnderecoEmpresa(
                rs.getInt("nCdEnderecoEmpresa"),
                rs.getString("cBairro"),
                rs.getString("cLogradouro"),
                rs.getString("cEstado"),
                rs.getString("cCidade"),
                rs.getString("cComplemento"),
                rs.getString("cCep"),
                rs.getInt("iNrEnderecoEmpresa"),
                rs.getString("cCnpj")
        );
    }

    /**Adicionando Metodo para pegar o nome das colunas
     * @return String com os nomes dos atributos da model*/
    @Override
    protected String getNomesColunas() {
        return "cBairro, cLogradouro, cEstado, cCidade, cComplemento, cCep, iNrEnderecoEmpresa, cCnpj";
    }

    /**Adicionando metodo para Inserir conteudo no banco de dados
     * @param stmt -> String com o comando sql
     * @param entidade -> nome da tabela*/
    @Override
    protected void prepareStatementForSave(PreparedStatement stmt, EnderecoEmpresa entidade) throws SQLException {
        stmt.setString(1, entidade.getCBairro());
        stmt.setString(2, entidade.getCLogradouro());
        stmt.setString(3, entidade.getCEstado());
        stmt.setString(4, entidade.getCCidade());
        stmt.setString(5, entidade.getCComplemento());
        stmt.setString(6, entidade.getCCep());
        stmt.setInt(7, entidade.getINrEnderecoEmpresa());
        stmt.setString(8, entidade.getCCnpj());
    }

    /**Adicionando metodo para Atualizar conteudo no banco de dados
     * @param stmt -> String com o comando sql
     * @param entidade -> nome da tabela*/
    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, EnderecoEmpresa entidade) throws SQLException {
        prepareStatementForSave(stmt, entidade);
        stmt.setInt(9, entidade.getNCdEnderecoEmpresa());
    }

    /**Adcionando Metodo para buscar a primary key da coluna
     * @return chave primaria da coluna*/
    @Override
    protected String getColunaId() {
        return "nCdEnderecoEmpresa";
    }
}
