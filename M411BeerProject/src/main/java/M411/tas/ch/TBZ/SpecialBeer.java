package M411.tas.ch.TBZ;

import com.google.gson.annotations.SerializedName;

public class SpecialBeer extends BasicBeer{
	@SerializedName("styleId") 
	String styleId;
	
	public SpecialBeer(String id, String name, String description, String idStyle) {
		super(id, name, description);
		this.styleId = idStyle;
	}
	
	public void setIdStyle(String idStyle) {
		this.styleId = idStyle;
	}
	
	public String getIdStyle() {
		return styleId;
	}
	
	@Override
	public String toString() {
		return id+";"+name+";"+description+";"+styleId;
	}
	
}
