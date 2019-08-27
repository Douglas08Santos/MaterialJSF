package br.ufrn.imd.material.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufrn.imd.material.dominio.Material;
import br.ufrn.imd.material.repositorios.MaterialRepositorio;

@Named
@SessionScoped
public class MaterialMBean implements Serializable {
	private Material material;
	private DataModel<Material> materiaisModel;
	
	@Inject
	private UsuarioMBean usuarioMBean;
	
	public MaterialMBean() {
		material = new Material();
	}
	
	private String novoMaterial() {
		material = new Material();
		return "/pages/material/form.jsf";
	}
	
	private String listarMaterial() {
		materiaisModel = new ListDataModel<Material>(MaterialRepositorio.listarMateriais());
		return "/pages/material/form.jsf";
	}
	
	public String removerMaterial() {
		Material materialRemovido = materiaisModel.getRowData();
		MaterialRepositorio.remover(materialRemovido);
		return listarMaterial();
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the materiaisModel
	 */
	public DataModel<Material> getMateriaisModel() {
		return materiaisModel;
	}

	/**
	 * @param materiaisModel the materiaisModel to set
	 */
	public void setMateriaisModel(DataModel<Material> materiaisModel) {
		this.materiaisModel = materiaisModel;
	}

	/**
	 * @return the usuarioMBean
	 */
	public UsuarioMBean getUsuarioMBean() {
		return usuarioMBean;
	}

	/**
	 * @param usuarioMBean the usuarioMBean to set
	 */
	public void setUsuarioMBean(UsuarioMBean usuarioMBean) {
		this.usuarioMBean = usuarioMBean;
	}
	
	
}
