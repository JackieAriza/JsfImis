package com.gaes3.imisG.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;

@ManagedBean(name = "fileUploadView")
@RequestScoped
public class FileUploadManegedBean {

	private UploadedFile file;
	private UploadedFiles files;
	private String dropZoneText = "Drop zone p:inputTextarea demo.";

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UploadedFiles getFiles() {
		return files;
	}

	public void setFiles(UploadedFiles files) {
		this.files = files;
	}

	public String getDropZoneText() {
		return dropZoneText;
	}

	public void setDropZoneText(String dropZoneText) {
		this.dropZoneText = dropZoneText;
	}

	public void uploadMultiple() {
		if (files != null) {
			for (UploadedFile f : files.getFiles()) {
				FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}
}