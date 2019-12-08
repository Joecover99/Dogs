package mocks;

import components.Form;

@SuppressWarnings("serial")
public class FormMock extends Form {
	public Boolean wasSubmited = false;
	public Boolean isValid = true;
	
	public FormMock(Object[][] labelFieldList) {
		super(labelFieldList);
	}

	@Override
	protected void submit() {
		this.wasSubmited = true;
	}

	@Override
	protected Boolean checkValidity() {
		return isValid;
	}
	
}
