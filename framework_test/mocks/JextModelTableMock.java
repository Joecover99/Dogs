package mocks;

import java.util.List;

import components.JExtModelTable;

@SuppressWarnings("serial")
public class JextModelTableMock extends JExtModelTable<ModelMock> {
	
	public final static String[] ANY_COLUMN_NAMES = { "id", "Random value" };

	public JextModelTableMock(List<ModelMock> instances) {
		super(ANY_COLUMN_NAMES, instances);
	}

	@Override
	protected Object[] generateRowObject(ModelMock object) {
		return generateRowObjectPublic(object);
	}
	
	public Object[] generateRowObjectPublic(ModelMock object) {
		return new Object[] { object.id, object.uniqueId };
	}

}
