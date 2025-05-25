package com.example.coinmappingapp.teste;

import com.example.coinmappingapp.dao.DespesaDao;
import com.example.coinmappingapp.dao.TipoDespesaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.factory.DaoFactory;
import com.example.coinmappingapp.model.Despesa;
import com.example.coinmappingapp.model.TipoDespesa;
import com.example.coinmappingapp.model.User;

import java.time.LocalDate;
import java.util.List;

public class DespesaDaoTeste {
    public static void main(String[] args) {
        DespesaDao dao = DaoFactory.getDespesaDAO();
        TipoDespesaDao dao2 = DaoFactory.getTipoDespesaDAO();

        TipoDespesa tipoDespesa = new TipoDespesa(1L);
        User user = new User(3L);

        Despesa despesa = new Despesa("Despesa teste",80.80,"vai dar certo", LocalDate.now(),tipoDespesa,user);

        try {
            dao.cadastrar(despesa);
            System.out.println("despesa cadastrado");
        } catch (DBExeption e) {
            e.printStackTrace();
        }

        List<TipoDespesa> listaTipo = dao2.listar();
        listaTipo.forEach(System.out::println);

        List<Despesa> despesas = dao.listar();
        despesas.forEach(System.out::println);

        try {
            despesa.setId(23L);
            despesa.setNome("Despesa atualizada 2");
            despesa.setValor(100.80);
            despesa.setDescricao("Descrição atualizada 2");
            despesa.setTipoDespesa(new TipoDespesa(25L));
            dao.atualizar(despesa);
            System.out.println("deu bom");

        }catch (DBExeption e) {
            e.printStackTrace();
        }

        try {
            dao.remover(23L);
            System.out.println("removido do tipo removido");
        } catch (DBExeption e) {
            e.printStackTrace();
        }

    }
}
