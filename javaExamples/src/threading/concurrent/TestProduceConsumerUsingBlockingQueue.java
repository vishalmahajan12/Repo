package threading.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProduceConsumerUsingBlockingQueue {
	public final static int BUFFER_SIZE = 200;

	public static void main(String[] args) throws Exception {

		MessagePool messagePool = new MessagePool(BUFFER_SIZE);

		Producer produce = new Producer(messagePool);
		Consumer consumer = new Consumer(messagePool);

		produce.start();
		consumer.start();

	}
}

class MessagePool {
	int bufferSize;
	private BlockingQueue msgPool;

	public MessagePool(int bufferSize) {
		super();
		this.bufferSize = bufferSize;
		msgPool = new LinkedBlockingQueue(bufferSize);
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void addMessageToPool(String msg) throws Exception {
		msgPool.put(msg);
	}

	public String getMessageFromPool() throws Exception {
		String msg = null;
		msg = (String) msgPool.take();
		return msg;

	}

}

class Producer extends Thread {
	String msg;
	MessagePool messagePool;

	public Producer(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}

	public void run() {
		try {
			produceMsg();
		} catch (Exception e) {
			System.out.println(e);
		}
		super.run();
	}

	public void produceMsg() throws Exception {
		for (int i = 0; i < TestProduceConsumerUsingBlockingQueue.BUFFER_SIZE; i++) {
			msg = i + "";
			System.out.println("produced : " + msg);
			messagePool.addMessageToPool(msg);
		}
	}
}

class Consumer extends Thread {
	MessagePool messagePool;

	public Consumer(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}

	public void run() {
		try {
			consumeMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.run();
	}

	public void consumeMsg() throws Exception {
		for (int i = 0; i < TestProduceConsumerUsingBlockingQueue.BUFFER_SIZE; i++) {
			System.out.println("consumed " + messagePool.getMessageFromPool());
		}
	}
}
