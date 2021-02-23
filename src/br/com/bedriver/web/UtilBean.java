package br.com.bedriver.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "utilBean")
@ViewScoped
public class UtilBean {
	boolean checked;

	

	public boolean isChecked() {
		return checked;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		
		this.checked = checked;
	}
 
	public void change() {
		
		if(isChecked()) {
			this.checked=false;
		}else {
			this.checked = true;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checked ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilBean other = (UtilBean) obj;
		if (checked != other.checked)
			return false;
		return true;
	}



}
