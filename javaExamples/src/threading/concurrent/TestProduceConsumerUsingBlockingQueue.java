package threading.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import threading.Constants;

public class TestProduceConsumerUsingBlockingQueue {

	public static void main(String[] args) throws Exception {

		MessagePool messagePool = new MessagePool(Constants.BUFFER_SIZE);

		Producer produce = new Producer(messagePool);
		Consumer consumer = new Consumer(messagePool);

		produce.start();
		consumer.start();

	}

	static class MessagePool {
		int bufferSize;
		private BlockingQueue<String> msgPool;

		public MessagePool(int bufferSize) {
			super();
			this.bufferSize = bufferSize;
			msgPool = new LinkedBlockingQueue<String>(bufferSize);
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

	static class Producer extends Thread {
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
			for (int i = 0; i < Constants.BUFFER_SIZE; i++) {
				msg = i + "";
				System.out.println("produced : " + msg);
				messagePool.addMessageToPool(msg);
			}
		}
	}

	static class Consumer extends Thread {
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
			for (int i = 0; i < Constants.BUFFER_SIZE; i++) {
				System.out.println("consumed "
						+ messagePool.getMessageFromPool());
			}
		}
	}
}
