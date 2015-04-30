package com.zenika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "unused", "SpringJavaAutowiredMembersInspection"})
public class ServiceDefault implements Service {

	private Repository repository;

	private StringBuilder recorder;

	public ServiceDefault(StringBuilder recorder) {
		this.recorder = recorder;
		recorder.append("Creation du bean " + this.getClass().getCanonicalName());
	}

	@Override
	public void whoAmI() {
		recorder.append("whoAmI()\n  Je suis " + this.getClass().getName() + " et j'ai comme dependance vers " + repository.getClass().getName()+"\n");
		repository.display();
	}

	@Autowired
	@Lazy
	public void setRepository(Repository repository) {
		this.repository = repository;
	}
}
