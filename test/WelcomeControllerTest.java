
public class WelcomeControllerTest {

	@test
	public void wantToCreateDog_shouldCall_ADogControllerMethod(){
		dogControllerMock dogController = new DogControllerMock();
		WelcomeController controller = WelcomeController();
		
		wantToCreateDog();
	}
}
