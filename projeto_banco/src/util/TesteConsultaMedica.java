package util;

import model.ConsultaMedica;
import servico.ServicoConsultaMedica;
import servico.ServicoMedico;
import servico.ServicoPaciente;

import java.sql.SQLException;

public class TesteConsultaMedica {
    public static ServicoConsultaMedica servicoConsultaMedica = new ServicoConsultaMedica();
    public static ServicoPaciente servicoPaciente = new ServicoPaciente();
    public static ServicoMedico servicoMedico = new ServicoMedico();
    public static void main(String[] args) throws SQLException {
        long millis = System.currentTimeMillis();
        ConsultaMedica consultaMedica = new ConsultaMedica(new java.sql.Date(millis),
                "2441",
                servicoPaciente.buscarPorId(1),
                servicoMedico.buscarPorId(1));

        servicoConsultaMedica.salvar(consultaMedica);

        System.out.println(servicoConsultaMedica.buscarTodos());

        ConsultaMedica consultaMedicaOutro = servicoConsultaMedica.buscarPorId(1);

        consultaMedicaOutro.setNm_atendimento("2443");
        servicoConsultaMedica.update(consultaMedicaOutro);
        System.out.println(consultaMedicaOutro);

        // remover
//        servicoConsultaMedica.remover(3);

    }
}
