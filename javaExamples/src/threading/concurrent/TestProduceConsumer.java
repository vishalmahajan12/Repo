package threading.concurrent;

import java.util.ArrayList;

import threading.Constants;

public class TestProduceConsumer {
	public static void main(String[] args) throws Exception {

		MessagePool messagePool = new MessagePool(Constants.BUFFER_SIZE);

		Produce produce = new Produce(messagePool);
		Consumer consumer = new Consumer(messagePool);

		produce.start();
		consumer.start();

	}
}

class MessagePool {
	int bufferSize;
	private ArrayList<String> msgPool = new ArrayList<String>();

	public MessagePool(int bufferSize) {
		super();
		this.bufferSize = bufferSize;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public synchronized void addMessageToPool(String msg) throws Exception {
		if (msgPool.size() == bufferSize) {
			wait();
			// throw new Exception("msg pool is full");
		}

		msgPool.add(msg);
		notifyAll();
	}

	public synchronized String getMessageFromPool() throws Exception {
		String msg = null;
		if (msgPool.size() == 0) {
			wait();
			// throw new Exception("msg pool is empty");
		}
		msg = msgPool.remove(0);
		notifyAll();
		return msg;

	}

}

/*
 * class Produce { String msg ; MessagePool messagePool;
 * 
 * public Produce(MessagePool messagePool) { super(); this.messagePool =
 * messagePool; }
 * 
 * 
 * public void produceMsg() throws Exception{ for(int i=0;i<10;i++) { msg =
 * i+""; messagePool.addMessageToPool(msg); } } }
 */

class Produce extends Thread {
	String msg;
	MessagePool messagePool;

	public Produce(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}

	@Override
	public void run() {
		try {
			produceMsg();
		} catch (Exception e) {
			System.out.println(e);
		}
		super.run();
	}

	public void produceMsg() throws Exception {
		for (int i = 0; i < Constants.BUFFER_SIZE; i++) {
			msg = i + "";
			System.out.println("produced : " + msg);
			messagePool.addMessageToPool(msg);
		}
	}
}

/*
 * class Consumer { MessagePool messagePool; public Consumer(MessagePool
 * messagePool) { super(); this.messagePool = messagePool; }
 * 
 * public void consumeMsg() throws Exception { for(int i=0;i<10;i++) {
 * System.out.println(messagePool.getMessageFromPool()); } } }
 */

class Consumer extends Thread {
	MessagePool messagePool;

	public Consumer(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}

	@Override
	public void run() {
		try {
			consumeMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.run();
	}

	public void consumeMsg() throws Exception {
		for (int i = 0; i < Constants.BUFFER_SIZE; i++) {
			System.out.println("consumed " + messagePool.getMessageFromPool());
		}
	}
}
