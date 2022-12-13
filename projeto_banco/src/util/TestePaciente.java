package util;

import model.Paciente;
import servico.ServicoPaciente;

import java.sql.SQLException;

public class TestePaciente {
    public static ServicoPaciente servicoPaciente = new ServicoPaciente();

    public static void main(String[] args) throws SQLException {
        long millis = System.currentTimeMillis();
        Paciente paciente = new Paciente("Fulano de Bezerra", new java.sql.Date(millis));

        servicoPaciente.salvar(paciente);

        Paciente paciente1 = servicoPaciente.buscarPorId(1);
        paciente1.setNome("João Batata");
        servicoPaciente.update(paciente1);

//        Paciente paciente1 = servicoPaciente.buscarPorId(1);
//        servicoPaciente.remover(paciente1.getId().intValue());

        System.out.println(servicoPaciente.buscarTodos());

    }
}
