package Functions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import core.BaseTest;
import managers.FileReaderManager;
import pages.PageProgramacao;
import pages.PageTelaInicialSky;

public class FunctionsValidarProgramacao {

	PageTelaInicialSky pageTelaInicialSky = new PageTelaInicialSky();
	PageProgramacao pageProgramacao = new PageProgramacao();

	public void abrirTelaInicialSky() throws Exception {
		String url = null;
		url = FileReaderManager.getInstance().getConfigReader().getURLSky();
		pageTelaInicialSky.abrirPagina(url);
	}

	public void verificarModalDeSaudacaoTelaInicial() throws Exception {
		try {
			Thread.sleep(2000);
			pageTelaInicialSky.fecharModalDeSaudacaoTelaInicial();
		} catch (Exception e) {

		}
	}
	
	public void acessarProgramacao() throws Exception {
		pageTelaInicialSky.clicarLinkProgramacao();
	}
	
	public void selecionarProgramacaoPassandoAgora() throws Exception {
		pageProgramacao.aguardarCarregamentoGrade();
		pageProgramacao.pressionarTeclaPageDown();
		pageProgramacao.pressionarTeclaPageDown();
		pageProgramacao.pressionarTeclaDown();
		pageProgramacao.clicarBotaoPassandoAgora();
		BaseTest.takeScreenshot("Passando agora");
	}
	
	public void exibirProgramaNaGrade() throws Exception {
		try {
			pageProgramacao.colocarCursorSobreProgramaExibido();
			BaseTest.takeScreenshot("Exibindo programa atual na grade de programação do primeiro canal disponível");
		} catch (Exception e) {
			pageProgramacao.colocarCursorSobreProgramaEscondidoParaExibir();
			BaseTest.takeScreenshot("Exibindo programa atual na grade de programação do primeiro canal disponível");
		}
	}
	
	public void validarProgramasCorretosTelaEModal() throws Exception {
		String programa_grade = getProgramaEscondidoOuExibidoGrade();
		List<String> horario_grade = getHorarioEscondidoOuExibidoGrade();
		String inicio_grade = horario_grade.get(0);
		String fim_grade = horario_grade.get(1);
		
		try {
			pageProgramacao.clicarProgramaExibidoParaModal();
		} catch (Exception e) {
			pageProgramacao.clicarProgramaEscondidoParaModal();
		}
		
		String programa_modal = pageProgramacao.getNomeDoProgramaModal();
		List<String> horario_modal = getHorarioEscondidoOuExibidoGrade();
		String inicio_modal = horario_modal.get(0);
		String fim_modal = horario_modal.get(1);
		
		
		assertEquals(programa_grade, programa_modal);
		assertEquals(inicio_grade, inicio_modal);
		assertEquals(fim_grade, fim_modal);
		
		BaseTest.takeScreenshot("Programa exibido no modal é o mesmo exibido na grade de programação atual");
	}
	
	private String getProgramaEscondidoOuExibidoGrade() throws Exception {
		String programa = null;
		try {
			programa = pageProgramacao.getNomeExibidoProgramaGrade();
		} catch (Exception e) {
			programa = pageProgramacao.getNomeEscondidoProgramaGrade();
		}
		
		return programa;
	}
	
	private List<String> getHorarioEscondidoOuExibidoGrade() throws Exception {
		List<String> horario = new ArrayList<String>();
		
		String inicio_grade = null;
		String fim_grade = null;
		try {
			inicio_grade = pageProgramacao.getHorarioExibidoGrade().get(0);
			fim_grade = pageProgramacao.getHorarioExibidoGrade().get(1);
		} catch (Exception e) {
			inicio_grade = pageProgramacao.getHorarioEscondidoGrade().get(0);
			fim_grade = pageProgramacao.getHorarioEscondidoGrade().get(1);
		}
		
		horario.add(inicio_grade);
		horario.add(fim_grade);
		
		return horario;
	}

}
