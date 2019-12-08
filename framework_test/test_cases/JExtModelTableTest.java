package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mocks.JextModelTableMock;
import mocks.ModelMock;

class JExtModelTableTest {
	
	@SuppressWarnings("serial")
	private final static List<ModelMock> ANY_MODEL_LIST = new ArrayList<ModelMock>() {
		{
			add(new ModelMock());
			add(new ModelMock());
			add(new ModelMock());
			add(new ModelMock());
		}
	};
	
	private JextModelTableMock table = null;
	
	@BeforeEach
	private void init() {
		this.table = new JextModelTableMock(ANY_MODEL_LIST);
	}
	
	@Test
	void created_table_has_same_row_count_as_entity_list() {
		assertEquals(ANY_MODEL_LIST.size(), table.getRowCount());
	}
	
	@Test
	void created_table_has_same_column_count_as_field_count() {
		assertEquals(JextModelTableMock.ANY_COLUMN_NAMES.length, table.getColumnCount());
	}
	
	@Test
	void cell_value_match_entities_transformed_with_generateRowObject() {
		for (int i = 0; i < table.getRowCount(); i++) {
			ModelMock entity = ANY_MODEL_LIST.get(i);
			Object[] row = table.generateRowObjectPublic(entity);
			
			for (int j = 0; j < table.getColumnCount(); j++) {
				assertEquals(row[j], table.getValueAt(i, j));
			}
		}
	}
	
	@Test
	void no_cell_is_editable() {
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				assertFalse(table.isCellEditable(i, j));
			}
		}
	}
	
	@Test
	void table_have_sorter() {
		assertNotEquals(null, table.getRowSorter());
	}
	
	@Test
	void sorter_is_sorted_on_first_column_by_default() {
		assertEquals(0, table.getRowSorter().getSortKeys().get(0).getColumn());
	}
	
	@Test
	void table_have_same_column_title_as_provided() {
		for (int i = 0; i < table.getColumnCount(); i++) {
			assertEquals(JextModelTableMock.ANY_COLUMN_NAMES[i], table.getColumnName(i));
		}
	}

}
