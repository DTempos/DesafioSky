package stepsDefinition;

import Functions.FunctionsValidarProgramacao;
import core.BaseTest;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class StepsValidarProgramacao extends BaseTest {

	static FunctionsValidarProgramacao functionsValidarProgramacao = new FunctionsValidarProgramacao();

	@Dado("^que acesse a tela inicial da Sky$")
	public void que_acesse_a_tela_inicial_da_sky() throws Throwable {
		functionsValidarProgramacao.abrirTelaInicialSky();
		functionsValidarProgramacao.verificarModalDeSaudacaoTelaInicial();
	}

	@Quando("^acessar a Programação$")
	public void acessar_a_programacao() throws Throwable {
		functionsValidarProgramacao.acessarProgramacao();
	}

	@Quando("^verificar o programa atual do primeiro canal com a programação disponível$")
	public void verificar_o_programa_atual_do_primeiro_canal_com_a_programacao_disponivel() throws Throwable {
		functionsValidarProgramacao.selecionarProgramacaoPassandoAgora();
		functionsValidarProgramacao.exibirProgramaNaGrade();
	}

	@Então("^validar que o programa atual é o mesmo exibido no modal do canal selecionado$")
	public void validar_que_o_programa_atual_e_o_mesmo_exibido_no_modal_do_canal_selecionado() throws Throwable {
		functionsValidarProgramacao.validarProgramasCorretosTelaEModal();
	}

}
