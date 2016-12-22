package lv.nixx.ne.model;

import java.util.Collection;

public class ValuesForControls {

	private Collection<String> channels;
	private Collection<String> sources;
	
	public ValuesForControls(){
	}
	
	public ValuesForControls(Collection<String> channels, Collection<String> source) {
		this.channels = channels;
		this.sources = source;
	}

	public Collection<String> getChannels() {
		return channels;
	}

	public Collection<String> getSources() {
		return sources;
	}

}
