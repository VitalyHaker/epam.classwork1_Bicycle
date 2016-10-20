package by.tc.classwork01.entity;

	public class Bike {

	    private int bike_id;
	    private String photo;
	    private int price;
	    private String category;
	    private String bike_name;
	    private int delete_status;

	    public Bike(int bike_id) {
	        this.bike_id = bike_id;
	        this.photo = "";
	        this.price = 0;
	        this.category = "MountaiBike";
	        this.bike_name = "";
	        this.delete_status = 0;
	    }

	    public Bike(int bike_id, String photo, int price,
	    		String category, String bike_name, int delete_status) {
	        this.bike_id = bike_id;
	        this.photo = photo;
	        this.price = price;
	        this.category = category;
	        this.bike_name = bike_name;
	        this.delete_status = delete_status;
	    }
	    public Bike(int price,String photo, 
	    		String category, String bike_name, int delete_status) {
	        this.photo = photo;
	        this.price = price;
	        this.category = category;
	        this.bike_name = bike_name;
	        this.delete_status = delete_status;
	    }

	    public Bike(int bike_id, String photo) {
	        this.bike_id = bike_id;
	        this.photo = photo;
	    }

	    public Bike(int bike_id, int price,
	    		String category, String bike_name, String photo) {
	        this.bike_id = bike_id;
	        this.price = price;
	        this.category = category;
	        this.bike_name = bike_name;
	        this.photo=photo;
	    }

	    public int getBike_id() {
	        return bike_id;
	    }

	    public void setBike_id(int bike_id) {
	        this.bike_id = bike_id;
	    }
	    

	    public String getCategory() {
	        return category;
	    }
	    
	    public void setCategory(String category) {
			this.category = category;
	    }
	    
	    public String getBike_name() {
	        return bike_name;
	    }
	    
	    public void setBike_name(String bike_name) {
			this.bike_name = bike_name;
		}
	    
	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getDelete_status() {
	        return delete_status;
	    }

	    public void setDelete_status(int delete_status) {
	        this.delete_status = delete_status;
	    }

	    public String getPhoto() {
	        return photo;
	    }

	    @Override
	    public String toString() {
	        return "Bike{" + "bike_id=" + bike_id + " photo=" + photo + ", price=" + price
	        		+ ", category=" + category + ", bike_name=" + bike_name+ ", delete_status="
	                + delete_status + '}';
	    }
	}


