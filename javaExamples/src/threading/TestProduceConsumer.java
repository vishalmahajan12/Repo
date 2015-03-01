package threading;

import java.util.ArrayList;

public class TestProduceConsumer {
	public static void main(String[] args) throws Exception {
		
		int bufferSize=20;
		
		MessagePool messagePool = new MessagePool(bufferSize);
		
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

	public void addMessageToPool(String msg) throws Exception {
		if(msgPool.size() == bufferSize) {
			throw new Exception("msg pool is full");
		} else {
			msgPool.add(msg);
		}
	}

	public String getMessageFromPool() throws Exception {
		if(msgPool.size() == 0) {
			throw new Exception("msg pool is empty");
		} else {
			return msgPool.remove(0);
		}

	}

}

/*class Produce {
	String msg ;
	MessagePool messagePool;

	public Produce(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}


	public void produceMsg() throws Exception{
		for(int i=0;i<10;i++) {
			msg = i+"";
			messagePool.addMessageToPool(msg);
		}
	}
}*/

class Produce extends Thread{
	String msg ;
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
			System.out.println(e.getMessage());
		}
		super.run();
	}

	public void produceMsg() throws Exception{
		for(int i=0;i<20;i++) {
			msg = i+"";
			System.out.println("added : " + msg);
			messagePool.addMessageToPool(msg);
		}
	}
}

/*class Consumer {
	MessagePool messagePool;
	public Consumer(MessagePool messagePool) {
		super();
		this.messagePool = messagePool;
	}

	public void consumeMsg() throws Exception {
		for(int i=0;i<10;i++) {
			System.out.println(messagePool.getMessageFromPool());
		}
	}
}*/

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
			System.out.println(e.getMessage());
		}
		super.run();
	}

	public void consumeMsg() throws Exception {
		for(int i=0;i<20;i++) {
			System.out.println(messagePool.getMessageFromPool());
		}
	}
}
