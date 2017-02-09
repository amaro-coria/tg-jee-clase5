package net.tecgurus.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import net.tecgurus.business.CatalogoBusiness;
import net.tecgurus.common.dto.CataDTO;

@ManagedBean(name = "catalogoCtrl")
public class CatalogoController {

	private List<CataDTO> listElements;
	@EJB
	private CatalogoBusiness business;
	
	private String descCorta;
	private String descComp;
	private Date fchCrea;
	private Date fchModi;
	private Integer idEstatus;
	
	@PostConstruct
	private void init(){
		listElements = business.findAllDTO_1();
	}
	
	
	public String save(){
		//Llenar el DTO y enviarlo al metodo de guardado en el negocio
		CataDTO dto = new CataDTO();
		dto.setDscComCat(descComp);
		dto.setDscCorCat(descCorta);
		dto.setFchCre(fchCrea);
		business.createNewRecord(dto);
		//Enviar notificacion
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guardado exitoso"));
		listElements = business.findAllDTO_1();
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//GETTERS & SETTERS

	public List<CataDTO> getListElements() {
		return listElements;
	}

	public void setListElements(List<CataDTO> listElements) {
		this.listElements = listElements;
	}

	public String getDescCorta() {
		return descCorta;
	}

	public void setDescCorta(String descCorta) {
		this.descCorta = descCorta;
	}

	public String getDescComp() {
		return descComp;
	}

	public void setDescComp(String descComp) {
		this.descComp = descComp;
	}

	public Date getFchCrea() {
		return fchCrea;
	}

	public void setFchCrea(Date fchCrea) {
		this.fchCrea = fchCrea;
	}

	public Date getFchModi() {
		return fchModi;
	}

	public void setFchModi(Date fchModi) {
		this.fchModi = fchModi;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	
	
	
	
}
