package com.training.bean;

public class UniformBean {
	private String Name;
	private String Description;
	private String Metatag;
	private String MetatagD;

	public UniformBean() {
	}

	public UniformBean(String Name, String Description,String Metatag,String MetatagD) {
		super();
		this.Name = Name;
		this.Description = Description;
		this.Metatag=Metatag;
		this.MetatagD=MetatagD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	public String getMetatag() {
		return Metatag;
	}

	public void setMetatag(String Metatag) {
		this.Metatag = Metatag;
	}
		public String getMetatagD() {
			return MetatagD;
		}

		public void setMetatagD(String MetatagD) {
			this.MetatagD = MetatagD;
		}
	@Override
	public String toString() {
		return "UniformBean [Name=" + Name + ", Description=" + Description + ", Metatag=" + Metatag +",MetatagD ="+ MetatagD +"]";
	}

}
