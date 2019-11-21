package interfaces;

public interface IFactory<T extends IModel> {
	T generate();
}
