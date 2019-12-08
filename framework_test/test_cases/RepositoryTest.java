package test_cases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import exceptions.ModelNotPersistedException;
import interfaces.IModel;
import interfaces.IRepository;
import mocks.ModelMock;
import utils.Repository;

class RepositoryTest {
	private IRepository<IModel> repository = null;
	
	@BeforeEach
	public void init() {
		repository = new Repository<IModel>();
	}
	
	@Nested
	class InsertTest {
		@Test
		void store_copy_of_given_instance() throws ModelNotPersistedException {
			// Arrange
			ModelMock baseInstance = new ModelMock();
			
			// Act
			repository.insert(baseInstance);
			
			// Assert
			final ModelMock storedInstance = (ModelMock) repository.select(baseInstance.id);
			assertCopy(storedInstance, baseInstance);
		}
		
		@Test
		void GIVE_STARTING_ID_with_incrementing_id_to_instances() {
			final int REPEAT_COUNT = 5;
			
			for (int i = 0; i < REPEAT_COUNT; i++) {
				// Arrange
				ModelMock instance = new ModelMock();
				
				// Act
				repository.insert(instance);
				
				// Assert
				final int EXPECTED_ID = IRepository.STARTING_ID + i;
				assertEquals(EXPECTED_ID, instance.id);
			}
		}
	}
	
	@Nested
	class DeleteTest {
		@Test
		void THROWS_ModelNotPersistedException_If_item_have_id_NULL_ID() throws ModelNotPersistedException {
			// Arrange
			ModelMock baseInstance = new ModelMock();
			baseInstance.id = IRepository.NULL_ID;
					
			// Act
			assertThrows(ModelNotPersistedException.class, () -> {
				repository.delete(baseInstance);
			});
		}
		
		@Test
		void THROWS_ModelNotPersistedException_If_item_have_id_that_is_not_repository() throws ModelNotPersistedException {
			// Arrange
			ModelMock baseInstance = new ModelMock();
			baseInstance.id = 1;
					
			// Act
			assertThrows(ModelNotPersistedException.class, () -> {
				repository.delete(baseInstance);
			});
		}
		
		@Test
		void set_instance_id_back_to_NULL_ID() throws ModelNotPersistedException {
			// Arrange
			ModelMock baseInstance = new ModelMock();
			repository.insert(baseInstance);
			
			// Act
			repository.delete(baseInstance);
			
			// Assert
			assertEquals(IRepository.NULL_ID, baseInstance.id);
		}
		
		@Test
		void remove_instance_copy_from_data_base() throws ModelNotPersistedException {
			// Arrange
			ModelMock baseInstance = new ModelMock();
			repository.insert(baseInstance);
			final int ID = baseInstance.id;
			
			// Act
			repository.delete(baseInstance);
			
			// Assert
			assertThrows(ModelNotPersistedException.class, () -> {
				repository.select(ID);
			});
			assertEquals(IRepository.NULL_ID, baseInstance.id);
		}
	}
	
	@Nested
	class SelectTest {
		@Test
		void WHEN_no_instance_with_given_id_in_db_THROWS_ModelNotPersistedException() throws ModelNotPersistedException {
			// Arrange
			final int ANY_INVALID_ID = IRepository.STARTING_ID;
			
			// Assert
			assertThrows(ModelNotPersistedException.class, () -> {
				repository.select(ANY_INVALID_ID);
			});
		}
		
		@Test
		void return_copy_of_inserted_instance() throws ModelNotPersistedException {
			// Arrange
			ModelMock instance = new ModelMock();
			repository.insert(instance);
			
			// Act
			ModelMock returnedInstance = (ModelMock) repository.select(instance.id);
			
			// Assert
			assertCopy(returnedInstance, instance);
		}
		
		@Test
		void always_return_a_copy_of_stored_instance() throws ModelNotPersistedException {
			// Arrange
			ModelMock instance = new ModelMock();
			repository.insert(instance);
			
			// Act
			ModelMock returnedInstanceA = (ModelMock) repository.select(instance.id);
			ModelMock returnedInstanceB = (ModelMock) repository.select(instance.id);
			
			// Assert
			assertCopy(returnedInstanceA, returnedInstanceB);
		}
	}
	
	@Nested
	class UpdateTest {
		@Test
		void WHEN_instance_is_not_persisted_THROWS_ModelNotPersistedException() {
			// Arrange
			ModelMock instance = new ModelMock();
			
			// Assert
			assertThrows(ModelNotPersistedException.class, () -> {
				repository.update(instance);
			});
		}
		
		@Test
		void replace_stored_instance_with_a_new_copy_of_given_instance() throws ModelNotPersistedException {
			// Arrange
			ModelMock instance = new ModelMock();
			repository.insert(instance);
			
			instance.uniqueId = new Random().nextInt();
			
			// Act
			repository.update(instance);
			
			// Assert
			ModelMock storedInstanceCopy = (ModelMock) repository.select(instance.getId());
			assertCopy(instance, storedInstanceCopy);
		}
	}
	
	@Test
	void selectAll_return_a_copy_of_all_instance() {
		// Arrange
		final ModelMock[] INSTANCE_TO_STORE = { new ModelMock(), new ModelMock(), new ModelMock(), new ModelMock(), new ModelMock() };
		for (ModelMock item : INSTANCE_TO_STORE) {
			repository.insert(item);
		}
		
		// Act
		List<IModel> all = repository.selectAll();
		
		// Assert
		assertArrayEquals(INSTANCE_TO_STORE, all.toArray(new IModel[0]));
	}
	
	private void assertCopy(ModelMock base, ModelMock copy) {
		assertNotSame(base, copy);
		assertEquals(base, copy);
	}
}
