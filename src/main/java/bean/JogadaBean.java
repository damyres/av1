package bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import entidade.Jogada;
import jogadaDao.JogadaDao;

@ManagedBean
public class JogadaBean {

	private Jogada jogada = new Jogada();
	private List<Jogada> jogadas;

	public Jogada salvar() {
		JogadaDao.salvar(jogada);
		jogada = new Jogada();
		FacesMessage msg = new FacesMessage("Jogada criada com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return jogada;
	}

	public String atualizarJogada() {
		JogadaDao.editar(jogada);
		return "cadastro.xhtml?faces-redirect=true";
	}

	public String criarNovaJogada() {
		this.jogada = new Jogada();
		return "cadastro.xhtml?faces-redirect=true";
	}

	public String ExcluirJogada(Jogada id) {
		JogadaDao.excluir(jogada);
		return "listagem.xhtml?faces-redirect=true";
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public List<Jogada> getJogadas() {
		if (jogadas == null) {
			jogadas = JogadaDao.listar();
		}
		return jogadas;
	}

	public void setJogadas(List<Jogada> jogadas) {
		this.jogadas = jogadas;
	}

}
