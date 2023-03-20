package com.example.helloworld;

class HelloMessageProvider {

	private final HelloNameProvider nameProvider;

	HelloMessageProvider(HelloNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	String getMessage() {
		return "Hello %s!".formatted(this.nameProvider.getName());
	}

}
