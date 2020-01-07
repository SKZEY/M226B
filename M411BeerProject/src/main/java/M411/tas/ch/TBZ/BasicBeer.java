package M411.tas.ch.TBZ;

import com.google.gson.annotations.SerializedName;

public class BasicBeer {
	@SerializedName("id") 
	String id;
	@SerializedName("name") 
	String name;
	@SerializedName("description") 
	String description;
	
	public BasicBeer(String id, String name, String description) {
		this.id= id;
		this.name = name;
		this.description = description;
	}
	//Setter
	public void setID(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	//Getter
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return id+";"+name+";"+description;
	}

	
	
}
