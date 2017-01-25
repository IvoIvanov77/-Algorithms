package fundamentals;

public class ResizingArrayDequeTest extends DequeTest{

	@Override
	protected Deque<String> createDeque() {
		// TODO Auto-generated method stub
		return new ResizingArrayDeque<>();
	}

}
