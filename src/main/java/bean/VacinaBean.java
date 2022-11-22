package bean;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.PrimeFaces;

import dao.VacinaDAO;
import entidade.Vacina;

@ManagedBean
public class VacinaBean {
	private Vacina vacina = new Vacina();
	private List<Vacina> lista;
	
	public String save() {
		try {
			vacina.setDataCadastro(new Date());
			VacinaDAO.insert(vacina);
			addInfoMessage("Sucesso", "Vacinas adicionadas com sucesso.");
			vacina = new Vacina();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao adicionar as vacinas.");
		}
		return null;
	}
	
	public String deletar() {
		try {
			VacinaDAO.remove(vacina);
			addInfoMessage("Deletada", "Vacinas deletadas com sucesso."); 
			lista = VacinaDAO.lista();
			PrimeFaces.current().ajax().update("dataTable");
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao deletar vacinas.");
		}
		return null;	
	}
	
	public String mostrarMaior() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' - 'HH:mm:ss");
			Vacina v = VacinaDAO.buscarMaior();
			String dataCadastro = sdf.format(v.getDataCadastro());
			addInfoMessage("Sucesso","ID: "+v.getId()+ " - Vacina 1: "+v.getVacina1()+" - Vacina 2: "+v.getVacina2()+" - Data Cadastro: "+dataCadastro);
		} catch (Exception e) {
			addErrorMessage("Erro", "Problemas em exibir as informações.");
		}
		return null;
	}
	
	
	public String mostrarVacinas() {
		try {
			addInfoMessage("Vacinas", "Vacina 1: "+vacina.getVacina1()+" - Vacina 2: "+vacina.getVacina2());
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao mostrar as vacinas no painel.");
		}
		return null;
	}
	
	
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public List<Vacina> getLista() {
		if(lista == null) {
			lista = VacinaDAO.lista();
		}
		return lista;
	}
	public void setLista(List<Vacina> lista) {
		this.lista = lista;
	}
}
