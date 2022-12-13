package util;

import model.Medico;
import servico.ServicoMedico;

import java.sql.SQLException;

public class TesteMedico {
	public static ServicoMedico servicoMedico = new ServicoMedico();
	
	public static void main(String[] args) throws SQLException {
		Medico medico = new Medico("Ciclano de Fulano", "41211134");


		servicoMedico.salvar(medico);

		System.out.println(servicoMedico.buscarTodos());

		Medico medicoOutro = servicoMedico.buscarPorId(1);

		medicoOutro.setCrm("12121233333");
		servicoMedico.update(medicoOutro);

		System.out.println(servicoMedico.buscarPorId(1));
	}
}
