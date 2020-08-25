package pages;

import java.util.ArrayList;
import java.util.List;

import core.BasePage;

public class PageProgramacao extends BasePage {

	public void clicarBotaoPassandoAgora() throws Exception {
		dsl.visibilidadeElementoPorXpath("//*[text() = 'Passando Agora']", 90);
		dsl.clicarPorXpath("//*[text() = 'Passando Agora']");
		Thread.sleep(3000);
	}

	public void pressionarTeclaPageDown() throws Exception {
		dsl.pressionaTeclaPAGE_DOWN();
		Thread.sleep(3000);
	}

	public void pressionarTeclaDown() throws Exception {
		dsl.pressionaTeclaDOWN();
		Thread.sleep(3000);
	}

	public void colocarCursorSobreProgramaExibido() throws Exception {
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2", 15);
		Thread.sleep(2000);
		dsl.mouseOver("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2");
	}

	public String getNomeExibidoProgramaGrade() throws Exception {
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2", 15);
		String nomePrograma = dsl.obterTextoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2");
		System.out.println(nomePrograma);

		return nomePrograma;
	}

	public List<String> getHorarioEscondidoGrade() throws Exception {
		List<String> horario = new ArrayList<String>();

		dsl.esperarElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]/div[2]/div[1]/p", 30);
		String duracao = dsl.obterAtributoElementoPorXpath(
				"(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]/div[2]/div[1]/p", "#text");
		System.out.println(duracao);

		String[] separaHorario = duracao.split(" - ");
		String horaInicio = separaHorario[0];
		String horaFim = separaHorario[1];

		horario.add(horaInicio);
		horario.add(horaFim);

		return horario;
	}

	public String getNomeDoProgramaModal() throws Exception {
		dsl.visibilidadeElementoPorXpath("//*[@class = 'sky-modal-program-description']/div[1]/h2", 90);
		String programa_modal = dsl.obterTextoPorXpath("//*[@class = 'sky-modal-program-description']/div[1]/h2");
		System.out.println(programa_modal);

		return programa_modal;
	}

	public List<String> getHorarioProgramaModal() throws Exception {
		List<String> horario = new ArrayList<String>();

		dsl.visibilidadeElementoPorXpath("//*[@class = 'sky-modal-program-date-time']/span", 30);
		String duracao = dsl.obterTextoPorXpath("//*[@class = 'sky-modal-program-date-time']/span");
		System.out.println(duracao);

		String[] separaHorario = duracao.split(" - ");
		String horaInicio = separaHorario[0];
		String horaFim = separaHorario[1];

		horario.add(horaInicio);
		horario.add(horaFim);

		return horario;
	}

	public String getNomeEscondidoProgramaGrade() throws Exception {
		dsl.esperarElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]/h2", 15);
		String nomePrograma = dsl.obterTextoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]/h2");
		System.out.println(nomePrograma);

		return nomePrograma;
	}

	public void colocarCursorSobreProgramaEscondidoParaExibir() throws Exception {
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]", 15);
		Thread.sleep(2000);
		dsl.mouseOver("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]/h2");
	}

	public List<String> getHorarioExibidoGrade() throws Exception {
		List<String> horario = new ArrayList<String>();

		dsl.esperarElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/div[2]/div[1]/p", 30);
		String duracao = dsl
				.obterTextoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/div[2]/div[1]/p");
		System.out.println(duracao);

		String[] separaHorario = duracao.split(" - ");
		String horaInicio = separaHorario[0];
		String horaFim = separaHorario[1];

		horario.add(horaInicio);
		horario.add(horaFim);

		return horario;
	}

	public void clicarProgramaExibidoParaModal() throws Exception {
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2", 15);
		Thread.sleep(2000);
		dsl.clicarPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[1]/h2");
	}

	public void clicarProgramaEscondidoParaModal() throws Exception {
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]", 15);
		Thread.sleep(2000);
		dsl.clicarPorXpath("(//*[@class = 'schedule-inner schedule-live'])[2]/div[2]");
	}

	public void aguardarCarregamentoGrade() throws Exception {
		dsl.visibilidadeElementoPorXpath("//*[@alt = 'DISCOV.KIDS']", 60);
	}

}
