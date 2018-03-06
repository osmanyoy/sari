package com.training.patterns.creational.singleton;

public enum ESingleton implements IOperate {
	INSTANCE1("ins1") {
		@Override
		public String exec() {
			return "Exec Inner 1 :  " + getName2();
		}

	},
	INSTANCE2("ins2") {
		@Override
		public String exec() {
			return "Exec Inner 2 :  " + getName2();
		}

	};

	private String name2;

	private ESingleton(String name) {
		name2 = name;
	}

	@Override
	public String exec() {
		return "Exec :  " + getName2();
	}

	public void hello() {
		System.out.println("ENUM Singleton : " + getName2());
	}

	public String getName2() {
		return name2;
	}

}
