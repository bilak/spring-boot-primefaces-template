package com.github.springprimefaces.controller;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by lvasek on 17/04/15.
 */
@Component("fileUploadBean")
@Scope("request")
public class FileUploadBean implements Serializable {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public String handleFileUpload(FileUploadEvent fileUploadEvent) {
		this.file = fileUploadEvent.getFile();
		if (file != null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File uploaded successfully"));
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning file was not uploaded", "Size of file is null. Is this ok? "));

		return null;
	}
}
