package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ResourceBundle;

@Named
@RequestScoped
//@SessionScoped
public class CreditBB {
	private String kwota;
	private String raty;
	private String procent;
	private Double result;

	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;

	@PostConstruct
	public void postConstruct() {
		// loading resource (notice the full "file" name)
		FacesContext context = FacesContext.getCurrentInstance();
		txtCalc = ResourceBundle.getBundle("resources.textCalc", context.getViewRoot().getLocale());
		txtCalcErr = ResourceBundle.getBundle("resources.textCalcErr", context.getViewRoot().getLocale());
	}
	
	@Inject
	FacesContext ctx;
	
	

	public String getX() {
		return kwota;
	}

	public void setX(String kwota) {
		this.kwota = kwota;
	}

	public String getY() {
		return raty;
	}

	public void setY(String raty) {
		this.raty = raty;
	}

	public String getZ() {
		return procent;
	}

	public void setZ(String procent) {
		this.procent = procent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double kwota =Double.parseDouble(this.kwota);
			double raty = Double.parseDouble(this.raty);
			double procent = Double.parseDouble(this.procent);
			double wynik = ((kwota + (kwota*(procent/100)))/raty);
		    BigDecimal bd = new BigDecimal(wynik).setScale(2, RoundingMode.HALF_UP);
		    double newInput = bd.doubleValue();
			result = newInput;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	// Put result in messages on AJAX call
	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesięczna rata wynosi: " + result + "zł" , null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
