package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vacina {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "vacina_1")
	private String vacina1;
	@Column(name = "vacina_2")
	private String vacina2;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVacina1() {
		return vacina1;
	}
	public void setVacina1(String vacina1) {
		this.vacina1 = vacina1;
	}
	public String getVacina2() {
		return vacina2;
	}
	public void setVacina2(String vacina2) {
		this.vacina2 = vacina2;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
