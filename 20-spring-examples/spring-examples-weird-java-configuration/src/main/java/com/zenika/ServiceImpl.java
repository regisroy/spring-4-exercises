package com.zenika;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	private Repository repository;

	public ServiceImpl(Repository repository) {
		this.repository = repository;
	}

	@Override
	public String toString() {
		return "ServiceImpl{" +
			   "repository=" + String.valueOf(repository) +
			   '}';
	}

	@Override
	public String run() {
		String message = "ServiceImpl.run";
		System.out.println(message);

		return message;
	}
}
