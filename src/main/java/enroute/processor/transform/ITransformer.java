package enroute.processor.transform;

public interface ITransformer<S, D> {
	public D transform(S source);
}
