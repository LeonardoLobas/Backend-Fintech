package com.example.coinmappingapp.teste;

import com.example.coinmappingapp.dao.ReceitaDao;
import com.example.coinmappingapp.dao.TipoReceitaDao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.factory.DaoFactory;
import com.example.coinmappingapp.model.Receita;
import com.example.coinmappingapp.model.TipoReceita;
import com.example.coinmappingapp.model.User;

import java.time.LocalDate;
import java.util.List;

public class ReceitaDaoTeste {
    public static void main(String[] args) throws DBExeption {
        ReceitaDao dao = DaoFactory.getReceitaDAO();
        TipoReceitaDao dao2 = DaoFactory.getTipoReceitaDAO();

        TipoReceita tipoReceita = new TipoReceita(25L);
        User user = new User(22L);

        Receita receita = new Receita("Receita teste",80.80,"vai dar certo", LocalDate.now(),tipoReceita,user);

        try {
            dao.cadastrar(receita);
            System.out.println("produto cadastrado");
        } catch (DBExeption e) {
            e.printStackTrace();
        }

        List<TipoReceita> listaTipo = dao2.listar();
        listaTipo.forEach(System.out::println);

        List<Receita> receitas = dao.listar();
        receitas.forEach(System.out::println);

        try {
            receita.setId(23L);
            receita.setNome("Receita atualizada 2");
            receita.setValor(100.80);
            receita.setDescricao("Descrição atualizada 2");
            receita.setTipoReceita(new TipoReceita(25L));
            dao.atualizar(receita);
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
