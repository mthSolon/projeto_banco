package util;

import model.Laboratorio;
import servico.ServicoLaboratorio;

public class TesteLaboratorio {
    public static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) {
        Laboratorio laboratorio = new Laboratorio("Laboratório SAC", "487090037103", "201234032111/3321", "31242", "SAC");

        servicoLaboratorio.salvar(laboratorio);
        System.out.println(servicoLaboratorio.buscarTodos());

        Laboratorio laboratorio1 = servicoLaboratorio.buscarPorId(1);

        laboratorio1.setDescricao("Descrição editado");
        System.out.println(laboratorio1);
    }
}
