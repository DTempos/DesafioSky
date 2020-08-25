package pages;

import core.BasePage;
import core.BaseTest;

public class PageTelaInicialSky extends BasePage {

	/**
	 * Abrir a página da Sky
	 * 
	 * @throws Exception
	 */
	public void abrirPagina(String url) throws Exception {
		dsl.abrirUrl(url);
	}
	
	/**
	 * Fechar modal de saudação quando acessa a tela inicial da Sky
	 * @throws Exception
	 */
	public void fecharModalDeSaudacaoTelaInicial() throws Exception {
//		dsl.visibilidadeElementoPorXpath("//*[@class = 'modal-dialog modal-lg']/div/div[1]/button/span", 180);//outra forma de encontrar o elemento
		
		dsl.visibilidadeElementoPorXpath("(//*[@class = 'sky_icon sky_icon-close icon_xs'])[1]", 180);
		BaseTest.takeScreenshot("Fechando modal da tela inicial");
		dsl.clicarPorXpath("//*[@class = 'modal-dialog modal-lg']/div/div[1]/button/span");
	}
	
	/**
	 * Clicar no link 'Programação' no menu superior
	 * @throws Exception
	 */
	public void clicarLinkProgramacao() throws Exception {
		dsl.visibilidadeElementoPorXpath("//*[@href = '/programacao']/strong", 30);
		BaseTest.takeScreenshot("Clicando link Programação");
		dsl.clicarPorXpath("//*[@href = '/programacao']/strong");
	}

}
