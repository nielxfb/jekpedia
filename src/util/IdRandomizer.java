package util;

import abstraction.IRandom;

public class IdRandomizer implements IRandom<String> {

	@Override
	public String random() {
		CharRandomizer ch = new CharRandomizer();
		return String.format("%c%c%c%c%c",
				ch.random(),
				ch.random(),
				ch.random(),
				ch.random(),
				ch.random());
	}

}
