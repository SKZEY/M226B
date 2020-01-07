package M411.tas.ch.TBZ;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
	@SerializedName("data")
	@Expose
	List<SpecialBeer> data = new ArrayList<SpecialBeer>();
	
	public List<SpecialBeer> getData(){
		return data;
	}
	
	public void setData(List<SpecialBeer> listofBeer) {
		this.data = listofBeer;
	}
}
